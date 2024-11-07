
package Scripts.House1Map;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.*;

// script for talking to butcher npc
public class ButcherScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCLockScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        //talking to the butcher, then change flag
        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToButcher", false));
                addScriptAction(new TextboxScriptAction() {{
                    addText("Peter: Welcome to Butcher Shop, how could I help you today? ");
                    addText("Oh, you’re asking about your brother...? ");
                    addText("Oh, we didn’t really talk much, sorry I can’t help you.");
                    addText("Alex told you about me? Ah... yeah your brother \nwasn’t... a very good friend.");
                    addText("Honestly, he wasn’t a very good person at all.");
                    addText("He tormented me, I know this is probably a lot to take \nin...  hope that helps.");
                    addText("I know maybe you want to keep quiet, but \nI really want to know what you're thinking right now.");
                    addText("What do you think about that?", new String[] { "\"Yeah sure\"", "\"I'm sorry\"" });
                }});
             addScriptAction(new ChangeFlagScriptAction("hasTalkedToButcher", true));
            }});
        }});
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
                    addText("Peter: I know you don't believe me because of your \nface, but I assure you I have no reason to lie.");
                }});
            }});
            //option- im sorry
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new CustomRequirement() {
                    @Override
                    public boolean isRequirementMet() {
                        int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                        return answer == 1;
                    }
                });
                addScriptAction(new TextboxScriptAction("Peter: I'm very sad too, I'm sure I didn't want it to be like \nthis, but it's the truth."));
            }});
        }});

        
        //script for puzzle trigger
        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToButcher", true));
                addScriptAction(new TextboxScriptAction() {{
                    addText("Peter: While you're here, do you want to help me? ");
                    addText("I have so many cuts of meat to weigh can you please help with some? \n Then maybe I can help out with your brother a bit more.", new String[] { "\"I'll help!\"", "\"No thanks\"" });
                }});
            }});
        }});
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
                    addScriptAction(new ChangeFlagScriptAction("openButcherPuzzle", true));
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
                addScriptAction(new TextboxScriptAction("Peter: Oh, okay."));
            }});
        }});

        //after puzzle is solved
         scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("butcherPuzzleSolved", true));
                addScriptAction(new TextboxScriptAction() {{
                    addText("Wow! thanks so much, check you're journal for a new clue \n(SENTENCE WILL BE CHANGED)");
                }});
            }});
        }});


        scriptActions.add(new NPCUnlockScriptAction());
        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}