
/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * 
 * package- Scripts- ButcherShopMap
 * class- butcherToTownScript: script action to enter the town from the butcher shop
 */
/* 
package Scripts.House1Map;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.*;

public class BrotherExGFScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCLockScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

     
        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToBrotherExGF", false));
                addScriptAction(new TextboxScriptAction() {{
                    addText("Hmm? Oh wait aren’t you Alex’s... what do you want? ...\noh you’re hoping to find him?... ");
                    addText("It’s hopeless, he’s been gone for months you’re not going \nto find anything.");
                    addText(" Now get out of here, you sicken me...", new String[] { "\"Offer to help\n\"", "\"Ignore her\"" });
                }});
             addScriptAction(new ChangeFlagScriptAction("hasTalkedToBrotherExGF", true));
            }});
        }});

        //option-offer to help play game
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
                    addText("Thank you... hmm.. Thinking about it maybe this page will\n help, it showed up on my desk one day. ");
                    addText("I know it’s your brother’s, it’s his handwriting. Maybe you\n can find him that way. ");
                    addText("Otherwise, maybe you can investigate the Mad Hatter- \nthe guy not the bar, me and your brother used to...");
                    addText("Do business with him let's say. He might know where\n he went off to. ");
                }});
            }});
            
            //option- ignore her
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new CustomRequirement() {
                    @Override
                    public boolean isRequirementMet() {
                        int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                        return answer == 1;
                    }
                });
                addScriptAction(new TextboxScriptAction("I don’t want to think about it... maybe the page I gave you\n can help. "));
            }});
        }});
        
               
        scriptActions.add(new NPCUnlockScriptAction());
        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}

*/

package Scripts.House1Map;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.*;
import Utils.Visibility;

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
                    addText("Hmm? Oh wait aren’t you Alex’s... what do you want? ...\noh you’re hoping to find him?... ");
                    addText("It’s hopeless, he’s been gone for months you’re not going \nto find anything.");
                    addText(" Now get out of here... unless... Hey are you good \nat crosswords? I'm stuck with this one...", new String[] { "\"Offer to help\n\"", "\"Ignore her\"" });
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
                addScriptAction(new ChangeFlagScriptAction("badGF", true));
                addScriptAction(new TextboxScriptAction("Thanks for nothing, go ask someone else like the \nmad hatter or something"));
                addScriptAction(new TextboxScriptAction("He's usually hanging around in some alley"));
                addScriptAction(new TextboxScriptAction("Now beat it, moron."));
            }});
        }});

        //after puzzle is solved
        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("exGfPuzzleSolved", true));
                addScriptAction(new TextboxScriptAction() {{
                    addText("Thank you... hmm. Thinking about it maybe this page will\nhelp, it showed up on my desk one day, it’s his handwriting...");
                    addText("Maybe you can find him that way, otherwise, maybe you \ncan investigate the Mad Hatter- the guy not the bar");
                    addText("Me and your brother used to... do business with him let's \nsay. He might know where he went off to. ");
                    addText("He's usually hanging out in an alley around town.");
                }});
            }});
        }});
        

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}