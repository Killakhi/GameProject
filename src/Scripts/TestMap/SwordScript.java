package Scripts.TestMap;

import Level.Script;
import ScriptActions.*;
import Utils.Visibility;
import java.util.ArrayList;

// script for talking to Sword npc
// checkout the documentation website for a detailed guide on how this script works
public class SwordScript extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToSword", false));
                addScriptAction(new TextboxScriptAction() {{
                    addText("You found a sword!");
                }});
                addScriptAction(new ChangeFlagScriptAction("hasTalkedToSword", true));
                //Sword to disappear
                addScriptAction(new NPCChangeVisibilityScriptAction(Visibility.HIDDEN));
            }});
        }});

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }

}
