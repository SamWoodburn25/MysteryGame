package Scripts.House1Map;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.*;

// script for talking to walrus npc
// checkout the documentation website for a detailed guide on how this script works
public class BrotherScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addScriptAction(new TextboxScriptAction() {{
                addRequirement(new FlagRequirement("lieMom", true));
                addRequirement(new FlagRequirement("badButcher", true));
                addRequirement(new FlagRequirement("badGF", true));
                addRequirement(new FlagRequirement("badDD", true));

                addScriptAction(new TextboxScriptAction("..Help"));
                    //good ending (join him) cuscene    
                addScriptAction(new ChangeFlagScriptAction("joinScreen",true));
                }});
            }});

            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                
                addScriptAction(new TextboxScriptAction("...Die"));
                addScriptAction(new ChangeFlagScriptAction("deathScreen",true));
                //bad ending (die) cutscene
            }});
        }});

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
