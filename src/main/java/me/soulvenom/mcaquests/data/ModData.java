package me.soulvenom.mcaquests.data;

import me.soulvenom.mcaquests.Quest;

import java.util.List;

public class ModData {

    public static List<Quest> possibleQuests;

    public static List<Quest> getPossibleQuests() {
        return possibleQuests;
    }

    public static void setPossibleQuests(List<Quest> possibleQuestsNew) {
        possibleQuests = possibleQuestsNew;
    }
}
