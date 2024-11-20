package Scripts.TownMap;
import java.util.ArrayList;
import Level.*;
import ScriptActions.*;
 
public class PopUpFileImageScript extends Script{
/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * 
 * package- Scripts- TownMap
 * class: PopUpFileScript - pop-up graveyard image graveyard script action to pop-up image in town map near grave entrance
*/

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {

        ArrayList<ScriptAction> scriptActions = new ArrayList<>();

        System.out.println("fileImage triggered");

        //change the image interact flag to true
        scriptActions.add(new ChangeFlagScriptAction("fileImage", true));
        
        return scriptActions;
    }
}

