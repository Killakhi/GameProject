package Scripts.TestMap;

import java.util.ArrayList;

import Level.Script;
import ScriptActions.ChangeFlagScriptAction;
import ScriptActions.ConditionalScriptAction;
import ScriptActions.ConditionalScriptActionGroup;
import ScriptActions.CustomRequirement;
import ScriptActions.FlagRequirement;
import ScriptActions.LockPlayerScriptAction;
import ScriptActions.NPCChangeVisibilityScriptAction;
import ScriptActions.NPCFacePlayerScriptAction;
import ScriptActions.NPCLockScriptAction;
import ScriptActions.NPCUnlockScriptAction;
import ScriptActions.ScriptAction;
import ScriptActions.TextboxScriptAction;
import ScriptActions.UnlockPlayerScriptAction;
import Utils.Visibility;

public class CatScript extends Script {
    
    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());

        scriptActions.add(new NPCFacePlayerScriptAction());

        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("talkedtoPatches", false));
                addScriptAction(new TextboxScriptAction() {{
                    addText("Hello there stranger!");
                    addText("Welcome toooooooo~");
                    addText("Patches's Tarven!!");
                    addText("Make yourself at home.");
                    addText("Feel free to come back and talk to me! :3");
                    
                }});
                addScriptAction(new ChangeFlagScriptAction("talkedtoPatches", true));
            }});

                addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("talkedtoPatches", true));
                addScriptAction(new TextboxScriptAction(){{
                    addText("Oh hello again!");
                    addText("Hmmmm...");
                    addText("Why you giving me a weird look?");
                    addText("Jake: You look pretty familar..");
                    addText("Jake: Have we meant before in the past?");
                    addText("*blinks*");
                    addText("The hell you talkin bout?????");
                    addText("Do you even know what ya talkin bout weird guy?...");
                    addText("Jake: Weren't you a infamous CSC111 final project character?");
                    addText("*Loudly blinks*");
                    addText("I'm not going to talk to you anymore");
                    addText("Jake: I-");
                    addText("NOPE NOT LISTENING >:[");
                }});
                addScriptAction(new ChangeFlagScriptAction("talkedEvenMoreToPatches", true));
            }});
        }});

        
        scriptActions.add(new NPCUnlockScriptAction());
        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
