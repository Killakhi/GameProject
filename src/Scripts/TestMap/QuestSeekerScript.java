package Scripts.TestMap;

import Level.Script;
import ScriptActions.*;
import java.util.ArrayList;

// script for talking to new Custom npc
// checkout the documentation website for a detailed guide on how this script works
public class QuestSeekerScript extends Script {


    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());
 
 
        scriptActions.add(new NPCFacePlayerScriptAction());
 
 
        scriptActions.add(new ConditionalScriptAction() {{
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToQuestSeeker", false));
                addScriptAction(new TextboxScriptAction() {{
                    addText("DJ: Hi, I have a task for you.");
                    addText("Luke: Sure, what is it?");
                    addText("DJ: I need you to collect all the obtainable items.");
                    addText("Luke: Will do");
                   
                }});
                addScriptAction(new ChangeFlagScriptAction("hasTalkedToQuestSeeker", true));
            }});

         
                addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                    addRequirement(new FlagRequirement("hasTalkedToQuestSeeker", true));
                    addRequirement(new FlagRequirement("hasTalkedToWand", true));
                    addRequirement(new FlagRequirement("hasTalkedToBat", true));
                    addRequirement(new FlagRequirement("hasTalkedToSword", true));
                    addScriptAction(new TextboxScriptAction() {{

                        addScriptAction(new TextboxScriptAction("DJ: Yay! You did it!"));
                       
                    }});
                    addScriptAction(new ChangeFlagScriptAction("hasTalkedToQuestSeeker", true));
                    addRequirement(new FlagRequirement("hasTalkedToWand", true));
                    addRequirement(new FlagRequirement("hasTalkedToBat", true));
                    addRequirement(new FlagRequirement("hasTalkedToSword", true));
                }});
 
           /*  
            addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {{
                addRequirement(new FlagRequirement("hasTalkedToQuestSeeker", true));
                addRequirement(new FlagRequirement("hasTalkedToSword", true));
                addRequirement(new FlagRequirement("hasTalkedToWand", true));
                addRequirement(new FlagRequirement("hasTalkedToBat", true));
               
                addScriptAction(new TextboxScriptAction("DJ: Yay! You did it!"));
            }});
            */
        }});
 
 
        scriptActions.add(new UnlockPlayerScriptAction());
 
 
        return scriptActions;
    }
 }
 
 
 
 
 