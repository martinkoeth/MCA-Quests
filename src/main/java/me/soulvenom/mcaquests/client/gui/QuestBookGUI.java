package me.soulvenom.mcaquests.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import forge.net.mca.entity.VillagerEntityMCA;
import me.soulvenom.mcaquests.QuestType;
import me.soulvenom.mcaquests.data.TemporaryData;
import me.soulvenom.mcaquests.obj.Quest;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.event.RenderTooltipEvent;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class QuestBookGUI extends Screen implements ICustomOnPress {

    private Player player;
    private HashMap<Integer, GUIEntry> entries = new HashMap<>();

    int mouseX;
    int mouseY;

    public QuestBookGUI(Component pTitle) {
        super(pTitle);
        player = Minecraft.getInstance().player;
    }

    @Override
    protected void init() {
        super.init();
        registerEntries();
        for(int i = 0; i < entries.size(); i++) {
            addButtons(i);
        }
    }

    @Override
    public void render(@NotNull PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(pPoseStack);

        mouseX = pMouseX;
        mouseY = pMouseY;

        // background
        int pHeight = 256;
        int pWidth = 420;
        RenderSystem.setShaderTexture(0, new ResourceLocation("mcaquests", "textures/gui/questbook.png"));
        blit(pPoseStack, this.width / 2 - (pWidth / 2), this.height / 2 - (pHeight / 2), 0, 0, pWidth, pHeight, pWidth, pHeight);

        // buttons
        renderAllEntries(pPoseStack);

        // tooltips
        giveQuestInfos();

        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
    }

    private void registerEntries() {
        // Put everything into the entry hashmap
        if (TemporaryData.currentAcceptedQuests.containsKey(player)) {
            for (int i = 0; i < TemporaryData.currentAcceptedQuests.get(player).size(); i++) {
                entries.put(i, new GUIEntry(new ArrayList<>(), TemporaryData.currentAcceptedQuests.get(player).get(i), "default"));
            }
        }
    }

    private void addButtons(int i) {
        // Has to be executed when one Entry layout is changes

            int y = i * 12 + 20;
            int x = 40;
            if(i > 5) {
                x = 80;
            }

            String layout = entries.get(i).getCurrentLayout();
            switch (layout) {
                case "default":
                    createButton(i, x, y, 143, 28, "entry_" + i);
                    break;
                case "options":
                    createButton(i, x + 9, y + 5, 18, 57, "track_" + i);
                    createButton(i, x + 77, y + 5, 18, 57, "cancel_" + i);
                    break;
                case "confirm":
                    createButton(i, x + 9, y + 5, 18, 57, "back_" + i);
                    createButton(i, x + 77, y + 5, 18,57, "confirm_" + i);
                    break;
            }


    }


    private void renderAllEntries(PoseStack poseStack) {

        for(int i = 0; i < entries.size(); i++) {

            int y = i * 12 + 20;
            int x = 65;
            if(i > 5) {
                x = 130;
            }

            Quest quest = TemporaryData.currentAcceptedQuests.get(player).get(i);

            ResourceLocation background = new ResourceLocation("mcaquests", "textures/gui/entry_background.png");
            renderEntry(poseStack, x, y, 143, 28, background, 0.81f, 0.79f, 0.71f);

            for(CustomButton button : entries.get(i).getButtons()) {
                String id = button.getId();

                    // Entry Info
                if(id.contains("entry")) {
                    String villagerInfo = quest.villager.getName().getString() + " - " + quest.villager.getResidency().getHomeVillage().get().getName();

                    String questInfo = quest.completed + " of " + quest.goal;
                    if(quest.questType == QuestType.DELIVER) {
                        questInfo += " delivered";
                    } else if(quest.questType == QuestType.KILL) {
                        questInfo += " killed";
                    }

                    ResourceLocation location = new ResourceLocation("mcaquests", "textures/gui/entry.png");
                    renderEntry(poseStack, x, y, 143, 28, location, 0.72f, 0.70f, 0.62f);
                    drawCenteredString(poseStack, Minecraft.getInstance().font, Component.literal(villagerInfo), x + 65, y + 3, 0x8E8777);
                    drawCenteredString(poseStack, Minecraft.getInstance().font, Component.literal(questInfo), x + 65, y + 16, 0x8E8777);

                    // Track button
                } else if(id.contains("track")) {
                    if(TemporaryData.currentAcceptedQuests.get(player).get(i).tracked == true) {
                        ResourceLocation location = new ResourceLocation("mcaquests", "textures/gui/entry_button_pressed.png");
                        renderEntry(poseStack, x + 9, y + 5, 57, 18, location, 0.72f, 0.70f, 0.62f);
                    } else {
                        ResourceLocation location = new ResourceLocation("mcaquests", "textures/gui/entry_button.png");
                        renderEntry(poseStack, x + 9, y + 5, 57, 18, location, 0.86f, 0.84f, 0.76f);
                    }
                    drawString(poseStack, Minecraft.getInstance().font, Component.literal("Track"), x + 24, y + 10, 0x8E8777);

                  // Cancel and Confirm button
                } else if(id.contains("cancel") || id.contains("confirm")) {
                    ResourceLocation location = new ResourceLocation("mcaquests", "textures/gui/entry_button.png");
                    renderEntry(poseStack, x + 77, y + 5, 57, 18, location, 0.68f, 0.31f, 0.25f);
                    if(id.contains("cancel")) {
                        drawString(poseStack, Minecraft.getInstance().font, Component.literal("Cancel"), x + 90, y + 10, 0xEFEAD3);
                    } else {
                        drawString(poseStack, Minecraft.getInstance().font, Component.literal("Confirm"), x + 89, y + 10, 0xEFEAD3);
                    }

                    // Back button
                } else if(id.contains("back")) {
                    ResourceLocation location = new ResourceLocation("mcaquests", "textures/gui/entry_button.png");
                    renderEntry(poseStack, x + 9, y + 5, 57, 18, location, 0.86f, 0.84f, 0.76f);
                    drawString(poseStack, Minecraft.getInstance().font, Component.literal("Back"), x + 25, y + 10, 0x8E8777);
                }
            }

        }
    }

    @Override
    public void onPress(CustomButton button) {
        if(button.getId().contains("entry")) {
            changeLayout(button, "options");
        } else if(button.getId().contains("cancel")) {
            changeLayout(button, "confirm");
        } else if(button.getId().contains("track")) {
            TemporaryData.currentAcceptedQuests.get(player).get(button.getIndex()).changeTracked();
        }
    }

    private void giveQuestInfos() {

    }

    private void createButton(int i, int x, int y, int height, int width, String id) {
        CustomButton button = new CustomButton(x, y, height, width, Component.empty(), this, id);
        entries.get(i).addButton(button);
        this.addWidget(button);
    }

    private void renderEntry(PoseStack poseStack, int x, int y, int width, int height, ResourceLocation resourceLocation, float r, float g, float b) {
        RenderSystem.setShaderTexture(0, resourceLocation);
        RenderSystem.setShaderColor(r, g, b, 1);
        blit(poseStack, x, y, 0, 0, width, height, width, height);
        RenderSystem.setShaderColor(255, 255, 255, 1);
    }

    private void changeLayout(CustomButton button, String layout) {
        int index = button.getIndex();
        entries.get(index).setCurrentLayout(layout);
        entries.get(index).clearButtons();
        this.removeWidget(button);
        addButtons(index);
    }
}
