package Scripts.House1Map;

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
            addText("Hey kiddo, hope you slept well. I’m about to head to work,\njust wanted to make sure you unpack from college");
            addText("If you are hungry, you can check the fridge (press space).");
            addText("Oh I see you found your brother’s journal (press j).");
            addText("No. I don’t know where he went but I’m not worrying about\nit, and you shouldn’t either.");
            addText("Why? Well after you left for college, Alex has been nothing\nbut cold and a pain for me.");
            addText("Look, I know how close you both were but don’t waste your\ntime.");
            addText("Ugh, you seriously aren’t going to let this go. Fine. Last\nthing I remember is him running out the door saying he");
            addText("was going to that friend Max’s. Go ask him he’d know more\nthan me.");
            }});
            addScriptAction(new ChangeFlagScriptAction("hasTalkedToMom", true));
            }});
        }});

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}