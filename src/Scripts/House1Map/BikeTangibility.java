package Scripts.House1Map;

/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * 
 * package- Scripts- House1Map
 * class- bike tangibility - makes noncharacter npcs interactable
 */


 import java.util.ArrayList;
 
 import Level.Script;
 import ScriptActions.*;
 
 public class BikeTangibility extends Script {
 
     @Override
     public ArrayList<ScriptAction> loadScriptActions() {
         ArrayList<ScriptAction> scriptActions = new ArrayList<>();
 
         scriptActions.add(new NPCLockScriptAction());
 

         return scriptActions;
     }

 }

