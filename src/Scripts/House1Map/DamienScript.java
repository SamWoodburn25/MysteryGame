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
                    addText("Hmm so you’re looking for Alex? ...he’s not here, hasn’t\n been in months.");
                    addText("Actually, I sent him some letters to see how he was doing \nbut he never responded... ");
                    addText("Only thing I ever got was this weird notebook page but \nI couldn’t make any sense of it, poor kid...");
                    addText("I knew he was acting different but, wow he really flew of\n his rocker!");
                    addText("Before he disappeared, he was very scatterbrained and came\n into work all muddy.");
                    addText("Heard he crashed his bike on his way to the graveyard, maybe \nyou can check around there."); 
                    addText("He dropped these too, maybe they can help you out.");       
                }});
                addScriptAction(new ChangeFlagScriptAction("hasTalkedToDamien", true));
            }});
        }});

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToDamien", true));
                addScriptAction(new TextboxScriptAction() {{
                    addText("Sorry dude, I've told you all that I know.");
                    addText("Maybe you should check out the pages I gave you.");
                }});
            }});
        }});
         scriptActions.add(new NPCUnlockScriptAction());
         scriptActions.add(new UnlockPlayerScriptAction());
 
         return scriptActions;
     }

 }

