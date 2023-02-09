package me.soulvenom.mcaquests.mixin;


import forge.net.mca.client.gui.AbstractDynamicScreen;
import forge.net.mca.client.gui.InteractScreen;
import forge.net.mca.entity.VillagerLike;
import me.soulvenom.mcaquests.client.gui.InteractionQuestGUI;
import me.soulvenom.mcaquests.data.TemporaryData;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;

import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InteractScreen.class)
public abstract class InteractScreenMixin extends AbstractDynamicScreen {

        @Shadow @Final private VillagerLike<?> villager;
        @Shadow @Final private Player player;

        protected InteractScreenMixin(Component title) {
                super(title);
        }

        @Inject(method = "render", at = @At("TAIL"), remap = false)
        protected void checkDrawButton(CallbackInfo ci) {
                if(super.getActiveScreen().equals("main")) {
                        if (TemporaryData.currentAcceptableQuests.containsKey(villager)) {
                                int hearts = villager.getVillagerBrain().getMemoriesForPlayer(player).getHearts();
                                if (TemporaryData.currentAcceptableQuests.get(villager).minRelationToSee <= hearts &&
                                        TemporaryData.currentAcceptableQuests.get(villager).maxRelationToSee >= hearts) {
                                        this.addRenderableWidget(new Button(390, 136, 80, 20, Component.literal("Quest"), pButton ->
                                                Minecraft.getInstance().setScreen(new InteractionQuestGUI(Component.literal("quest"), villager))));

                                }
                        }
                }
        }
}

//        @Inject(method = "render", at = @At("HEAD"), remap = false)
//        protected void checkDrawButton(CallbackInfo ci) {
//                System.out.println("Test");
//
//                drawButton();
//
//                if(super.getActiveScreen().equals("interact")) {
//                        if (TemporaryData.currentAcceptableQuests.containsKey(villager)) {
//                                int hearts = villager.getVillagerBrain().getMemoriesForPlayer(player).getHearts();
//                                if (TemporaryData.currentAcceptableQuests.get(villager).minRelationToSee > hearts &&
//                                        TemporaryData.currentAcceptableQuests.get(villager).maxRelationToSee < hearts) {
//                                        drawButton();
//                                }
//                        }
//                }
//        }
//
//        private void drawButton() {
//                TreeSet<Integer> rowPositions = new TreeSet<>();
//                TreeSet<Integer> colPositions = new TreeSet<>();
//
//                System.out.println("Test 2");
//
//                for(Widget widget : super.renderables) {
//
//                        System.out.println("Test 3");
//
//                        if(widget instanceof net.minecraft.client.gui.components.Button) {
//
//                                System.out.println("Test 4");
//
//                                net.minecraft.client.gui.components.Button button = (net.minecraft.client.gui.components.Button) widget; // uff
//                                rowPositions.add(button.y);
//                                colPositions.add(button.x);
//                        }
//                }
//
//                int offset = 10;
//
//                for(int i = 0; i < 11; i++) {
//                        if(!rowPositions.contains(offset + (i * 21))) {
//
//                                addRenderableWidget(new net.minecraft.client.gui.components.Button(-90, offset + (i * 21), 80, 20, Component.literal("Quest"), pButton ->
//                                        Minecraft.getInstance().setScreen(new InteractionQuestGUI(Component.literal("quest"), villager))));
//
//                                return;
//
//                        }
//                }
//
//                for(int i = 0; i < 5; i++) {
//                        System.out.println(colPositions.first());
//                }
