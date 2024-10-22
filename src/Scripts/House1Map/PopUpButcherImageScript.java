/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * 
 * package- Scripts- TestMap
 * class- pop-up butcher image butcher script action to pop-up image in butcher shop
*/

package Scripts.House1Map;

import java.util.ArrayList;

import Engine.ImageLoader;
import Level.*;
import ScriptActions.*;
// import java.awt.image.BufferedImage;
 
public class PopUpButcherImageScript extends Script {
    // protected BufferedImage popUp;

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {

        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        // scriptActions.add(new LockPlayerScriptAction());

        System.out.println("popUpButcherImage triggered");

        //change the image interact flag to true
        scriptActions.add(new ChangeFlagScriptAction("popUpButcherImage", true));
      

        // popUp = ImageLoader.load("goreyButcherShop.png");


        // scriptActions.add(new UnlockPlayerScriptAction());
        return scriptActions;
    }
}
