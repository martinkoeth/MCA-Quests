package me.soulvenom.mcaquests.client.gui;



import com.mojang.blaze3d.vertex.PoseStack;
import forge.net.mca.cobalt.network.NetworkHandler;
import forge.net.mca.entity.VillagerLike;
import forge.net.mca.network.c2s.InteractionCloseRequest;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class InteractionQuestGUI extends Screen {

//    VillagerLike villager = ((InteractScreenAccessor) InteractScreen).getVillager();
    VillagerLike villager;

    public InteractionQuestGUI(Component pTitle, VillagerLike villager) {
        super(pTitle);
        this.villager = villager;
    }

    @Override
    protected void init() {
        super.init();

        this.addRenderableWidget(new Button(this.width / 2 + 20, this.height / 2, 80, 20, Component.literal("Accept"), pButton -> onAccept()));
        this.addRenderableWidget(new Button(this.width / 2 - 100, this.height / 2, 80, 20, Component.literal("Decline"), pButton -> onDecline()));
    }

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(pPoseStack);
        drawCenteredString(pPoseStack, this.font, "Quest is here", this.width / 2, this.height / 2 - 70, 3);
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
    }

    @Override
    public void onClose() {
        super.onClose();

        NetworkHandler.sendToServer(new InteractionCloseRequest(villager.asEntity().getUUID()));
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    private void onAccept() {

    }

    private void onDecline() {

    }

    //    @Override
//    protected void init() {
//        super.init();
//        // Add Button
//        this.addRenderableWidget(new Button(100, 100, 100, 100, Component.literal("Accept"), pButton -> onAccept()));
//    }
//
//    @Override
//    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
//        renderBackground(pPoseStack);
//        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
//    }
//
//    @Override
//    public void tick() {
//        super.tick();
//    }
//
//    @Override
//    public void removed() {
//        super.removed();
//    }
//
//    @Override
//    public void onClose() {
//        super.onClose();
//    }
//
//    private void onAccept() {
//
//    }

    //    private int mouseX;
//    private int mouseY;
//    ExtendedButton acceptButton;
//
//    public InteractionQuestGUI(Component pTitle) {
//        super(pTitle);
//    }
//
//    public void setLayout(String guiKey) {
//        CreateScreenComponents();
//    }
//
//    public void CreateScreenComponents() {
//        acceptButton = new ExtendedButton(90, 90, 30, 30, Component.literal("Accept"), pButton -> { onAccept(); });
//        this.renderables.add(acceptButton);
//    }
//
//
//    @Override
//    public void init() {
//        super.init();
//
//
//    }
//
//    @Override
//    public void render(PoseStack matrices, int mouseX, int mouseY, float delta) {
//        super.render(matrices, mouseX, mouseY, delta);
//        this.mouseX = mouseX;
//        this.mouseY = mouseY;
//    }
//
//    @Override
//    public boolean shouldCloseOnEsc() {
//        return true;
//    }
//
//    public void onAccept() {
//
//    }
}
