/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * 
 * package- Scripts- ButcherShopMap
 * class- butcherToTownScript: script action to enter the town from the butcher shop
 */

 package Scripts.ButcherShopMap;

 import java.util.ArrayList;
 
 import Level.*;
 import ScriptActions.*;
 
 
 public class ButcherToTownScript extends Script{
    
     @Override
     public ArrayList<ScriptAction> loadScriptActions() {
         ArrayList<ScriptAction> scriptActions = new ArrayList<>();
 
         //change the exit townToHouse1 flag to true and return it
         scriptActions.add(new ChangeFlagScriptAction("butcherToTown", true));
 
         return scriptActions;
     }
     
 }
