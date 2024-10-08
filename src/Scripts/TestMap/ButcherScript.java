package Scripts.TestMap;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.*;

// script for talking to bug npc
// checkout the documentation website for a detailed guide on how this script works
public class ButcherScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCLockScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new TextboxScriptAction() {{
            addText("Peter:Welcome to Butcher Shop, how could I help you today? ");
            addText("Oh, you’re asking about your brother...? ");
            addText("Oh, we didn’t really talk much, sorry I can’t help you.");
            addText("Alex told you about me? Ah... yeah your brother wasn’t... \na very good friend.");
            addText("Honestly, he wasn’t a very good person at all.");
            addText("He ---- I know this is probably a lot to take in... hope that helps.");
            addText("I know maybe you want to keep quiet, but \nI really want to know what you're thinking right now.");
            addText("What do you think about that?", new String[] { "You don’t believe him ", "You tell him you’re sorry" });
        }});

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
                    addText("Peter: I know you don't believe me because of your face, \nbut I assure you I have no reason to lie.");
                }});
            }});

            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new CustomRequirement() {
                    @Override
                    public boolean isRequirementMet() {
                        int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                        return answer == 1;
                    }
                });
                
                addScriptAction(new TextboxScriptAction("Peter: I'm very sad too, I'm sure I didn't want it to be like this,\nbut it's the truth."));
            }});
        }});

        scriptActions.add(new NPCUnlockScriptAction());
        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}