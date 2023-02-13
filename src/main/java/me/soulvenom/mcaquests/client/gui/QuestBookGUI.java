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

public class QuestBookGUI extends Screen {

    private Quest[] quests;
    private Player player;

    public QuestBookGUI(Component pTitle) {
        super(pTitle);
        player = Minecraft.getInstance().player;
    }

    @Override
    protected void init() {
        super.init();

        // quest
        if(TemporaryData.currentAcceptedQuests.containsKey(player)) {
            for(int i = 0; i < TemporaryData.currentAcceptedQuests.get(player).size(); i++) {
                renderQuest(TemporaryData.currentAcceptedQuests.get(player).get(i), i);
            }

        }
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

    public void addQuestButtons(Quest quest, int slot) {
        int centralY = slot * 30 + 10;
        int centralX = 50;

        if(slot > 5) {
            centralX = 100;
        }

        // entry_background
        this.addWidget(centralX, centralY, 143, 28)

    }

    public void 

    private void hovering() {

    }


}
