package Scripts.House1Map;

import java.util.ArrayList;
 
import Level.Script;
import ScriptActions.*;

public class InvestigatorScript2 extends Script{

     @Override
     public ArrayList<ScriptAction> loadScriptActions() {
         ArrayList<ScriptAction> scriptActions = new ArrayList<>();
         scriptActions.add(new LockPlayerScriptAction());
 
         scriptActions.add(new NPCLockScriptAction());
 
         scriptActions.add(new NPCFacePlayerScriptAction());
 
         scriptActions.add(new TextboxScriptAction() {{
            addText("Huh? Oh hey kid... oh Alex? He your brother or \nsomething? *puffs cigarette* ahhh him.");
            addText("That case has been closed for a while now, ruled it a\n disappearance. Nothing we can do about it, sorry. ");
            addText("Sorry kid, we did all we could do.  ");
         }});
 
         scriptActions.add(new NPCUnlockScriptAction());
         scriptActions.add(new UnlockPlayerScriptAction());
 
         return scriptActions;
     }

}
