package me.soulvenom.mcaquests;

import com.mojang.logging.LogUtils;
import forge.net.mca.entity.VillagerLike;
import me.soulvenom.mcaquests.client.gui.InteractionQuestGUI;
import me.soulvenom.mcaquests.client.render.IndicatorRenderer;
import me.soulvenom.mcaquests.data.ConfigReader;
import me.soulvenom.mcaquests.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MCAQuests.MODID)
public class MCAQuests {

    public static final String MODID = "mcaquests";
    private static final Logger LOGGER = LogUtils.getLogger();

    public MCAQuests() {
        QuestGenerator generator = new QuestGenerator();
        IndicatorRenderer renderer = new IndicatorRenderer();
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(modEventBus);
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(generator);
        MinecraftForge.EVENT_BUS.register(renderer);

        // Config stuff
        ConfigReader.readConfig();
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {


        }
    }


}
