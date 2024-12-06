package Scripts.TestMap;

import Level.Script;
import ScriptActions.*;
import java.util.ArrayList;

public class DoorScript extends Script {
    
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());
        scriptActions.add(new NPCFacePlayerScriptAction());
        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasOpenDoor", false));
                addScriptAction(new TextboxScriptAction() {{
                    addText("Entering the Inn");
                    
                    
                }});
                addScriptAction(new ChangeFlagScriptAction("hasOpenDoor", true));
            }});

        }});

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
