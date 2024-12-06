package Scripts.TestMap;

import Level.Script;
import ScriptActions.*;
import java.util.ArrayList;

public class NormalCatScript extends Script {
    
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());
        scriptActions.add(new NPCFacePlayerScriptAction());
        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("talkedtoNormalCat1", false));
                addScriptAction(new TextboxScriptAction() {{
                    addText("Hello!");
                    addText("You seem like a weird nice fella! :3");
                    addText("Jake: Uh Hello-");
                    addText("Man why does patches get to move");
                    addText("While I'm just :<");
                    addText("Jake: Uh are you ok?");
                    addText(":<");
                    addText("Jake: Ok....?");
                    addText("Jake: I'm just going to go away now...");
                    
                    
                }});
                addScriptAction(new ChangeFlagScriptAction("talkedtoNormalCat1", true));
            }});
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("talkedtoNormalCat1", true));
                addScriptAction(new TextboxScriptAction() {{
                    addText(":<");
                    addText("They're still like that...");
                }});
            }});
        }});

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}