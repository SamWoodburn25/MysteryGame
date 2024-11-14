/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * 
 * package- Scripts- CemeterMap
 * class- cemeterytoTownScript: script action to enter the town from cemetery
 */
package Scripts.CemeteryMap;

import java.util.ArrayList;
 
 import Level.*;
 import ScriptActions.*;
 
 
 public class CemeteryToTownScript extends Script{
    
     @Override
     public ArrayList<ScriptAction> loadScriptActions() {
         ArrayList<ScriptAction> scriptActions = new ArrayList<>();
 
         //change the exit townToHouse1 flag to true and return it
         scriptActions.add(new ChangeFlagScriptAction("cemeteryToTown", true));
 
         return scriptActions;
     }
     
 }