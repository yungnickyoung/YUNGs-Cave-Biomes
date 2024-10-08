package com.yungnickyoung.minecraft.yungscavebiomes.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.yungnickyoung.minecraft.yungscavebiomes.client.model.SandSnapperModel;
import com.yungnickyoung.minecraft.yungscavebiomes.entity.sand_snapper.SandSnapperEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SandSnapperRenderer extends GeoEntityRenderer<SandSnapperEntity> {

    public SandSnapperRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SandSnapperModel());
    }

    @Override
    public RenderType getRenderType(SandSnapperEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityCutoutNoCull(texture);
    }

    @Override
    public void render(SandSnapperEntity animatable, float entityYaw, float partialTick, PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int packedLight) {
        poseStack.pushPose();
        if (animatable.isSubmerged() && !animatable.isDiving() && !animatable.isEmerging() && !animatable.isDiggingDown() && !animatable.isDiggingUp()) {
            poseStack.translate(0, -16.0f, 0);
        }
        super.render(animatable, entityYaw, partialTick, poseStack, bufferSource, packedLight);
        poseStack.popPose();
    }
}
