package Scripts;

import java.util.ArrayList;

import Level.*;
import ScriptActions.*;


public class LockedAreaScript extends Script{
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());
        scriptActions.add(new ChangeFlagScriptAction("openGraveyardPuzzle", true));
        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
    
}
