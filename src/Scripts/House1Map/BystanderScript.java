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
 public class BystanderScript extends Script {
 
     @Override
     public ArrayList<ScriptAction> loadScriptActions() {
         ArrayList<ScriptAction> scriptActions = new ArrayList<>();
         scriptActions.add(new LockPlayerScriptAction());
 
         scriptActions.add(new NPCLockScriptAction());
 
         scriptActions.add(new NPCFacePlayerScriptAction());
 
         scriptActions.add(new TextboxScriptAction() {{
            addText("What a nice day..");
            addText("Oh Hello! Hm.. Oh, he looks familiar... I think I saw that kid a couple months ago. ");
            addText("It was outside the cemetery, was riding his bike all disheveled.... ");
            addText("I think the bike is still over there, but he sure looked like he was in a rush- actually here’s a key that he dropped on his way there. ");
            addText("These pages also flew out from his back pocket, couldn’t figure out what it was talking about but maybe you can use it... ");
            addText("Anyhow haven’t seen him since. Maybe you can check out his bike or something... good luck!  ");
         }});
 
         scriptActions.add(new NPCUnlockScriptAction());
         scriptActions.add(new UnlockPlayerScriptAction());
 
         return scriptActions;
     }
 }