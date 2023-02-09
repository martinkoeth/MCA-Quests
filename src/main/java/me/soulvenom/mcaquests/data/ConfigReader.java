package me.soulvenom.mcaquests.data;

import forge.net.mca.entity.ai.Traits;
import forge.net.mca.entity.ai.relationship.Personality;
import me.soulvenom.mcaquests.obj.PossibleQuest;
import me.soulvenom.mcaquests.QuestType;
import me.soulvenom.mcaquests.obj.Reward;
import me.soulvenom.mcaquests.obj.RewardItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class ConfigReader {

    public static void readConfig() {
        readRewards();
        readQuests();
    }

    private static void readSettings() {

    }

    private static void readQuests() {
        List<PossibleQuest> quests = new ArrayList<>();

        // Test - Will later be replaced by reading mechanism
        List<Traits.Trait> traits = new ArrayList<>();
        List<String> moods = new ArrayList<>();
        // List<Personality> personalities = new ArrayList<>();

        traits.add(Traits.Trait.DIABETES);
        moods.add("bored_to_tears");
        // personalities.add(Personality.WITTY);

        PossibleQuest quest = new PossibleQuest(
                // personalities, true,
                moods, true,
                traits, true, "male", QuestType.DELIVER, "dirt", 10, 64, 0, 999, 50, 1);
        quests.add(quest);
        // Test - Will later be replaced by reading mechanism


        ModData.setPossibleQuests(quests);
    }

    private static void readRewards() {
        HashMap<Integer, Reward> rewards = new HashMap<>();

        // Test - Will later be replaced by reading mechanism
        List<RewardItem> rewardItems = new ArrayList<>();
        rewardItems.add(new RewardItem(1, 10, "stone", 90));
        rewardItems.add(new RewardItem(1, 2, "redstone", 20));


        Reward reward = new Reward(5, 10, rewardItems, 0, 0, 0);
        rewards.put(1, reward);
        // Test - Will later be replaced by reading mechanism

        ModData.setRewards(rewards);
    }
}
