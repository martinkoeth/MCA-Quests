package me.soulvenom.mcaquests.data;

import forge.net.mca.entity.ai.Mood;
import forge.net.mca.entity.ai.MoodBuilder;
import forge.net.mca.entity.ai.MoodGroup;
import forge.net.mca.entity.ai.Traits;
import forge.net.mca.entity.ai.relationship.Personality;
import me.soulvenom.mcaquests.PossibleQuest;
import me.soulvenom.mcaquests.Quest;
import me.soulvenom.mcaquests.QuestType;

import java.util.ArrayList;
import java.util.List;

public class ConfigReader {

    public static void readConfig() {

        readQuests();
    }

    private static void readSettings() {

    }

    private static void readQuests() {
        List<PossibleQuest> quests = new ArrayList<PossibleQuest>();

        // Test - Will later be replaced by reading mechanism
        List<Traits.Trait> traits = new ArrayList<Traits.Trait>();
        List<String> moods = new ArrayList<String>();
        List<Personality> personalities = new ArrayList<Personality>();
        traits.add(Traits.Trait.DIABETES);
        moods.add("bored_to_tears");
        personalities.add(Personality.FLIRTY);
        PossibleQuest quest = new PossibleQuest(personalities, true, moods, true,
                traits, true, QuestType.DELIVER, "dirt", 10, 64, 0, 999, 50);
    }
}
