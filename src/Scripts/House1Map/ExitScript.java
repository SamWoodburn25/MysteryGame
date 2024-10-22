package Scripts.House1Map;

import java.util.ArrayList;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import GameObject.Frame;
import Level.*;
import ScriptActions.*;
import Utils.Point;


// script for talking to dino npc
// checkout the documentation website for a detailed guide on how this script works
public class ExitScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {

        ArrayList<ScriptAction> scriptActions = new ArrayList<>();

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("canExit", true));
                addScriptAction(new ScriptAction() {
                    @Override
                    public ScriptState execute() {
                        // change current map int to the outside map (1)
                        map.setCurrMapInt(1);
                        System.out.println("exiting, setting to 1");
                        return ScriptState.COMPLETED;
                    }
                });

                addScriptAction(new ChangeFlagScriptAction("exitInteract", true));
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
                    map.setCurrMapInt(1);
                    scriptActions.add( new ChangeFlagScriptAction("recentlyTransitioned", true));
                    System.out.println("exiting, setting to 1");
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