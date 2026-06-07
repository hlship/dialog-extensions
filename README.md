# Dialog Extensions

This repository is a collection of small extension libraries for use with the
[Dialog](https://github.com/Dialog-IF/dialog) interactive fiction language.

* [Threaded Conversation](docs/conversation.md) - make NPCs more interactive with complex conversations
* [Scenes](docs/scenes.md)  - organize game logic
* [Tutorial Mode](docs/tutorial-mode.md) - give new players some help
* [roominfo command](docs/roominfo.md) - concise, hierarchical description of current room (for debugging)

# Compatibility

These extensions are tested against Dialog **1c01-1.2.2**.  You may encounter problems using other versions,
especially earlier versions, of Dialog and its standard library.

# Distribution

Simply copy the `lib/ext` folder into your repository.  Add `lib/ext` to your :library sources, 
and `lib/ext/debug` to your :debug sources.

Note that each individual library has a `%% dependencies:` comment at the top; if you choose to use just
a subset of the libraries in this repository, reference the comment as a guide to what other libraries you must
include.

# License

(c) 2019-present Howard M. Lewis Ship

Licensed under the terms of the Apache Software License 2.0.

Pull Requests are encouraged; by submitting a pull request, you are irrevocably assigning copyright for any submitted
materials to the repository owner, Howard Lewis Ship.
