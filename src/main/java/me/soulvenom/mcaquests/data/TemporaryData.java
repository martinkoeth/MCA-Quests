package me.soulvenom.mcaquests.data;

import me.soulvenom.mcaquests.obj.Quest;
import net.minecraft.world.entity.player.Player;

import java.util.HashMap;
import java.util.List;

public class TemporaryData {

    public static List<Quest> currentAcceptableQuests;
    public static HashMap<Player, Quest> currentAcceptedQuests;

    public static List<Quest> getCurrentAcceptableQuests() {
        return currentAcceptableQuests;
    }


    public static HashMap<Player, Quest> getCurrentAcceptedQuests() {
        return currentAcceptedQuests;
    }
}
