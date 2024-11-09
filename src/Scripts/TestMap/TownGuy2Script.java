package Scripts.TestMap;

import Level.Script;
import ScriptActions.*;
import java.util.ArrayList;

// script for talking to new Custom npc
// checkout the documentation website for a detailed guide on how this script works
public class TownGuy2Script extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToTownGuy2", false));
                addScriptAction(new TextboxScriptAction() {{
                    addText("Mysterious person: What happened?");
                    addText("Luke: You look like a ghost...\n what's the last thing you remember?");
                    addText("MP: I was walking through the woods like I always do.\n I heard rustling and the next thing I knew I was here.");
                    addText("Luke: Don't worry Ill find a way to help you");
                    
                    
                }});
                addScriptAction(new ChangeFlagScriptAction("hasTalkedToTownGuy2", true));
            }});

            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToTownGuy2", true));
                addScriptAction(new TextboxScriptAction("Go away"));
            }});
        }});

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
