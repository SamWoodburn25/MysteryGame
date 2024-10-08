package Scripts.TestMap;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.*;

// script for talking to bug npc
// checkout the documentation website for a detailed guide on how this script works
public class DrugDealer extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCLockScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new TextboxScriptAction() {{
            addText("Please! Help my father!");
            addText("Do you have a phone? Call 911!", new String[] { "Call 911", "Tell her to do it herself" });
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
                    addText("Let’s describe our location and help us right now  ");
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
                
                addScriptAction(new TextboxScriptAction("Are you kidding? My dad's dying here. Give me the phone."));
                addScriptAction(new TextboxScriptAction("I'll call him and take care of it."));
                addScriptAction(new TextboxScriptAction("Calling 911... My father is very bad we are waiting for you to come immediately."));
            }});
        }});

        scriptActions.add(new NPCUnlockScriptAction());
        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}