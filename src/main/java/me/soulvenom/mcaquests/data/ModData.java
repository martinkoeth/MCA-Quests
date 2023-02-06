package me.soulvenom.mcaquests.data;

import me.soulvenom.mcaquests.obj.PossibleQuest;
import me.soulvenom.mcaquests.obj.Reward;

import java.util.HashMap;
import java.util.List;

public class ModData {

    public static List<PossibleQuest> possibleQuests;
    public static HashMap<Integer, Reward> rewards;

    public static List<PossibleQuest> getPossibleQuests() {
        return possibleQuests;
    }

    public static void setPossibleQuests(List<PossibleQuest> possibleQuestsNew) {
        possibleQuests = possibleQuestsNew;
    }

    public static HashMap<Integer, Reward> getRewards() {
        return rewards;
    }

    public static void setRewards(HashMap<Integer, Reward> rewards) {
        ModData.rewards = rewards;
    }
}
