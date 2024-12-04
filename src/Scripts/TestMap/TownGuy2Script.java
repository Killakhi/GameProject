package Scripts.TestMap;

import Level.Script;
import ScriptActions.*;
import java.util.ArrayList;

// script for talking to new Custom npc
// checkout the documentation website for a detailed guide on how this script works
public class TownGuy2Script extends Script {

    @Override
    public ArrayList<ScriptAction> loadScriptActions() {
        ArrayList<ScriptAction> scriptActions = new ArrayList<>();
        scriptActions.add(new LockPlayerScriptAction());
 
 
        scriptActions.add(new NPCFacePlayerScriptAction());
 
 
        scriptActions.add(new ConditionalScriptAction() {
            {
                // To do, make conditonal script for if you haven't talked to the woman to the mysterious person
 
 
                addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {
                    {
                        addRequirement(new FlagRequirement("hasTalkedtoMysteryQuest", false));
                        addRequirement(new FlagRequirement("hasTalkedToMP", false));
                        addScriptAction(new TextboxScriptAction() {
                            {
                                addText("Luke: Hi, this person was looking \nfor something to remember you by.");
                                addText("MP: You must be talking about my friend. \nHere, let me give you something.");
                                addText("Luke: Thank you! I will give it to her.");
 
 
                            }
                        });
                        addScriptAction(new ChangeFlagScriptAction("hasTalkedToMP", true));
                    }
                });
 
 
 
 
 
 
                addConditionalScriptActionGroup(new ConditionalScriptActionGroup() {
                    {
                        addRequirement(new FlagRequirement("hasTalkedToMP", true));
                        addScriptAction(new TextboxScriptAction("Make sure you give her the thing."));
                    }
                });
            }
        });
 
 
        scriptActions.add(new UnlockPlayerScriptAction());
 
 
        return scriptActions;
    }
 }
 
 
 