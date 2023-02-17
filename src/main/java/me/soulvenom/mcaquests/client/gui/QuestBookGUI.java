package me.soulvenom.mcaquests.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import forge.net.mca.client.gui.widget.RectangleWidget;
import me.soulvenom.mcaquests.data.TemporaryData;
import me.soulvenom.mcaquests.obj.Quest;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.gui.widget.ExtendedButton;

import java.util.HashMap;

public class QuestBookGUI extends Screen {

    private Quest[] quests;
    private Player player;
    private HashMap<Quest, String> entries = new HashMap<>(); // Quest / Layout

    public QuestBookGUI(Component pTitle) {
        super(pTitle);
        player = Minecraft.getInstance().player;
    }

    @Override
    protected void init() {
        super.init();
        registerEntries();
    }

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(pPoseStack);

        // background
        int pHeight = 256;
        int pWidth = 420;
        RenderSystem.setShaderTexture(0, new ResourceLocation("mcaquests", "textures/gui/questbook.png"));
        blit(pPoseStack, this.width / 2 - (pWidth / 2), this.height / 2 - (pHeight / 2), 0, 0, pWidth, pHeight, pWidth, pHeight);

        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
    }

    private void registerEntries() {
        // Put everything into the entry hashmap
        if (TemporaryData.currentAcceptedQuests.containsKey(player)) {
            for (Quest quest : TemporaryData.currentAcceptedQuests.get(player)) {
                entries.put(quest, "default");
            }
        }
    }

    private void addButton() {
        // Has to be executed when one Entry layout is changes
        for(int i = 0; i < entries.size(); i++) {
            int y = i * 12 + 20;
            int x = 40;
            if(i > 5) {
                x = 80;
            }

            if (entries.values().toArray()[i] == "default") {
                this.addWidget(new Button(x, y, 143, 28, Component.literal("Entry"), pButton -> changeLayout()));
            }


        }
    }

    private void changeLayout() {

    }

    private void renderEntries(int slot) {

    }

    private void giveQuestInfos() {

    }


}
