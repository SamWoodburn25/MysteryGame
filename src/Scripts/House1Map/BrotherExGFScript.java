package Scripts.House1Map;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.*;

// script for talking to walrus npc
// checkout the documentation website for a detailed guide on how this script works
public class BrotherExGFScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToGF", false));
                addScriptAction(new TextboxScriptAction() {{
                    addText("Jamie: Ew it is you. ");
                    addText("I thought I told your brother not to let you talk \nto me in public now that we aren’t together anymore. ");
                    addText("Well, what do you want and hurry up I don’t \nwant to be seen with you. ");
                    addText("Jamie: while you're still here, I'm stuck on this crossword");
                    addText("i just have a few left, then maybe after I can \nhelp out with your brother a bit more.", new String[] { "\"I'll help!\"", "\"No thanks\"" });
                }});
                addScriptAction(new ChangeFlagScriptAction("hasTalkedToGF", true));
            }});
        }});

        //script for puzzle trigger
        //option-yeah sure
        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new CustomRequirement() {
                    @Override
                    public boolean isRequirementMet() {
                        int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                        return answer == 0;
                    }
                });
                addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new ChangeFlagScriptAction("openExgfPuzzle", true));
                }});
            }});
            //option- no
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new CustomRequirement() {
                    @Override
                    public boolean isRequirementMet() {
                        int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                        return answer == 1;
                    }
                });
                addScriptAction(new TextboxScriptAction("Jamie: Oh, okay."));
            }});
        }});

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
