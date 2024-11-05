/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * 
 * package- Scripts- TestMap
 * class- pop-up butcher image butcher script action to pop-up image in butcher shop
*/

package Scripts.ButcherShopMap;

import java.util.ArrayList;
import Level.*;
import ScriptActions.*;
 
public class PopUpButcherImageScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {

        ArrayList<ScriptAction> scriptActions = new ArrayList<>();

        System.out.println("popUpButcherImage triggered");

        //change the image interact flag to true
        scriptActions.add(new ChangeFlagScriptAction("popUpButcherImage", true));
      
        return scriptActions;
    }
}
