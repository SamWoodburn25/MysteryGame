/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * 
 * package- Scripts- MyMap
 * class- enter home script: script action to enter the main home
 */

package Scripts.TownMap;

import java.util.ArrayList;

import Level.*;
import ScriptActions.*;


public class EnterHomeScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        //change the exit interact flag to true
        scriptActions.add(new ChangeFlagScriptAction("enteringHome", true));

                System.out.println("entering");

        scriptActions.add(new UnlockPlayerScriptAction());
        return scriptActions;
    }
}
