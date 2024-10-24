package Scripts.TownMap;

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
                addRequirement(new FlagRequirement("hasTalkedToMax", false));
                addScriptAction(new TextboxScriptAction() {{
                    addText("Max: Oh... it’s been a while since I’ve seen you.  ");
                    addText("Really? you came here to ask me about your brother, Alex?  \nAs if I’d know anything." );
                    addText("He didn’t tell you, really? Jeez, he really has changed.");
                    addText("Look, I haven’t heard from him since he ditched me for that \ngirl Jamie, wrote me a note saying he's over being friends.");
                    addText("Then handed me these ripped out pages from his journal.");
                    addText("Am I surprised that he has gone missing?");
                    addText("Honestly, no. He had a target on his back, considering how \nhe has been treated people lately.");
                    addText("What do I mean? God, you seriously haven’t heard about any \n of this?");
                    addText("I’m sorry, but I don't want to get involved in whatever has \nbeen going on around here.");
                    addText("If you want to get some more information, I hear one of his\nfavorite targets works in the butcher shop now for his father");
                    addText("or go to his now ex, Jamie who likes to hang out outside of \nthe Mad Hatter Bar in the alley (EX NOT ADDED YET).");
                }});
                addScriptAction(new ChangeFlagScriptAction("hasTalkedToMax", true));
            }});

            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToMax", true));
                addScriptAction(new TextboxScriptAction("Listen, I already told you, I don't want to \nget involved."));
                addScriptAction(new TextboxScriptAction("I know that one of his favorite targets now \nworks for his father in the butcher shop."));
                addScriptAction(new TextboxScriptAction("Or I heard that he goes to his now ex, Jamie \n likes to hang in the Mad Hatter Bar's alley."));
            }});
            
        }});
        

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
