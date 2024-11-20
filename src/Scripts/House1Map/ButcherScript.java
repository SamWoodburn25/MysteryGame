
package Scripts.House1Map;
/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * 
 * package- Scripts
 * class- ButcherScript: script with peter
 */

import java.util.ArrayList;

import Game.GameState;
import Game.ScreenCoordinator;
import Level.Script;
import ScriptActions.*;
import Utils.Visibility;
import Engine.ScreenManager;

public class ButcherScript extends Script {
    private int push = 1;
    protected ScreenCoordinator screenCoordinator;

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCLockScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        //script for puzzle trigger
        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToButcher", false));
                addRequirement(new FlagRequirement("butcherPuzzleSolved", false));
                addScriptAction(new TextboxScriptAction() {{
                    addText("Hmm... how can I package this... ugh I hate math...\nWelcome to the Butcher’s Shoppe, what can I help you with?");
                    addText("Oh... I don’t know who you’re talking about, sorry!   ");
                    addText("Erm sorry I’m busy running the shop and Alex-");
                    addText("I don’t know whoever you’re talking about, if you’re\n not going to get anything please leave... ", new String[] { "\"Help him\"", "\"ignore him\"" });
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
                addRequirement(new FlagRequirement("butcherPuzzleSolved", false));
                addRequirement(new FlagRequirement("hasTalkedToButcher", false));
                addScriptAction(new TextboxScriptAction("Hmm? You want to help me? Well alright, we just need to \nweigh some meats..."));
                addScriptAction(new TextboxScriptAction() {{
                    addScriptAction(new ChangeFlagScriptAction("openButcherPuzzle", true));
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
                addRequirement(new FlagRequirement("hasTalkedToButcher", false));
                addScriptAction(new TextboxScriptAction("..."));
            }});
        }});

        //after puzzle is solved
         scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("butcherPuzzleSolved", true));
                addRequirement(new FlagRequirement("hasTalkedToButcher", false));
                addScriptAction(new ChangeFlagScriptAction("hasTalkedToButcher", true));
                addScriptAction(new TextboxScriptAction() {{
                    addText("Alright fine, since you helped me out... Your brother, Alex...\n he.. He wasn’t a good person.");
                    addText("He was always playing his “jokes” on me, keeping me \naround for his and his friends amusement.");
                    addText("One day he took it too far, I almost died... \nwell anyways that’s why I don’t want to talk about him.... ", new String[] { "\"That’s awful\"", "\"Push for more\"" });
                }});
             
            }});
        }});

        //pushing
        scriptActions.add(new ConditionalScriptAction() {{
            //option- Thats awful
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new CustomRequirement() {
                    @Override
                    public boolean isRequirementMet() {
                        int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                        return answer == 0;
                    }
                });
                addRequirement(new FlagRequirement("hasTalkedToButcher", true));
                addScriptAction(new TextboxScriptAction() {{
                    addText(" Yeah... anyways here’s a letter that had his name on it.");
                    addText("I didn’t want to open it in case it was from him,\n I’ve had enough of his bullshit.");
                    addText("Or you can try the car garage, remembered seeing\n him working there a few times.");
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
                addRequirement(new FlagRequirement("hasTalkedToButcher", true));
                addScriptAction(new TextboxScriptAction() {{
                    addText("Oh... um I don’t really feel comfortable sharing, \nhe liked hunting and stuff maybe that can be a clue?");
                    addText("Or the car shop he worked at? Is that helpful?");
                    addText("Please stop, I don’t want to think about him anymore, ok?", new String[] { "\"That’s awful\"", "\"Push for more\"" });
                }});
            }});

            

    
        }});

        //pushed to the limit
        scriptActions.add(new ConditionalScriptAction() {{
            //option- Thats awful
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new CustomRequirement() {
                    @Override
                    public boolean isRequirementMet() {
                        int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                        return answer == 0;
                    }
                });
                addRequirement(new FlagRequirement("hasTalkedToButcher", true));
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
                addRequirement(new FlagRequirement("hasTalkedToButcher", true));
                addScriptAction(new TextboxScriptAction("YOU KNOW WHAT... Come with me, I can show you \nEXACTLY what he did to me."));
                addScriptAction(new ChangeFlagScriptAction("badButcher", true));
            }});

        }});

        //script for puzzle trigger
        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToButcher", true));
                addRequirement(new FlagRequirement("butcherPuzzleSolved", true));
                addRequirement(new FlagRequirement("badButcher", true));
                addScriptAction(new TextboxScriptAction() {{
                    addText("Your brother thought it was funny to trap me here \nin this freezer... it was so cold");
                    addText("Don't you see how I could never want to think of him again?!", new String[] { "\"Push him\"" });
                    addText("***AAAAAA***");
                    //addScriptAction(new ChangeFlagScriptAction("butcherDeath", true));

                    // screenCoordinator.setGameState(GameState.PETERDEATH);
                }});
                addScriptAction(new NPCChangeVisibilityScriptAction(Visibility.HIDDEN));
                addScriptAction(new ChangeFlagScriptAction("butcherDeath", true));
                
            }});
        }});
                


        scriptActions.add(new NPCUnlockScriptAction());
        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}