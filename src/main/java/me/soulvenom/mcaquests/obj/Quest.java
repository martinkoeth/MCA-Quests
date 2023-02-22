package me.soulvenom.mcaquests.obj;

import forge.net.mca.entity.VillagerEntityMCA;
import forge.net.mca.entity.VillagerLike;
import me.soulvenom.mcaquests.QuestType;

public class Quest {

    public VillagerEntityMCA villager;   // mca villager who gave the quest
    public int minRelationToSee;    // self-explanatory - Wether the button and the quest indicator is shown
    public int maxRelationToSee;    // If below minRelation the quest will be abandoned and a dialogue will appear
    public QuestType questType;     // how to use "target"
    public String target;           // Item/Entity etc. to reach
    public Reward reward;           // Reward the player will get upon completion
    public int completed = 0;           // how much the player completed/handed in for the quest
    public int goal;                // how much the player is supposed to complete for the quest    (will also be used for HUD overlay tracker)
    public boolean tracked = false;

    public Quest(VillagerEntityMCA villager, int minRelationToSee, int maxRelationToSee, QuestType questType, String target, Reward reward, int goal) {
        this.villager = villager;
        this.minRelationToSee = minRelationToSee;
        this.maxRelationToSee = maxRelationToSee;
        this.questType = questType;
        this.target = target;
        this.reward = reward;
        this.goal = goal;
    }

    public boolean isTracked() {
        return tracked;
    }

    public void changeTracked() {
        if(tracked == false) {
            this.tracked = true;
        } else {
            this.tracked = false;
        }

    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }

    public VillagerLike getVillager() {
        return villager;
    }

    public int getMinRelationToSee() {
        return minRelationToSee;
    }

    public int getMaxRelationToSee() {
        return maxRelationToSee;
    }

    public QuestType getQuestType() {
        return questType;
    }

    public String getTarget() {
        return target;
    }

    public Reward getReward() {
        return reward;
    }

    public int getCompleted() {
        return completed;
    }

    public int getGoal() {
        return goal;
    }
}
