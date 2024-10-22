package Scripts.House1Map;

import java.util.ArrayList;



import Level.*;
import ScriptActions.*;


// script for talking to dino npc
// checkout the documentation website for a detailed guide on how this script works
public class ExitScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {

        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new ChangeFlagScriptAction("exitInteract", true));

        scriptActions.add(new UnlockPlayerScriptAction());
        return scriptActions;
    }
}

