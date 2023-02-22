package me.soulvenom.mcaquests.client.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.AbstractButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Widget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.Component;

class CustomButton extends Button {

    private final String id;
    private final ICustomOnPress onCustomPress;

    public CustomButton(int pX, int pY, int pWidth, int pHeight, Component pMessage, ICustomOnPress pOnPress, String id) {
        super(pX, pY, pWidth, pHeight, pMessage, Button::onPress);
        this.onCustomPress = pOnPress;
        this.id = id;
    }

    @Override
    public void onPress() {
        onCustomPress.onPress(this);
    }

    public String getId() {
        return id;
    }

    public int getIndex() {
        return Integer.parseInt(id.replaceAll("\\D+",""));
    }
}
