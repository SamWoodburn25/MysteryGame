package Scripts.House1Map;

/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * 
 * package- Scripts- ButcherShopMap
 * class- InvestigatorScript1: script action to talk to investigator by cemetery
 */


 import java.util.ArrayList;
 
 import Level.Script;
 import ScriptActions.*;
 
 // script for talking to bug npc
 // checkout the documentation website for a detailed guide on how this script works
 public class InvestigatorScript1 extends Script {
 
     @Override
     public ArrayList<ScriptAction> loadScriptActions() {
         ArrayList<ScriptAction> scriptActions = new ArrayList<>();
         scriptActions.add(new LockPlayerScriptAction());
 
         scriptActions.add(new NPCLockScriptAction());
 
         scriptActions.add(new NPCFacePlayerScriptAction());
 
         scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToInvestigator", false));
                addScriptAction(new TextboxScriptAction() {{
                    addText("Hey kid, this is still an ongoing investigation.");
                    addText("What's in the cemetery you ask?");
                    addText("Nothing you should be worrying about that's what.");
                    addText("Now scram. My team and I are busy debugging \nthe entrance's cypher.");
                }});
                addScriptAction(new ChangeFlagScriptAction("hasTalkedToInvestigator", true));
            }});
        }});
    
         //script for additional info trigger
        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToInvestigator", true));
                addScriptAction(new TextboxScriptAction() {{
                    addText("I thought I told you to leave me alone.");
                }});
            }});
        }});
         scriptActions.add(new NPCUnlockScriptAction());
         scriptActions.add(new UnlockPlayerScriptAction());
 
         return scriptActions;
     }
 }