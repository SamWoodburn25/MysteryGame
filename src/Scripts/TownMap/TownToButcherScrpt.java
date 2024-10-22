/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * 
 * package- Scripts- MyMap
 * class- enterButcherScript: script action to enter the main home
 */

package Scripts.TownMap;
import java.util.ArrayList;

import Level.*;
import ScriptActions.*;


public class TownToButcherScrpt extends Script{
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();

        //change the exit townToHouse1 flag to true and return it
        scriptActions.add(new ChangeFlagScriptAction("townToButcher", true));

        return scriptActions;
    }
    
}