package me.soulvenom.mcaquests.client.gui;



import com.mojang.blaze3d.vertex.PoseStack;
import forge.net.mca.cobalt.network.NetworkHandler;
import forge.net.mca.entity.VillagerEntityMCA;
import forge.net.mca.entity.VillagerLike;
import forge.net.mca.network.c2s.InteractionCloseRequest;
import me.soulvenom.mcaquests.data.ClientData;
import me.soulvenom.mcaquests.data.TemporaryData;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

import java.util.ArrayList;

public class InteractionQuestGUI extends Screen {

//    VillagerLike villager = ((InteractScreenAccessor) InteractScreen).getVillager();
    VillagerEntityMCA villager;
    Player player;

    public InteractionQuestGUI(Component pTitle, VillagerEntityMCA villager) {
        super(pTitle);
        this.villager = villager;
        player = Minecraft.getInstance().player;
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

        // ALL THIS WILL HAVE TO BE REGISTERED IN A SERVER SIDE DATA CONTAINER ---------------------
        if(!TemporaryData.currentAcceptedQuests.containsKey(player)) {
            TemporaryData.currentAcceptedQuests.put(player, new ArrayList<>());
            // 10 -> config -> maxQuestAmount
        } else if(TemporaryData.currentAcceptedQuests.get(player).size() == 10) {
            // Say he has to many quests
            Minecraft.getInstance().setScreen(null);
            return;
        }
        TemporaryData.currentAcceptedQuests.get(Minecraft.getInstance().player).add(TemporaryData.currentAcceptableQuests.get(villager));
        TemporaryData.currentAcceptableQuests.remove(villager);

        // This makes it easier to track if the player should see a red book indicator
        TemporaryData.villagerWithQuests.add(villager);
        // ALL THIS WILL HAVE TO BE REGISTERED IN A SERVER SIDE DATA CONTAINER ---------------------


        // This makes it easier to track if the player should see a red book indicator
        ClientData.villagerWithQuestsForPlayer.add(villager);
        Minecraft.getInstance().setScreen(null);
    }

    private void onDecline() {
        Minecraft.getInstance().setScreen(null);
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
