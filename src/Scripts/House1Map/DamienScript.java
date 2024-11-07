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
 
 public class DamienScript extends Script {
 
     @Override
     public ArrayList<ScriptAction> loadScriptActions() {
         ArrayList<ScriptAction> scriptActions = new ArrayList<>();
         scriptActions.add(new LockPlayerScriptAction());
 
         scriptActions.add(new NPCLockScriptAction());
 
         scriptActions.add(new NPCFacePlayerScriptAction());
 
         
         scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToDamien", false));
                addScriptAction(new TextboxScriptAction() {{
                    addText("Hmm... we need to stock up a bit on... *he seems busy* ");
                    addText(" hm so you’re looking for Alex? ...he’s not here, hasn’t been in months.");
                    addText("Actually, I sent him some letters to see how he was doing but he never responded... ");
                    addText("Only thing I ever got was this weird notebook page but I couldn’t make any sense of it,poor kid...");
                    addText("I knew he was acting different but, wow he really flew of his rocker! Any who you can have me.");
                    addText("They’ve been collecting dust in the garage for a while now better off in your hands. ");
                    addText("Use them pages I gave you; they’ll help you a lot more than I can. ");        
        
                }});
            }});
        }});
         scriptActions.add(new NPCUnlockScriptAction());
         scriptActions.add(new UnlockPlayerScriptAction());
 
         return scriptActions;
     }
 }
