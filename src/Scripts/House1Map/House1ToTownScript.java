package Scripts.House1Map;

import java.util.ArrayList;

import Level.*;
import ScriptActions.*;


public class House1ToTownScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
       // scriptActions.add(new LockPlayerScriptAction());

       
        //change the exit interact flag to true
        scriptActions.add(new ChangeFlagScriptAction("house1ToTown", true));

        

        //scriptActions.add(new UnlockPlayerScriptAction());
        return scriptActions;
    }
}
