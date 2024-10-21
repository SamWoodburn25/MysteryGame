/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * 
 * package- Scripts- MyMap
 * class- enter home script: script action to enter the main home
 */

package Scripts.MyMap;

import java.util.ArrayList;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import GameObject.Frame;
import Level.*;
import ScriptActions.*;
import Utils.Point;


// script for talking to dino npc
// checkout the documentation website for a detailed guide on how this script works
public class EnterHomeScript extends Script {
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {

        ArrayList<ScriptAction> scriptActions = new ArrayList<>();

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                //addScriptAction(new ChangeFlagScriptAction("exitInteract", false));
                addRequirement(new FlagRequirement("canEnter", true));
                addScriptAction(new ScriptAction() {
                    @Override
                    public ScriptState execute() {
                        // change current map int to the outside map (1)
                        map.setCurrMapInt(0);
                        System.out.println("entering, setting to 0");
                        return ScriptState.COMPLETED;
                    }
                });

                addScriptAction(new ChangeFlagScriptAction("enteringHome", true));
            }});
        }});

        scriptActions.add(new UnlockPlayerScriptAction());
        return scriptActions;
    };


    /* 
            public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new ScriptAction() {
            @Override
            public ScriptState execute() {
                if (!map.getFlagManager().isFlagSet("recentlyTransitioned")) {
                    map.setCurrMapInt(0);
                    scriptActions.add( new ChangeFlagScriptAction("recentlyTransitioned", true));
                    System.out.println("exiting, setting to 0");
                    return ScriptState.COMPLETED;
                }
                return ScriptState.RUNNING;
            }
        });
        scriptActions.add(new UnlockPlayerScriptAction());
        return scriptActions;
    }

    */


};