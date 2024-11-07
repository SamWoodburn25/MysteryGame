package Scripts.House1Map;

/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * 
 * package- Scripts- ButcherShopMap
 * class- butcherToTownScript: script action to enter the town from the butcher shop
 */

 import java.util.ArrayList;
 
 import Level.Script;
 import ScriptActions.*;
 
 public class DrugDealerDaughterScript extends Script {
 
     @Override
     public ArrayList<ScriptAction> loadScriptActions() {
         ArrayList<ScriptAction> scriptActions = new ArrayList<>();
         scriptActions.add(new LockPlayerScriptAction());
 
         scriptActions.add(new NPCLockScriptAction());
 
         scriptActions.add(new NPCFacePlayerScriptAction());
 
      
         scriptActions.add(new ConditionalScriptAction() {{
             addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                 addRequirement(new FlagRequirement("hasTalkedToDrugDealerDaughter", false));
                 addScriptAction(new TextboxScriptAction() {{
                    addText("Keep it moving, nothing to see here (it’ll be okay, dad, just breathe)");
                    addText("Keep it moving- Oh you know the code, um sorry it’s a bad time right now... ");
                    addText("You don’t happen to have anything like a phone or narcan, do you? ", new String[] { "\"Look in bag\"", "\"No \"" });
                 }});
              addScriptAction(new ChangeFlagScriptAction("hasTalkedToDrugDealerDaughter", true));
             }});
         }});
 
         //option-look in bag 
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
                     addText("Oh my god thank you... Ready 3..2..1 ");
                     addText("Deep breaths dad, you should get better in no time... How could I ever repay you?? Oh Alex? ");
                     addText("That name sounds familiar, probably knew my dad... hmm... OH I remember! ");
                     addText("Here’s a picture with his name and some information on it, maybe that can be of use! ");
                 }});
             }});
             
             //option- No
             addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                 addRequirement(new CustomRequirement() {
                     @Override
                     public boolean isRequirementMet() {
                         int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                         return answer == 1;
                     }
                 });
                 addScriptAction(new TextboxScriptAction(" Ugh wasting my time... it’ll be okay dad.. Dad? DAD?? "));
                 addScriptAction(new TextboxScriptAction(" No please no!!!! "));
             }});
         }});
                 
         scriptActions.add(new NPCUnlockScriptAction());
         scriptActions.add(new UnlockPlayerScriptAction());
 
         return scriptActions;
     }
 }