package Scripts.House1Map;

/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * 
 * package- Scripts- ButcherShopMap
 * class- InvestigatorScript0: script action to talk to investigator by shop
 */

 import java.util.ArrayList;
 
 import Level.Script;
 import ScriptActions.*;
 
 public class InvestigatorScript0 extends Script {
 
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
                    addText("*On the phone*\nWhat??? You lost the suspect file??");
                    addText("Whereabouts? In the southeast region of town?");
                    addText("I am so sick of the department sending me idiots.\nCall me when you resolve this. Make it fast.");
                    addText("Oh.. it's you. So kid, you didn't hear any of that \nconversation right?");
                    addText("Good.");
                    addText("Run along now, you aren't getting anything \nout of me.");
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