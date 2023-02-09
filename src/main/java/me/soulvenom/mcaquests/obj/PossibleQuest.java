package me.soulvenom.mcaquests.obj;

import forge.net.mca.entity.ai.Mood;
import forge.net.mca.entity.ai.MoodGroup;
import forge.net.mca.entity.ai.Traits;
import forge.net.mca.entity.ai.relationship.Personality;
import me.soulvenom.mcaquests.QuestType;

import java.util.List;

public class PossibleQuest {

    // private List<Personality> personalities;    // personalities required
    // private boolean personalitiesIsBlacklist;   // if personality list is blacklist or whitelist
    private List<String> moods;                   // moods required
    private boolean moodsIsBlacklist;           // if moods list is blacklist or whitelist
    private List<Traits.Trait> traits;          // traits required
    private boolean traitIsBlacklist;           // if traits list is blacklist or whitelist
    private String gender;
    private QuestType questType;                // how to use "target"
    private String target;                      // Item/Entity etc. to reach
    private int min;                            // how much completion is minimally required
    private int max;                            // how much completion is maximally required
    private int minRelation;                    // How much relation is minimally required
    private int maxRelation;                    // How much relation is minimally required
    private int possibility;                    // How often this quest will appear once the requirements are met
    private int tier;                           // How hard the quest is -> How much rewards it should generate

    // Although possibility works with percent values, it will be implemented the following way:
    // 1. Every few ticks (configurable) the world will try to generate a quest for a random loaded villager
    // 2. The mod checks if the villager meets the requirements for any quests
    // 3. It will then randomly choose one of the quests, meeting the requirement
    // 4. Then it will randomly generate a number, which is then compared with the possibility of said quest
    // 5. If the randomly generated number is smaller or equal to the possibility, the villager offer the quest


    public PossibleQuest(
            //List<Personality> personalities, boolean personalitiesIsBlacklist,
            List<String> moods, boolean moodsIsBlacklist, List<Traits.Trait> traits, boolean traitIsBlacklist, String gender, QuestType questType, String target, int min, int max, int minRelation, int maxRelation, int possibility, int tier) {
        // this.personalities = personalities;
        // this.personalitiesIsBlacklist = personalitiesIsBlacklist;
        this.moods = moods;
        this.moodsIsBlacklist = moodsIsBlacklist;
        this.traits = traits;
        this.traitIsBlacklist = traitIsBlacklist;
        this.gender = gender;
        this.questType = questType;
        this.target = target;
        this.min = min;
        this.max = max;
        this.minRelation = minRelation;
        this.maxRelation = maxRelation;
        this.possibility = possibility;
        this.tier = tier;
    }

//    public List<Personality> getPersonalities() {
//        return personalities;
//    }
//
//    public boolean isPersonalitiesBlacklist() {
//        return personalitiesIsBlacklist;
//    }

    public List<String> getMoods() {
        return moods;
    }

    public boolean isMoodsBlacklist() {
        return moodsIsBlacklist;
    }

    public List<Traits.Trait> getTraits() {
        return traits;
    }

    public boolean isTraitBlacklist() {
        return traitIsBlacklist;
    }

    public String getGender() {
        return gender;
    }

    public QuestType getQuestType() {
        return questType;
    }

    public String getTarget() {
        return target;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getMinRelation() {
        return minRelation;
    }

    public int getMaxRelation() {
        return maxRelation;
    }

    public int getPossibility() {
        return possibility;
    }

    public int getTier() {
        return tier;
    }
}
