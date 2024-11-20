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
            addText("Huh? Oh hey kid... oh Alex? He your brother or something? \n*puffs cigarette* ahhh him.");
            addText("What information have we gotten so far? Listen kid, let the \nprofessionals handle this");
            addText("We don't need any children messing up the investigation. \nJust stay home and comfort your mom.");
         }});
 
         scriptActions.add(new NPCUnlockScriptAction());
         scriptActions.add(new UnlockPlayerScriptAction());
 
         return scriptActions;
     }

}
