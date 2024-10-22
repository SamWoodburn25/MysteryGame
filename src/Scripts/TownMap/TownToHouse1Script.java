package Scripts.TownMap;
import java.util.ArrayList;

import Level.*;
import ScriptActions.*;


public class TownToHouse1Script extends Script{
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        //scriptActions.add(new LockPlayerScriptAction());

        //change the exit townToHouse1 flag to true
        scriptActions.add(new ChangeFlagScriptAction("townToHouse1", true));

                //System.out.println("entering");

        //scriptActions.add(new UnlockPlayerScriptAction());
        return scriptActions;
    }
    
}
