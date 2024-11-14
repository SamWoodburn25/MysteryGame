package Scripts;

import java.util.ArrayList;

import Level.*;
import ScriptActions.*;


public class LockedAreaScript extends Script{
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());
        scriptActions.add(new ChangeFlagScriptAction("lockedCemetery", true));
        scriptActions.add(new TextboxScriptAction() {{
        addText("This area is locked. Look around the map for some clues.");
        
        }});
        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
    
}
