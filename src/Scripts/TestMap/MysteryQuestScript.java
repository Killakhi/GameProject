package Scripts.TestMap;

import Level.Script;
import ScriptActions.*;
import java.util.ArrayList;

// script for talking to new Custom npc
// checkout the documentation website for a detailed guide on how this script works
public class MysteryQuestScript extends Script {


    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());
 
 
        scriptActions.add(new NPCFacePlayerScriptAction());
 
 
        scriptActions.add(new ConditionalScriptAction() {
            {
                addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {
                    {
                        addRequirement(new FlagRequirement("hasTalkedToMysteryQuest", false));
                        addScriptAction(new TextboxScriptAction() {
                            {
                                addText("Woman: My friend up there is gonna\nturn into a ghost soon!");
                                addText("Luke: I'm so sorry. Is there anything I can do?");
                                addText("Woman: I'd like something to remember him by.\nHowever... I'm scared of ghosts.");
                                addText("Luke: I'll see what I can do.");
                                addText("Last I saw him, he was slightly behind my house!");
 
 
                            }
                        });
                        addScriptAction(new ChangeFlagScriptAction("hasTalkedToMysteryQuest", true));
                    }
                });
 
 
              
 
 
                addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {
                    {
                        addRequirement(new FlagRequirement("hasTalkedToMysteryQuest", true));
                        addRequirement(new FlagRequirement("hasTalkedToMP", true));
 
 
                        addScriptAction(new TextboxScriptAction() {
                            {
                                addText("Luke: He wanted you to have this.");
                                addText("Woman: A necklace? It's so pretty!\n Thank you!");
                                addText("Luke: No problem!");
                            }
                        });
 
 
                    }
                });
            }
        });
 
 
        scriptActions.add(new UnlockPlayerScriptAction());
 
 
        return scriptActions;
    }
 }
 
 
 