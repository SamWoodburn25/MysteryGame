
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