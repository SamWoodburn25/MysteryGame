/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * 
 * package- Scripts- ButcherShopMap
 * class- butcherToTownScript: script action to enter the town from the butcher shop
 */

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
                    addText("It’s hopeless, he’s been gone for months you’re not going to find anything.");
                    addText(" Now get out of here, you sicken me...", new String[] { "\"Offer to help play game\n\"", "\"Ignore her\"" });
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
                    addText("hank you... hmm.. Thinking about it maybe this page will\n help, it showed up on my desk one day, I know it’s your brother’s, it’s his handwriting. ");
                    addText("Maybe you can find him that way, otherwise, maybe you can\n investigate the Mad Hatter- the guy not the bar, me and your brother used to...");
                    addText("Do business with him let's say. He might know where he went\n off to. ");
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
                addScriptAction(new TextboxScriptAction("I don’t want to think about it... maybe the page I gave you can help. "));
            }});
        }});
        
               
        scriptActions.add(new NPCUnlockScriptAction());
        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}