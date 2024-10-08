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
            addText(" My son, I need to tell you something... ");
            addText("..Your brother has been missing since yesterday. ");
            addText("The police have been searching since yesterday but... ");
            addText("They haven't found him and I think we can't hide it from you anymore.");
            }});
            addScriptAction(new ChangeFlagScriptAction("hasTalkedToMom", true));
            }});

            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToMom", true));
                addScriptAction(new TextboxScriptAction("That's why I want you to call your brother for me too"));
                addScriptAction(new TextboxScriptAction("I trust you..."));
                }});
            }});

            scriptActions.add(new UnlockPlayerScriptAction());

            return scriptActions;
        }
}