package Scripts.House1Map;

    
import java.util.ArrayList;
     
import Level.Script;
import ScriptActions.*;

public class FileInfoScript extends Script {

/* SER225- Mystery Game
* the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
* Fall 2024
* 
* package- Scripts- FileInfoScript
* class- butcherToTownScript: script action to enter the town from the butcher shop
*/
    
        @Override
        public ArrayList<ScriptAction> loadScriptActions() {
            ArrayList<ScriptAction> scriptActions = new ArrayList<>();
            scriptActions.add(new LockPlayerScriptAction());
     
            scriptActions.add(new NPCLockScriptAction());
     
            scriptActions.add(new NPCFacePlayerScriptAction());
     
            scriptActions.add(new TextboxScriptAction() {{
                addText("Hmm looks like the investigators dropped a file on potential suspects");
                addText("Good to know that Max, my Mom, and Camilla have alibis.");
            }});
     
        scriptActions.add(new NPCUnlockScriptAction());
        scriptActions.add(new UnlockPlayerScriptAction());
     
        return scriptActions;
    }
}