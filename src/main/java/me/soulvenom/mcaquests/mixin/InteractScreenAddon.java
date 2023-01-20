package me.soulvenom.mcaquests.mixin;

import forge.net.mca.client.gui.Button;
import forge.net.mca.client.gui.InteractScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InteractScreen.class)
public abstract class InteractScreenAddon {


        @Inject(method = "buttonPressed", at = @At("TAIL"), remap = false)
        protected void onButtonPressed(Button button, CallbackInfo ci) {

        }

}
