package Scripts.TestMap;

import Level.Script;
import ScriptActions.*;
import Utils.Visibility;
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
                addRequirement(new FlagRequirement("HappyPatches", false));
                addScriptAction(new TextboxScriptAction() {{
                    addText(":<");
                    addText("They're still like that...");
                }});
            }});
        }});

        scriptActions.add(new ConditionalScriptAction(){{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup(){{
                addRequirement(new FlagRequirement("HappyPatches", true));
                addScriptAction(new TextboxScriptAction(){{
                    addText(":<");
                    addText("* Slowly Blinks*");
                    addText("Jake: Huh hello?");
                    addText("GUH");
                    addText("Oh Sorry, I was in my own world for a moment there");
                    addText("You look like you wanna get out of here");
                    addText("And for some reason you can't find the exit..");
                    addText("Do you need help?", new String[] { "Yes", "No" });
                }});
                scriptActions.add(new ConditionalScriptAction() {{
                    addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                        addRequirement(new FlagRequirement("goingOut", false));
                        addRequirement(new CustomRequirement() {
                            @Override
                            public boolean isRequirementMet() {
                                int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                                return answer == 0;
                            }
                        });
        
                        addScriptAction(new TextboxScriptAction() {{
                            addText("Alrighty Then!");
                            addText("I'll show you the way out of here!");
                            addText("Follow me bowlcut kid!");
                        }});
        
                        addScriptAction(new NPCChangeVisibilityScriptAction(Visibility.HIDDEN));
                        addScriptAction(new ChangeFlagScriptAction("goingOut", true));
                    }});
        
                    addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                        addRequirement(new CustomRequirement() {
                            @Override
                            public boolean isRequirementMet() {
                                int answer = outputManager.getFlagData("TEXTBOX_OPTION_SELECTION");
                                return answer == 1;
                            }
                        });
                        
                        addScriptAction(new TextboxScriptAction("Hmm ok then"));
                        addScriptAction(new TextboxScriptAction("I guess good luck finding it?"));
                        addScriptAction(new TextboxScriptAction("Anyway..."));
                        addScriptAction(new TextboxScriptAction(":<"));
                        addScriptAction(new TextboxScriptAction("Looks like they back at that state again..."));
                        addScriptAction(new ChangeFlagScriptAction("goingOut", false));
                    }});
                }});
            }});
        }});

       

        scriptActions.add(new UnlockPlayerScriptAction());

        return scriptActions;
    }
}
