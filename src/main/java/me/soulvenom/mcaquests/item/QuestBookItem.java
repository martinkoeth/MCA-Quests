package me.soulvenom.mcaquests.item;

import me.soulvenom.mcaquests.client.gui.QuestBookGUI;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;

public class QuestBookItem extends Item {

    public QuestBookItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Minecraft.getInstance().setScreen(new QuestBookGUI(Component.literal("quest")));

        return InteractionResult.SUCCESS;
    }
}
