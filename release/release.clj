(ns release
  "Support for releasing new versions of dexter."
  (:require [clj-commons.ansi :refer [pout perr]]
            [selmer.parser :as selmer]
            [babashka.process :as p]
            [babashka.fs :as fs]
            [clojure.string :as string]))

(defn sh
  [& commands]
  (let [base-opts {:err :string}
        [opts commands'] (if (-> commands first map?)
                           [(first commands) (rest commands)]
                           [nil commands])
        final-opts (merge base-opts opts)
        _ (when-not (:quiet? final-opts)
            (pout [:blue (string/join " " commands')]))
        {:keys [exit out err]} (apply p/shell final-opts commands')]
    (when-not (zero? exit)
      (perr [:red "Command failed (" exit "): "]
            [:bold err]))
    (if (string? out)
      (string/trim out)
      out)))

(defn render-template
  [source-file dest-file context]
  (let [content (selmer/render-file source-file context)]
    (spit dest-file content)))

(defn package
  "Packages distribution files into a zip; the file is returned."
  [tag]
  (let [out-dir  (fs/file "out")
        zip-file (fs/file out-dir (str "dialog-extensions-" tag ".zip"))]
    (fs/delete-tree out-dir)
    (fs/create-dirs out-dir)
    (perr "Writing: " [:bold zip-file] " ...")
    (fs/zip zip-file
            ["LICENSE"
             "README.md"
             "CHANGES.md"
             "lib/ext" ])
    zip-file))

(defn sha256
  [zip-file]
  (-> (sh {:out :string
           :quiet? true}
          "shasum --algorithm 256 --binary" zip-file)
      (string/split #"\s+")
      first))
