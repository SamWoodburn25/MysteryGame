/*
 * SER225- Mystery Game
 * the dawgs- Adelina Chocho, Ella Berry, Morgan Montz, Sam Woodburn, Tuana Turhan
 * Fall 2024
 * 
 * package- Scripts- ButcherShopMap
 * class- butcherToTownScript: script action to enter the town from the butcher shop
 */

package Scripts.House1Map;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.*;

// script for talking to bug npc
// checkout the documentation website for a detailed guide on how this script works
public class DrugDealerScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCLockScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToDrugDealer", false));
                addScriptAction(new TextboxScriptAction() {{
                    addText("*cough cough*");
                }});
                addScriptAction(new ChangeFlagScriptAction("hasTalkedToDrugDealer", true));
            }});
        }});
        scriptActions.add(new NPCUnlockScriptAction());
        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}