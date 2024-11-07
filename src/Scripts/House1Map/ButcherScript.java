
package Scripts.House1Map;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.*;

public class ButcherScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCLockScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        //script for puzzle trigger
        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToButcher", true ));
                addRequirement(new FlagRequirement("hasTalkedToButcher", false));
                addScriptAction(new TextboxScriptAction() {{
                    addText("Hmm... how can I package this... ugh I hate math...\nWelcome to the Butcher’s Shoppe, what can I help you with?");
                    addText("Oh... I don’t know who you’re talking about, sorry!   ");
                    addText("Erm sorry I’m busy running the shop and Alex");
                    addText("I don’t know whoever you’re talking about, if you’re not going to get anything please leave... ", new String[] { "\"Help him\"", "\"ignore him\"" });
                }});
            }});
        }});
        //option-Ask if he need 
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
                    addScriptAction(new ChangeFlagScriptAction("openButcherPuzzle", false));
                }});
            }});
            //option- ignore him 
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new CustomRequirement() {
                    @Override
                    public boolean isRequirementMet() {
                        int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                        return answer == 1;
                    }
                });
                addScriptAction(new TextboxScriptAction("Oh, okay. If you're ignoring me, what are you waiting for?\n Get out of my butcher, please!!!"));
            }});
        }});

        //after puzzle is solved
         scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("butcherPuzzleSolved", false));
                addScriptAction(new TextboxScriptAction() {{
                    addText("Alright fine, since you helped me out... Your brother, Alex...\n he.. He wasn’t a good person.");
                    addText("He was always playing his “jokes” on me, keeping me \naround for his and his friends amusement.");
                    addText("One day he took it too far, I almost died in.. There *shutters* \nwell anyways that’s why I don’t want to talk about him.... ", new String[] { "\"That’s awful\"", "\"Push for more\"" });
                }});
             addScriptAction(new ChangeFlagScriptAction("hasTalkedToButcher", false));
            }});
        }});

        //option-That’s awful
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
                    addText(" Yeah... anyways here’s a letter that had his name on it.");
                    addText("I didn’t want to open it in case it was from him,\n I’ve had enough of his bullshit.");
                }});
            }});

            //option-Push for more
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new CustomRequirement() {
                    @Override
                    public boolean isRequirementMet() {
                        int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                        return answer == 1;
                    }
                });
                addScriptAction(new TextboxScriptAction("Oh... um I don’t really feel comfortable sharing, if anything \nmaybe you  can look into his stuff."));
                addScriptAction(new TextboxScriptAction("He liked hunting and stuff maybe that can be a clue? \nPlease stop, I don’t want to think about it anymore, ok?"));
                addScriptAction(new TextboxScriptAction("YOU KNOW WHAT... Come with me, I can lead you \nEXACTLY to where he tried to kill me... *last page given* "));

            }});
        }});
                


        scriptActions.add(new NPCUnlockScriptAction());
        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}