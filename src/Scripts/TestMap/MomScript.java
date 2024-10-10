package Scripts.TestMap;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.*;

// script for talking to mom npc
// checkout the documentation website for a detailed guide on how this script works
public class MomScript extends Script {
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());
        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
            addRequirement(new FlagRequirement("hasTalkedToMom", false));
            addScriptAction(new TextboxScriptAction() {{
            addText("Mom: Hey kiddo, hope you slept well.");
            //addText("You can check the fridge (press space) to see if \nyou’re hungry at all.");
            addText("I’m headed to work  in a few, just wanted to make sure \nyou ate breakfast before I left…");
            addText("You can check the fridge (press space) to see if you’re \nhungry at all.");
            addText("Ah I see you still have your brother’s journal (press j).");
            addText("I know you miss him honey, hopefully he’ll show up \nsome time or another");
            addText("Poor thing, I miss him too. I know how close you \nboth were.");
            addText("Take care my child, don’t forget to enjoy your time\n back from school.");
            }});
            addScriptAction(new ChangeFlagScriptAction("hasTalkedToMom", true));
            addScriptAction(new TextboxScriptAction("Character:Okay, thank you mom. See you after school"));
            }});
        }});

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}