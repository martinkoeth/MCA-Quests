package me.soulvenom.mcaquests;

import forge.net.mca.entity.VillagerLike;

public class Quest {

    public VillagerLike villager;   // mca villager who gave the quest
    public QuestType questType;     // how to use "target"
    public String target;           // Item/Entity etc. to reach
    public int completed;           // how much the player completed/handed in for the quest
    public int goal;                // how much the player is supposed to complete for the quest    (will also be used for HUD overlay tracker)


}
