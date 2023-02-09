package me.soulvenom.mcaquests.item;

import forge.net.mca.item.BlueprintItem;
import me.soulvenom.mcaquests.MCAQuests;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MCAQuests.MODID);
    public static final RegistryObject<Item> QUESTBOOK = ITEMS.register("questbook",
            () -> new QuestBookItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> QUESTINDICATOR = ITEMS.register("questindicator",
            () -> new QuestBookItem(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
