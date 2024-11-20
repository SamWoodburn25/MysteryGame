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
 
 // script for talking to bug npc
 // checkout the documentation website for a detailed guide on how this script works
 public class InvestigatorScript extends Script {
 
     @Override
     public ArrayList<ScriptAction> loadScriptActions() {
         ArrayList<ScriptAction> scriptActions = new ArrayList<>();
         scriptActions.add(new LockPlayerScriptAction());
 
         scriptActions.add(new NPCLockScriptAction());
 
         scriptActions.add(new NPCFacePlayerScriptAction());
 
         scriptActions.add(new TextboxScriptAction() {{
            addText("Huh? Oh hey kid... oh Alex? He your brother or something?\n*puffs cigarette* ahhh him.");
            addText("That case has been closed for a while now, ruled it a\n disappearance. Nothing we can do about it, sorry. ");
            addText("Sorry kid, we did all we could do.  ");
         }});
 
         scriptActions.add(new NPCUnlockScriptAction());
         scriptActions.add(new UnlockPlayerScriptAction());
 
         return scriptActions;
     }
 }