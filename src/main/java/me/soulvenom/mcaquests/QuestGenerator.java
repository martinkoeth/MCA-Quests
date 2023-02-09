package me.soulvenom.mcaquests;


import forge.net.mca.entity.VillagerLike;
import forge.net.mca.entity.ai.Traits;
import forge.net.mca.entity.ai.brain.VillagerBrain;
import forge.net.mca.entity.ai.relationship.Gender;
import me.soulvenom.mcaquests.data.ModData;
import me.soulvenom.mcaquests.data.TemporaryData;
import me.soulvenom.mcaquests.obj.PossibleQuest;
import me.soulvenom.mcaquests.obj.Quest;
import net.minecraft.client.Minecraft;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.*;

@Mod.EventBusSubscriber
public class QuestGenerator {

    int tickCounter = 0;
    List<VillagerLike> villagers = new ArrayList<>();

    @SubscribeEvent
    public void generateQuests(TickEvent.ServerTickEvent event) {

        tickCounter++;

        // 20 -> later config
        if(tickCounter >= 20) {

            VillagerLike villager = sortOutOne();
            if(villager != null) {

                if(villager.isToYoungToSpeak()) {
                    return;
                }

                if(TemporaryData.currentAcceptableQuests.containsKey(villager)) {
                    return;
                }

                if(TemporaryData.villagerWithQuests.contains(villager)) {
                    return;
                }

                List<PossibleQuest> questsWithRequirement = new ArrayList<>();
                for(PossibleQuest quest : ModData.getPossibleQuests()) {
                    if(hasRequirements(villager, quest)) {
                        questsWithRequirement.add(quest);
                    }
                }

                if(questsWithRequirement.isEmpty()) {
                    return;
                }

                PossibleQuest quest = chooseQuest(questsWithRequirement);

                if(quest == null) {
                    return;
                }

                TemporaryData.currentAcceptableQuests.put(villager, createQuest(quest, villager));

            }


        }
    }

    @SubscribeEvent
    public void getVillagers(LivingEvent.LivingTickEvent event) {

        if(event.getEntity() instanceof VillagerLike) {

            VillagerLike villager = (VillagerLike) event.getEntity();

            if(!villagers.contains(villager)) {
                villagers.add(villager);
            }
        }
    }

    private VillagerLike sortOutOne() {

        Random random = new Random();
        int villagerNum = random.nextInt(villagers.size());

        if(villagers.get(villagerNum).asEntity().isAlive()) {

            return villagers.get(villagerNum);
        }


        return null;
    }

    private boolean hasRequirements(VillagerLike villager, PossibleQuest quest) {

        // check for gender
        if(villager.getGenetics().getGender() != Gender.byName(quest.getGender().toUpperCase(Locale.ROOT))) {
            return false;
        }

        VillagerBrain brain = villager.getVillagerBrain();

        // check for personality
//        if(quest.getPersonalities().contains(brain.getPersonality())) {
//
//            if(quest.isPersonalitiesBlacklist()) {
//                return false;
//            }
//        } else if(!quest.isPersonalitiesBlacklist()) {
//            return false;
//        }

        // check for trait
        for(Traits.Trait trait : quest.getTraits()) {
            if(villager.getTraits().hasTrait(trait)) {
                if(quest.isTraitBlacklist()) {
                    return false;
                }
            } else if(!quest.isTraitBlacklist()) {
                return false;
            }
        }

        // check for mood
        if(quest.getMoods().contains(brain.getMood().getName())) {
            if(quest.isMoodsBlacklist()) {
                return false;
            }
        } else if(!quest.isMoodsBlacklist()) {
            return false;
        }

        return true;
    }

    private PossibleQuest chooseQuest(List<PossibleQuest> possibleQuests) {
        Random random = new Random();

        PossibleQuest quest = possibleQuests.get(random.nextInt(possibleQuests.size()));



        if(random.nextInt(101) <= quest.getPossibility()) {
            return quest;
        }

        return null;
    }

    private Quest createQuest(PossibleQuest quest, VillagerLike villager) {
        Random random = new Random();

        int goal = random.nextInt(quest.getMin(), quest.getMax());

        return new Quest(villager, quest.getMinRelation(), quest.getMaxRelation(), quest.getQuestType(), quest.getTarget(), ModData.getRewards().get(quest.getTier()), goal);
    }



}
