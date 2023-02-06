package me.soulvenom.mcaquests.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import me.soulvenom.mcaquests.obj.Quest;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class QuestBookGUI extends Screen {

    private Quest[] quests;

    public QuestBookGUI(Component pTitle) {
        super(pTitle);
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(pPoseStack);

        // background
        int pHeight = 256;
        int pWidth = 420;
        RenderSystem.setShaderTexture(0, new ResourceLocation("mcaquests", "textures/gui/questbookgui.png"));
        blit(pPoseStack, this.width / 2 - (pWidth / 2), this.height / 2 - (pHeight / 2), 0, 0, pWidth, pHeight, pWidth, pHeight);


        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
    }

    public void renderQuests() {

    }


}
