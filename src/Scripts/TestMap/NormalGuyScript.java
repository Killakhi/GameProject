package Scripts.TestMap;

import Level.Script;
import ScriptActions.*;
import java.util.ArrayList;

public class NormalGuyScript extends Script {
    
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());
        scriptActions.add(new NPCFacePlayerScriptAction());
        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("talkedtoNormalGuy", false));
                addScriptAction(new TextboxScriptAction() {{
                    addText("Hello!");
                    addText("You noticed that this place is runned by cats!");
                    addText("Mann...I wonder if they allow humans to work here");
                    addText("You notice a cat pin on his shirt as you walk away");
                    
                    
                    
                }});
                addScriptAction(new ChangeFlagScriptAction("talkedtoNormalGuy", true));
            }});
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("talkedtoNormalGuy", true));
                addScriptAction(new TextboxScriptAction() {{
                    addText(":]");
                    addText("He seems to be day dreaming");
                }});
            }});
        }});

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
