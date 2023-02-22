package me.soulvenom.mcaquests.data;

import forge.net.mca.entity.VillagerEntityMCA;
import forge.net.mca.entity.VillagerLike;
import me.soulvenom.mcaquests.obj.Quest;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TemporaryData {

    public static HashMap<VillagerEntityMCA, Quest> currentAcceptableQuests = new HashMap<>();
    public static HashMap<Player, List<Quest>> currentAcceptedQuests = new HashMap<>();
    public static List<VillagerEntityMCA> villagerWithQuests = new ArrayList<>();

}
