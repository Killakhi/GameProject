package Scripts.TestMap;

import Level.Script;
import ScriptActions.*;
import java.util.ArrayList;

// script for talking to new Custom npc
// checkout the documentation website for a detailed guide on how this script works
public class RealGokuScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());
        scriptActions.add(new NPCFacePlayerScriptAction());
        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToRealGoku", false));
                addScriptAction(new TextboxScriptAction() {{
                    addText("hey its me goku");
                    addText("get ready to fight");
                    
                    
                }});
                addScriptAction(new ChangeFlagScriptAction("hasTalkedToRealGoku", true));
            }});

            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToRealGoku", true));
                addScriptAction(new TextboxScriptAction(""));
            }});
        }});

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}