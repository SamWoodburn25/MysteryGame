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


public class EnterButcherScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        //change the exit interact flag to true
        scriptActions.add(new ChangeFlagScriptAction("enteringButcherShop", true));
        System.out.println("enter butcher");
        scriptActions.add(new UnlockPlayerScriptAction());
        return scriptActions;
    }
}