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
                    addText("Keep it moving-");
                    addText("Oh I know Alex, didn't he go missing? \n sorry it’s a bad time right now... ");
                    addText("Maybe you can use this, it was his. Talked \nabout some kid named Peter.");
                    addText("umm..You don’t happen to have anything \nlike a phone or narcan, do you? ", new String[] { "\"Look in bag\"", "\"No \"" });
                 }});
              //addScriptAction(new ChangeFlagScriptAction("hasTalkedToDrugDealerDaughter", true));
             }});
         }});
 
         //option-look in bag 
         scriptActions.add(new ConditionalScriptAction() {{
             addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                 addRequirement(new FlagRequirement("hasTalkedToDrugDealerDaughter", false));
                 addScriptAction(new ChangeFlagScriptAction("hasTalkedToDrugDealerDaughter", true));
                 addRequirement(new CustomRequirement() {
                     @Override
                     public boolean isRequirementMet() {
                         int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                         return answer == 0;
                     }
                 });
                 addScriptAction(new TextboxScriptAction() {{
                     addText("Oh my god thank you... Ready 3..2..1 ");
                     addText("Deep breaths dad, you should get better in no time... \nHow could I ever repay you?? Oh Alex? ");
                     addText("That name sounds familiar, probably knew my dad... \nhmm... OH I remember! ");
                     addText("Here’s a notebook page that he left here \nmaybe that can be of use! ");
                     addText("He also mentioned something about pissing off some \n kid, Peter was it? Might've really did it this time");
                 }});
             }});
             
             //option- No
             addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToDrugDealerDaughter", false));
                addScriptAction(new ChangeFlagScriptAction("hasTalkedToDrugDealerDaughter", true));
                addScriptAction(new ChangeFlagScriptAction("badDD", true));
                 addRequirement(new CustomRequirement() {
                     @Override
                     public boolean isRequirementMet() {
                         int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                         return answer == 1;
                     }
                 });
                 addScriptAction(new TextboxScriptAction(" Ugh wasting my time... it’ll be okay dad.. \nDad? DAD?? "));
                 addScriptAction(new TextboxScriptAction(" No please no!!!! "));
             }});
         }});

         scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToDrugDealerDaughter", true));
                addRequirement(new FlagRequirement("badDD", false));
                addScriptAction(new TextboxScriptAction() {{
                   addText("Try looking into that Peter, kid. \n Supposedly works at the butchers shop.");
                   addText("I have to stay here to take care of my dad, good luck!");
                }});
            }});
         }});

         scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToDrugDealerDaughter", true));
                addRequirement(new FlagRequirement("badDD", true));
                addScriptAction(new TextboxScriptAction() {{
                   addText("Look what you've done...");
                   addText("Dad...");
                }});
            }});
         }});


         
                 
         scriptActions.add(new NPCUnlockScriptAction());
         scriptActions.add(new UnlockPlayerScriptAction());
 
         return scriptActions;
     }
 }