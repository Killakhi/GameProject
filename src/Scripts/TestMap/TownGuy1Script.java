package Scripts.TestMap;

import Level.Script;
import ScriptActions.*;
import java.util.ArrayList;

// script for talking to new Custom npc
// checkout the documentation website for a detailed guide on how this script works
public class TownGuy1Script extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToTownsfolk", false));
                addScriptAction(new TextboxScriptAction() {{
                    addText("I see that you are an adventurer.\n Could you help us with something?");
                    addText("Luke: Of course what do you need?");
                    addText("Innkeeper: I heard that there were some \nwerid sounds to the northwest.");
                    addText("Maybe you should go check it out?");
                    addText("Luke: You got it, i'll help you out.");
                    
                    
                }});
                addScriptAction(new ChangeFlagScriptAction("hasTalkedToTownGuy1", true));
            }});

            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToTownGuy1", true));
                addScriptAction(new TextboxScriptAction("Go away"));
            }});
        }});

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
