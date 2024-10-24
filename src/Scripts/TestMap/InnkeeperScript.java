package Scripts.TestMap;

import Level.Script;
import ScriptActions.*;
import Utils.Visibility;
import java.util.ArrayList;

// script for talking to new Custom npc
// checkout the documentation website for a detailed guide on how this script works
public class InnkeeperScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToInnkeeper", false));
                addScriptAction(new TextboxScriptAction() {{
                    addText("L+ ratio");
                    
                    
                }});
                addScriptAction(new ChangeFlagScriptAction("hasTalkedToInnkeeper", true));
            }});

            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToInnkeeper", true));
                addScriptAction(new TextboxScriptAction("Go away"));
            }});
        }});

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
