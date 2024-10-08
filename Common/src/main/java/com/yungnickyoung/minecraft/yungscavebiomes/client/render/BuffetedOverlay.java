package com.yungnickyoung.minecraft.yungscavebiomes.client.render;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.yungnickyoung.minecraft.yungscavebiomes.YungsCaveBiomesCommon;
import com.yungnickyoung.minecraft.yungscavebiomes.module.MobEffectModule;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class BuffetedOverlay {
    private static final ResourceLocation TEXTURE = YungsCaveBiomesCommon.id("textures/overlay/buffeted_overlay.png");
    private static final int MAX_TICKS = 200;
    private static final float MAX_OPACITY = 1.0f;
    private static final float MIN_COLOR = 0.1f;
    private static final float MAX_COLOR = 0.9f;

    private static int ticks;
    private static float color = 0.5f;

    /**
     * Renders the Buffeted overlay on the player's screen, with variable opacity depending
     * on the remaining duration of the effect.
     */
    public static void render(float partialTicks, int screenWidth, int screenHeight) {
        Minecraft client = Minecraft.getInstance();
        if (client.player == null) return;

        // Reset overlay on player death so it doesn't persist on respawn
        if (!client.player.isAlive()) {
            ticks = 0;
        }

        ticks = client.player.hasEffect(MobEffectModule.BUFFETED_EFFECT.get())
                ? Math.min(ticks + 1, MAX_TICKS)
                : Math.max(ticks - 1, 0);

        if (!client.player.isSpectator() && ticks > 0) {
            float opacity = Mth.clamp(ticks / (float) MAX_TICKS, 0, MAX_OPACITY);

            // Determine world light at player position
            int packedLight = client.getEntityRenderDispatcher().getPackedLightCoords(client.player, partialTicks);
            int worldLight = Mth.clamp(Math.max(LightTexture.block(packedLight), LightTexture.sky(packedLight)), 0, 15);
            int currLight = (int) (color * 16);

            // Determine color based on light
            int colorDiff = worldLight - currLight;
            color += .003f * colorDiff;
            color = Mth.clamp(color, MIN_COLOR, MAX_COLOR);

            renderOverlay(opacity, screenWidth, screenHeight, color);
        }
    }

    /**
     * Taken from vanilla's Gui class.
     */
    private static void renderOverlay(float opacity, int screenWidth, int screenHeight, float color) {
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(color, color, color, opacity);
        RenderSystem.setShaderTexture(0, TEXTURE);
        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder bufferbuilder = tesselator.getBuilder();
        bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        bufferbuilder
                .vertex(0.0D, screenHeight, -90.0D)
                .uv(0.0F, 1.0F)
                .endVertex();
        bufferbuilder
                .vertex(screenWidth, screenHeight, -90.0D)
                .uv(1.0F, 1.0F)
                .endVertex();
        bufferbuilder
                .vertex(screenWidth, 0.0D, -90.0D)
                .uv(1.0F, 0.0F)
                .endVertex();
        bufferbuilder
                .vertex(0.0D, 0.0D, -90.0D)
                .uv(0.0F, 0.0F)
                .endVertex();
        tesselator.end();
        RenderSystem.depthMask(true);
        RenderSystem.enableDepthTest();
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
    }
}
