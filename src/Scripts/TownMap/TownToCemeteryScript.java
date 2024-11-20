/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * 
 * package- Scripts- MyMap
 * class- towntocemetery: script action to enter the town from the cemetery map
 */

 package Scripts.TownMap;
 import java.util.ArrayList;
 
 import Level.*;
 import ScriptActions.*;
 
 
 public class TownToCemeteryScript extends Script{
     @Override
     public ArrayList<ScriptAction> loadScriptActions() {
         ArrayList<ScriptAction> scriptActions = new ArrayList<>();
 
         //change the exit townToHouse1 flag to true and return it
         scriptActions.add(new ChangeFlagScriptAction("townToCemetery", true));
         
         return scriptActions;
     }
     
 }