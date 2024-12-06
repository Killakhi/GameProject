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
                addScriptAction(new TextboxScriptAction() {{
                    addText("Hello!");
                    addText("You seem like a weird nice fella! :3");
                    addText("Don't mind that weird guy over there, he's alwa")
                    
                    
                }});
            }});

        }});

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
