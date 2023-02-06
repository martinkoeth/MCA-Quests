package me.soulvenom.mcaquests.obj;

import forge.net.mca.entity.VillagerLike;
import me.soulvenom.mcaquests.QuestType;

public class Quest {

    public VillagerLike villager;   // mca villager who gave the quest
    public QuestType questType;     // how to use "target"
    public String target;           // Item/Entity etc. to reach
    public Reward reward;           // Reward the player will get upon completion
    public int completed;           // how much the player completed/handed in for the quest
    public int goal;                // how much the player is supposed to complete for the quest    (will also be used for HUD overlay tracker)

    public Quest(VillagerLike villager, QuestType questType, String target, Reward reward, int completed, int goal) {
        this.villager = villager;
        this.questType = questType;
        this.target = target;
        this.reward = reward;
        this.completed = completed;
        this.goal = goal;
    }

    public VillagerLike getVillager() {
        return villager;
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

    public void setGoal(int goal) {
        this.goal = goal;
    }
}
