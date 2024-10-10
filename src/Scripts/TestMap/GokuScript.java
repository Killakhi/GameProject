package Scripts.TestMap;

import Level.Script;
import ScriptActions.*;
import Utils.Visibility;
import java.util.ArrayList;

// script for talking to new Custom npc
// checkout the documentation website for a detailed guide on how this script works
public class GokuScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToGoku", false));
                addScriptAction(new TextboxScriptAction() {{
                    addText("There are plenty of great foods here at this festival!");
                    addScriptAction(new NPCChangeVisibilityScriptAction(Visibility.HIDDEN));
                    addText("Press B to battle");
                    
                }});
                addScriptAction(new ChangeFlagScriptAction("hasTalkedToGoku", true));
            }});

            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToGoku", true));
                addScriptAction(new TextboxScriptAction("I sure love doing walrus things!"));
            }});
        }});

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
