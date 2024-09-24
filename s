[33mcommit 231daddb995f1b220b86720e229770be4555fe24[m[33m ([m[1;36mHEAD -> [m[1;32mmaster[m[33m)[m
Author: SunPikl <picklebreadz@gmail.com>
Date:   Mon Sep 23 15:33:17 2024 -0400

    mom sprite added

[33mcommit 04524e9b5a6c72132353add768711b512f86fcd8[m
Author: SunPikl <picklebreadz@gmail.com>
Date:   Mon Sep 23 15:32:45 2024 -0400

    added mom npc

[33mcommit f5c01baad6ac210e4cf902fd9b7340816db1e850[m[33m ([m[1;31morigin/master[m[33m, [m[1;31morigin/HEAD[m[33m)[m
Author: a-r-t <alexthimineur@gmail.com>
Date:   Sun Aug 18 13:55:49 2024 -0400

    build new default tile each time one is needed

[33mcommit c5655d650863f8fcb56b450f90144863a48c6c3c[m
Author: Alex Thimineur <alexthimineur@gmail.com>
Date:   Sun Aug 18 13:45:46 2024 -0400

    last minute updates (#17)

[33mcommit 0f9853de5fa15c93184151c2b6c589c18a43bc5c[m
Author: a-r-t <alexthimineur@gmail.com>
Date:   Wed Aug 7 23:39:22 2024 -0400

    updated comment

[33mcommit d0bf87e2ed858a6e59799e9e1d29072ac2f2aa63[m
Author: a-r-t <alexthimineur@gmail.com>
Date:   Tue Aug 6 22:10:15 2024 -0400

    fix font y pos on menu screen to be in line with selector

[33mcommit fecdb645393e8c0f65dd0b66eb8dd010bddc5810[m
Author: a-r-t <alexthimineur@gmail.com>
Date:   Tue Aug 6 20:42:40 2024 -0400

    fix sprite and animated sprite tostring method

[33mcommit 0230a737ecf9e081ef3b24475cda73c0bc2bdf16[m
Author: a-r-t <alexthimineur@gmail.com>
Date:   Tue Aug 6 20:08:04 2024 -0400

    quick docs update

[33mcommit ca83a6cccfc56b3b3419d3bf7e928f11274e8627[m
Author: Alex Thimineur <alexthimineur@gmail.com>
Date:   Tue Aug 6 00:49:09 2024 -0400

    Some bug fixes, cleanup, and documentation updates (#16)
    
    - Added extra row of tiles to the bottom of the TitleScreenMap in order to put a band-aid over the JFrame size inconsistency bug
    - JFrame size inconsistency bug added to documentation
    - Updated documentation to include new scripting engine, bug NPC, textbox options, etc.
    - Slight updates to various other documentation pages/links where needed
    - Changed all sprite fonts using "comic sans" font family to use "arial" isntead because I discovered that it was always using arial anyway as a default since "comic sans" doesn't actually exist (it's referred to as "comic sans ms" on Windows) -- I apparently don't know fonts at all.
    - Fixed bug where player wasn't actually center screen due to the calculations for the camera using the player's x/y at the top left corner rather than the midway points (can't believe I never noticed this).
    - Fixed bug in Sprite class where the bounds were at times incorrectly applying a scale.
    - Rearranged some code for organization purposes, added some comments, and removed some unused imports
    - might be a few other tiny things I forgot about...

[33mcommit 0a76c215b4d80c65dbd40df58a6cff657b891b55[m
Author: a-r-t <alexthimineur@gmail.com>
Date:   Fri Jun 28 21:03:35 2024 -0400

    fix spacing/indentation

[33mcommit 22ba259fe74e3b1369451ce2837fb46c7d2b23f7[m
Author: a-r-t <alexthimineur@gmail.com>
Date:   Fri Jun 28 20:51:09 2024 -0400

    fix indentation

[33mcommit 80581cb1e23bed248ba428791b08db8c9945666c[m
Author: Alex Thimineur <alexthimineur@gmail.com>
Date:   Tue May 28 23:30:07 2024 -0400

    fixed exception that sometimes happens when game is run (#14)

[33mcommit 740e48a363d5926f0ca9ef0376cd6001b528d8be[m
Author: Alex Thimineur <alexthimineur@gmail.com>
Date:   Tue May 28 22:51:02 2024 -0400

    overlaps renamed to touching (#13)
    
    * overlaps renamed to touching
    
    * remove unused imports
    
    * improve comment

[33mcommit fb3d37f6d02dff9c3a0a223d682f3a188f025ef2[m
Author: Alex Thimineur <alexthimineur@gmail.com>
Date:   Tue May 28 20:51:11 2024 -0400

    Overhaul interaction logic (#12)
    
    * updated interaction logic throughout the entire engine to be more natural, npcs can now be locked/unlocked in scripts alongside a new action performed method, bug now moves back and forth to showcase how the action performed methods for npcs work, fixed tree script to ensure player is in a valid spot location wise to interact with it successfully
    
    * made player interaction much more natural
    
    * clean up map collision handler
    
    * fix uncollidable map entities when it comes to collision checks against the player

[33mcommit b9c6a01e6cd04b90a7f5ac761bd2f976c182af53[m
Author: a-r-t <alexthimineur@gmail.com>
Date:   Mon May 27 19:20:23 2024 -0400

    fix glitch where script couldn't force player into proper walk animation

[33mcommit 87d2f2645215e64ce5927b90ddb66720a5b70163[m
Author: a-r-t <alexthimineur@gmail.com>
Date:   Thu May 23 23:36:12 2024 -0400

    remove unused sprites

[33mcommit 52ecf8d57c61b53e200fc3ee488c0867be31ca0c[m
Author: a-r-t <alexthimineur@gmail.com>
Date:   Thu May 23 23:31:26 2024 -0400

    remove commented out code

[33mcommit bf0fcb2349d6f91017f1c1f92060044545eb4820[m
Author: Alex Thimineur <alexthimineur@gmail.com>
Date:   Thu May 23 23:29:20 2024 -0400

    Scripting engine overhaul (#11)
    
    * do not draw if game loop is not active
    
    * script action initial implementation
    
    * new script action system implementation for more things
    
    * conditional script action groups work
    
    * fix crash in conditional script action if there is no action to carry out due to not group requirement being met
    
    * renamed script action package
    
    * generation default do nothing script action is more efficient
    
    * working on key press
    
    * setup script output manager
    
    * map active script is now shared between interact and trigger, update lost ball script to use script actions
    
    * dino script now uses script action system, added a ton of new script actions in order to make dino script implementable
    
    * implement tree script using script actions system, update requirement system in script actions to allow for custom requirements
    
    * this time actually fixed the paint order startup bug that would sometimes print that long error
    
    * add bug to game
    
    * setup script in npc script actions for grabbing default entity
    
    * fix walrus script
    
    * fix walrus script...again
    
    * added textbox selection capabilities
    
    * refactored preloading scripts, added support for both preloading scripts and dynamically loading scripts
    
    * moved bug npc to a more ideal location
    
    * options textbox now properly works when textbox is on top of window
    
    * refactored textbox to make it cleaner
    
    * remove unused file

[33mcommit 0d7c7c1c82e6604556f03ee4ea43b85ebe1132a8[m
Author: Marcus Ferreira <131907940+doubleupdingo@users.noreply.github.com>
Date:   Thu May 23 23:14:26 2024 -0400

    Fixed crash in mapeditor with differently sized tilesets (#10)

[33mcommit aeed481adfa2aa761bae3d4c9d763c0d84309f78[m
Author: a-r-t <alexthimineur@gmail.com>
Date:   Sat Oct 7 14:35:41 2023 -0400

    fix bug where player cannot interact with map entities that have their isUncolliable flag set

[33mcommit 5ad56c9ffb42e57d026ea007cafc898ad9bbc143[m
Author: Alex Thimineur <alexthimineur@gmail.com>
Date:   Wed Sep 20 02:07:30 2023 -0400

    Update map-editor.md

[33mcommit d0bbd1e7bfaf0e452710d961872cc2d9bd0fbd50[m
Author: a-r-t <alexthimineur@gmail.com>
Date:   Mon Sep 4 16:48:58 2023 -0400

    update docs title

[33mcommit a106864d21dd75c478bf7e420617d083e3e66bf5[m
Author: a-r-t <alexthimineur@gmail.com>
Date:   Mon Sep 4 15:32:47 2023 -0400

    adjust order of operations when setting up and starting game

[33mcommit 8952095bbc310fdae0cf1195ae5a3eb7edaf882a[m
Author: a-r-t <alexthimineur@gmail.com>
Date:   Sun Sep 3 23:18:01 2023 -0400

    updated documentation

[33mcommit 91cbb31386e5717635babb931129f61706301e9c[m
Author: a-r-t <alexthimineur@gmail.com>
Date:   Sun Sep 3 21:27:49 2023 -0400

    update documentation

[33mcommit d9c4db8f9f10a00b64df8afc231e33f386e39899[m
Author: a-r-t <alexthimineur@gmail.com>
Date:   Sat Sep 2 22:48:52 2023 -0400

    remove unused getter

[33mcommit 128a67013c19b8bb2e24d49080a226e8ca971a24[m
Author: a-r-t <alexthimineur@gmail.com>
Date:   Sat Sep 2 22:33:35 2023 -0400

    update information in docs about frame timers

[33mcommit 0d1db972eb84e3929ba5e4a652887f6bf274a51b[m
Author: a-r-t <alexthimineur@gmail.com>
Date:   Sat Sep 2 20:53:48 2023 -0400

    fixed up faqs page

[33mcommit 44aaa1f0771e7de5b72218bcd8eb95674db54313[m
Author: a-r-t <alexthimineur@gmail.com>
Date:   Sat Sep 2 20:52:10 2023 -0400

    add favicon to website

[33mcommit f9c6765902027442b8737a4e9125387b00f86162[m
Author: a-r-t <alexthimineur@gmail.com>
Date:   Sat Sep 2 20:48:53 2023 -0400

    updated website documentation with game loop changes and faqs section

[33mcommit f4c62aa08dfd2284363ac08f3e69f3512562c44f[m
Author: Alex Thimineur <alexthimineur@gmail.com>
Date:   Sat Sep 2 16:56:04 2023 -0400

    Animation delay use frames, game loop updates (#9)
    
    * update animations to use frame delay instead of ms delay, remove unused imports
    
    * updated scripting system to have wait time be in frames instead of ms
    
    * menu screen uses key press timer in frames instead of ms
    
    * game loop updates

[33mcommit 9c28cc307a719f2d7d19139799c232e1c69f759d[m
Author: a-r-t <alexthimineur@gmail.com>
Date:   Sat Sep 2 00:46:47 2023 -0400

    fix game loop to sleep if time leftover to give back cpu -- makes game use up WAY less CPU re

[33mcommit ed05cc7ae93be1b23995335d8a0160bfc0c22798[m
Author: a-r-t <alexthimineur@gmail.com>
Date:   Mon Aug 28 19:47:35 2023 -0400

    documentation update

[33mcommit 34198e6997f8b41754e8ef428ced872f57d0245b[m
Author: a-r-t <alexthimineur@gmail.com>
Date:   Mon Aug 28 16:51:58 2023 -0400

    updated documentation

[33mcommit 7d0c7616947e8a1972fd74de54740e6cf22dfee1[m
Author: a-r-t <alexthimineur@gmail.com>
Date:   Sun Aug 27 15:20:21 2023 -0400

    typo:

[33mcommit 1043501220c4cd0e87ceb5f3e3d836e52cfa4c39[m
Author: a-r-t <alexthimineur@gmail.com>
Date:   Sun Aug 27 15:19:12 2023 -0400

    update var name

[33mcommit a78be06a8fba5650c9fcb8b4dfc35527f6c94fdb[m
Author: a-r-t <alexthimineur@gmail.com>
Date:   Thu Aug 24 20:10:45 2023 -0400

    added feature to allow an entity to make itself 'uncolliable' -- aka other entities will not consider it when checking for collision

[33mcommit 38be532e4417f9c577f9c644aed049d912cd87a4[m
Author: Alex Thimineur <alexthimineur@gmail.com>
Date:   Thu Aug 24 19:28:46 2023 -0400

    SpriteFont update -- now draws with respect to font ascent, which makes it way easier to position (it now draws from top left corner instead of Java's default of bottom left) (#8)

[33mcommit 41043e24fbab839a35f970a7717737bd128a8806[m
Author: Alex Thimineur <alexthimineur@gmail.com>
Date:   Thu Aug 24 18:53:56 2023 -0400

    Game Loop tweaks, added FPS display (#7)
    
    * notch game loop used
    
    * implemented notch game loop
    
    * rewmoved remnants of old game loop
    
    * formatting
    
    * more comment updating
    
    * tweaked game loop further, fps can now be displayed

[33mcommit cc6b0178a116b1eeb8e97aed8c98780dd906d5c1[m
Author: Alex Thimineur <alexthimineur@gmail.com>
Date:   Thu Aug 24 00:24:47 2023 -0400

    Better game loop (#5)
    
    * notch game loop used
    
    * implemented notch game loop
    
    * rewmoved remnants of old game loop
    
    * formatting
    
    * more comment updating

[33mcommit 690bc37793b12d565ecdbd3625983a92b9434a06[m
Author: a-r-t <alexthimineur@gmail.com>
Date:   Wed Aug 23 23:51:45 2023 -0400

    fixed major glitch where rock wasn't pushable and end game tree could be spoken to without moving rock -- collateral from the x2/y2 update

[33mcommit 834d9e5500ab3592ad9f1ebb5f6e62d896d140fb[m
Author: a-r-t <alexthimineur@gmail.com>
Date:   Sun Aug 20 17:47:27 2023 -0400

    clean up game object

[33mcommit 6292a231e4296f78f1241812970fdd2c53509202[m
Author: a-r-t <alexthimineur@gmail.com>
Date:   Sat Aug 19 23:44:51 2023 -0400

    calculate amount moved correctly factoring in remainder

[33mcommit 16db06becc563e228c34d8afd5dbcd984d8d1d5a[m
Author: Alex Thimineur <alexthimineur@gmail.com>
Date:   Sat Aug 19 23:04:41 2023 -0400

    Update collision engine (#4)
    
    * port over collision updates from platformer game
    
    * better organization in Sprite class
    
    * fix collisions
    
    * merge

[33mcommit c3e7043dc609e41cb0ffd68c8f483b45af15e3be[m
Author: a-r-t <alexthimineur@gmail.com>
Date:   Sat Aug 19 22:37:48 2023 -0400

    add bounds drawing options for tiles

[33mcommit 407102376721e01f600fb8c037b767d0a4b2a86a[m
Author: Alex Thimineur <alexthimineur@gmail.com>
Date:   Sat Aug 19 13:37:23 2023 -0400

    fix issue where white (255, 255, 255) was showing up as transparent (#3)

[33mcommit 29add68681b919a36979d6e0c2b110046e12df99[m
Author: Garrett Goldberg <98359240+gegoldberg@users.noreply.github.com>
Date:   Tue Nov 15 19:38:54 2022 -0500

    Update TilePicker.java (#2)

[33mcommit 854ef5185c32911d346ce6b9c05201e259a5c5b5[m
Author: Alex Thimineur <alexthimineur@gmail.com>
Date:   Fri Nov 11 13:38:57 2022 -0500

    Update .gitignore

[33mcommit 560b855cc90ad31de4656ab8880eeeefd0a2b851[m
Author: a-r-t <alexthimineur@gmail.com>
Date:   Sun Aug 28 12:00:43 2022 -0400

    fix site wording

[33mcommit 28cf9889e459b107e67cb2936d8fa04f03916f01[m
Author: a-r-t <alexthimineur@gmail.com>
Date:   Sat Aug 27 20:50:21 2022 -0400

    update readme

[33mcommit 99504bff365131c8d7042689b2c3c21649f8a317[m
Author: Alex Thimineur <alexthimineur@gmail.com>
Date:   Sat Aug 27 20:43:02 2022 -0400

    Convert old platformer game into an rpg game (#1)
    
    * player can walk around map like an rpg, new tiles, textbox works, can inject scripts into map tiles
    
    * can talk to npcs, textbox goes on top screen if camera is at bottom
    
    * added methods to camera to check if it is at the edge of the map
    
    * npcs have collision
    
    * npcs and player draw order works
    
    * fixed interaction range bug where right and down did not work
    
    * layered tiling works
    
    * base script implementation
    
    * modularizaed event stuff
    
    * check additionally to ensure event is an interact event
    
    * load script from within npc subclass
    
    * dinosaur script works
    
    * cleaned up dino script
    
    * updated hiding an npc
    
    * part one of getting rock to be moveable
    
    * moving rock finished
    
    * tree hole script
    
    * separate scripts up into separate classes
    
    * flag manager refactor
    
    * make rock enchanced map tile use its own image to separate it from the tileset one
    
    * fixed common tileset orientation, added mushroom tile
    
    * no longer have to pass map and player into every script functoin
    
    * simplified script class
    
    * removed event package since it is no longer needed
    
    * deleted/removed unused files
    
    * attach entity to script
    
    * trigger script works
    
    * trigger scripts placed on map in correct spot, collisions now do not push player back if they collide with a trigger
    
    * make make editor resizable
    
    * map editor cna now optionall show npcs, enhanced map tiles, and triggers
    
    * map editor is now resizable and has options to show npcs/triggers/enhanced map tiles, map now sets player location rather than starting tile for more flexibility
    
    * made code a bit cleaner
    
    * add common stand and walk methods for all game objects to be used with scripting system
    
    * updated title screen map, fixed walk and stand methods in player/npc
    
    * separate method for handling player animation, move cat on title screen
    
    * existence flags to map entities
    
    * interaction limits
    
    * player bounds interaction fixed
    
    * cleaned up code, fixed map collisiojns, fixed tile retrieval code
    
    * made a win screen
    
    * updating comments
    
    * major class constructor cleanup
    
    * added more comments
    
    * optimize imports
    
    * more commenting
    
    * player start facing left
    
    * added new Frame constructor that doesn't require a delay param
    
    * additional Frame constructor, comment Camera class better
    
    * animated tiles and currently active script are stored and kept track of to make camera update logic more efficient, fixed interaction code logic to properly detect player bounds against an interactable and also not trigger an interactable script unless the player's last moving direction was towards it
    
    * updated site to the current state of it from the other game to use as a base
    
    * updated site
    
    * updated site
    
    * update site
    
    * update site
    
    * started but didn't finish triggers and scripts site page
    
    * cleaned up unused site assets, added more site pages like triggers
    
    * renamed SimpleTextInteractScript to SimpleTextScript, updated site
    
    * site updates, removing unused code from Player class
    
    * fix map editor issue where editor window needed to be validated after menu strip was added
    
    * update site
    
    * update site
    
    * update site folder paths and readme urls:

[33mcommit aaf88ae3d94bdb9d48cf218e16b1481a52a13be0[m
Author: a-r-t <alexthimineur@gmail.com>
Date:   Wed Aug 3 20:23:09 2022 -0400

    initial commit
