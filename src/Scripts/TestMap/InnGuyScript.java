package Scripts.TestMap;

import Level.Script;
import ScriptActions.*;

import java.util.ArrayList;

import ScriptActions.ChangeFlagScriptAction;
import ScriptActions.ConditionalScriptAction;
import ScriptActions.ConditionalScriptActionGroup;
import ScriptActions.FlagRequirement;
import ScriptActions.LockPlayerScriptAction;
import ScriptActions.NPCFacePlayerScriptAction;
import ScriptActions.ScriptAction;
import ScriptActions.TextboxScriptAction;
import ScriptActions.UnlockPlayerScriptAction;

public class InnGuyScript {
    
     @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());
        scriptActions.add(new NPCFacePlayerScriptAction());
        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("talkedtoInnGuy", false));
                addScriptAction(new TextboxScriptAction() {{
                    addText("Get out of here!");
                    
                    
                }});
                addScriptAction(new ChangeFlagScriptAction("talkedtoInnGuy", true));
            }});

        }});

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
