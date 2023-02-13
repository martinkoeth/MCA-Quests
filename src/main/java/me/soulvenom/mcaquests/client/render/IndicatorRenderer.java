package me.soulvenom.mcaquests.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Matrix4f;
import com.mojang.math.Quaternion;
import forge.net.mca.entity.VillagerLike;
import me.soulvenom.mcaquests.data.ClientData;
import me.soulvenom.mcaquests.data.TemporaryData;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class IndicatorRenderer {

    public static final ResourceLocation BOOK = new ResourceLocation("mcaquests:item/questbook");
    public static final ResourceLocation INDICATOR = new ResourceLocation("mcaquests:item/questindicator");

    @SubscribeEvent
    public void render(RenderLivingEvent event) {

        LocalPlayer player = Minecraft.getInstance().player;

        if(event.getEntity() instanceof VillagerLike) {
            VillagerLike villager = (VillagerLike) event.getEntity();
            if(TemporaryData.currentAcceptableQuests.containsKey(villager)) {
                int hearts = villager.getVillagerBrain().getMemoriesForPlayer(player).getHearts();
                if (TemporaryData.currentAcceptableQuests.get(villager).minRelationToSee <= hearts &&
                        TemporaryData.currentAcceptableQuests.get(villager).maxRelationToSee >= hearts) {
                    TextureAtlasSprite sprite = Minecraft.getInstance().getTextureAtlas(TextureAtlas.LOCATION_BLOCKS).apply(INDICATOR);
                    questIndicatorRenderer(0.5f, sprite, event.getPoseStack(), event.getMultiBufferSource());
                }
            } else if(TemporaryData.currentAcceptedQuests.containsKey(villager)) {
                    if(villager.asEntity().getId() == event.getEntity().getId()) {
                        TextureAtlasSprite sprite = Minecraft.getInstance().getTextureAtlas(TextureAtlas.LOCATION_BLOCKS).apply(BOOK);
                        questIndicatorRenderer(0.5f, sprite, event.getPoseStack(), event.getMultiBufferSource());
                    }
            }

        }


    }

    public void questIndicatorRenderer(float scale, TextureAtlasSprite sprite, PoseStack pose, MultiBufferSource buffer) {

        int brightness = LightTexture.FULL_BRIGHT;

        pose.pushPose();
        pose.translate(0, 2.5f, 0);
        Quaternion rotation = Minecraft.getInstance().gameRenderer.getMainCamera().rotation();
        pose.mulPose(rotation);
        VertexConsumer builder = buffer.getBuffer(RenderType.cutout());
        Matrix4f matrix = pose.last().pose();


        builder.vertex(matrix, -scale,-scale, 0f)
                .color(1f, 1f, 1f, 0.3f)
                .uv(sprite.getU1(), sprite.getV1())
                .uv2(brightness).normal(1,0,0).endVertex();

        builder.vertex(matrix, -scale,scale, 0f)
                .color(1f, 1f, 1f, 0.3f)
                .uv(sprite.getU1(), sprite.getV0())
                .uv2(brightness).normal(1,0,0).endVertex();

        builder.vertex(matrix, scale,scale, 0f)
                .color(1f, 1f, 1f, 0.3f)
                .uv(sprite.getU0(), sprite.getV0())
                .uv2(brightness).normal(1,0,0).endVertex();

        builder.vertex(matrix, scale,-scale, 0f)
                .color(1f, 1f, 1f, 0.3f)
                .uv(sprite.getU0(), sprite.getV1())
                .uv2(brightness)
                .normal(1,0,0).endVertex();


        pose.popPose();

    }






}
