package Scripts.House1Map;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.*;

// script for talking to walrus npc
// checkout the documentation website for a detailed guide on how this script works
public class ExBestFriendScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToExBestFriend", false));
                addScriptAction(new TextboxScriptAction() {{
                    addText("Max: Oh... it’s been a while since I’ve seen you.  ");
                    addText("Any news on your brother? " );
                    addText("I haven’t seen him since he ditched me for that girl of his,\nwrote me a note saying he's over being friends.");
                    addText("Along with these ripped out pages from his journal.");
                    addText("But am I surprised that he has gone missing?");
                    addText("Honestly, no. He had a target on his back, considering how he treated people.");
                    addText("");
                }});
                addScriptAction(new ChangeFlagScriptAction("hasTalkedToExBestFriend", true));
            }});

            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToExBestFriend", true));
                addScriptAction(new TextboxScriptAction("Character:Wait, what do you mean?"));
                addScriptAction(new TextboxScriptAction("Max: Look, I don't want to get involved but if \nyou want to get some more information."));
                addScriptAction(new TextboxScriptAction("I know that one of his favorite targets now \nworks for his father in the butcher shop."));
                addScriptAction(new TextboxScriptAction("Or I heard that he goes to his ex-girlfriend \nwho likes to hang out outside the Mad Hatter (bar name) in the alley."));
            }});
        }});
        

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
