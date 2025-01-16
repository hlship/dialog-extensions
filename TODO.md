# TODO

## TC

- Startup checks similar to Inform7 (prevent unexpected loops, etc.)
- Optimizations (that may only be needed in full size games)
- Tune the logic for in-thread vs. out-of-thread
- Multi-way conversation (e.g., other present NPCs may have queued quips)
- `(queue $Quip last for $NPC as $Precedence)`
- test for when (library links enabled)

## scenes

- Track when scenes start and `(scene $ in progress for $ turns)`
- Track when scenes complete and `(scene $ completed $ turns ago)`


## tutorial mode

- re-nag a non-performed suggestion after a while?
- use an off-stage container for performed suggestions (save a property)
- suggest-look: exclude (animate $), reads oddly
- test for when (library links enabled)
