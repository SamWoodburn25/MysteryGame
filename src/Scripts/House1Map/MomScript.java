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

public class MomScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCLockScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

     
        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToButcher", false));
                addScriptAction(new TextboxScriptAction() {{
                    addText("Hey kiddo, sleep well? What’s your plan for the day??", new String[] { "\"Tell her\"", "\"Don't tell her\"" });
                }});
             addScriptAction(new ChangeFlagScriptAction("hasTalkedToButcher", true));
            }});
        }});

        //option-tell her
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
                    addText("Honey, you know it’s hopeless, the investigator on your\n brother’s case has found nothing for months ... ");
                    addText("I mean, you have your brother’s journal, maybe you can \nfind something in there.");
                    addText("Actually, here’s a page he left behind, maybe that could\n help you.");
                }});
            }});
            
            //option- Dont tell her 
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new CustomRequirement() {
                    @Override
                    public boolean isRequirementMet() {
                        int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                        return answer == 1;
                    }
                });
                addScriptAction(new TextboxScriptAction("Not much, huh? I see you’ve got your brother’s journal [j]\n, maybe reading it will help you feel better."));
                addScriptAction(new TextboxScriptAction("Hmm... maybe I’ll give the investigator a call to see how\n things are going... probably nothing as usual... huh? "));
                addScriptAction(new TextboxScriptAction("Nothing honey, carry on with your day, you’ve got to relax\n after you finally come back home. "));
            }});
        }});


        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToButcher", true));
                addScriptAction(new TextboxScriptAction() {{
                    addText("Well, I hope you have a nice day honey. Oh and if you could\n go stop by Max’s house at some point today.");
                    addText(" I’d greatly appreciate it. He’s right down the street!\n Thanks honey, please drop off the letter to Max soon! ");
                }});
            }});
        }});
        
               
        scriptActions.add(new NPCUnlockScriptAction());
        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}