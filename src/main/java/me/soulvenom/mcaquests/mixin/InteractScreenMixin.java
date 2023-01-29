package me.soulvenom.mcaquests.mixin;


import forge.net.mca.client.gui.Button;
import forge.net.mca.client.gui.InteractScreen;
import forge.net.mca.entity.VillagerLike;
import me.soulvenom.mcaquests.client.gui.InteractionQuestGUI;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;

import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(InteractScreen.class)
public abstract class InteractScreenMixin {

        @Shadow @Final private VillagerLike<?> villager;


        @Inject(method = "buttonPressed", at = @At("TAIL"), remap = false)
        protected void onButtonPressed(Button button, CallbackInfo ci) {
                if(button.identifier().equals("gui.button.quest")) {
                        Minecraft.getInstance().setScreen(new InteractionQuestGUI(Component.literal("quest"), villager));
                }
        }

}
