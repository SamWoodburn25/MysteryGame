/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * 
 * package- Scripts- CemeteryMap
 * class: DeathScript - script to change screens to death cut scene hopefully
*/

package Scripts.CemeteryMap;

import java.util.ArrayList;
import Level.*;
import ScriptActions.*;
 
public class JoinScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {

        ArrayList<ScriptAction> scriptActions = new ArrayList<>();

        //change the image interact flag to true
        scriptActions.add(new ChangeFlagScriptAction("joinScreen", true));
      
        return scriptActions;
    }
}
