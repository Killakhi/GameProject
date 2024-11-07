package Scripts.TestMap;

import Level.Script;
import ScriptActions.*;
import java.util.ArrayList;

// script for talking to new Custom npc
// checkout the documentation website for a detailed guide on how this script works
public class TownsfolkScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToTownsfolk", false));
                addScriptAction(new TextboxScriptAction() {{
                    addText("Welcome to Fellskar!");
                    addText("Go to the innkeeper if you need anything.");
                    addText("She should be on the south side of town.");
                    
                    
                }});
                addScriptAction(new ChangeFlagScriptAction("hasTalkedToTownsfolk", true));
            }});

            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToTownsfolk", true));
                addScriptAction(new TextboxScriptAction("Go away"));
            }});
        }});

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
