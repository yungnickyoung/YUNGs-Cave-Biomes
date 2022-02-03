package com.yungnickyoung.minecraft.yungscavebiomes.init;

import com.yungnickyoung.minecraft.yungscavebiomes.YungsCaveBiomes;
import com.yungnickyoung.minecraft.yungscavebiomes.block.FrostLilyBlock;
import com.yungnickyoung.minecraft.yungscavebiomes.block.IcicleBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class YCBModBlocks {
    /** Blocks **/
    public static final Block ICICLE = new IcicleBlock(FabricBlockSettings
        .of(Material.STONE, MaterialColor.ICE)
        .noOcclusion()
        .sound(SoundType.GLASS)
        .randomTicks()
        .strength(0.5f)
        .dynamicShape());

    public static final Block FROST_LILY = new FrostLilyBlock(FabricBlockSettings
            .of(Material.ICE, MaterialColor.ICE)
            .noOcclusion()
            .dynamicShape()
            .instabreak()
            .lightLevel(blockState -> 10)
            .sound(SoundType.GLASS));

    public static final Block MARBLE = new Block(FabricBlockSettings
            .of(Material.STONE, MaterialColor.TERRACOTTA_WHITE)
            .requiresCorrectToolForDrops()
            .strength(1.3f, 4.0f)
            .sound(SoundType.STONE));

    public static final Block TRAVERTINE = new Block(FabricBlockSettings
            .of(Material.STONE, MaterialColor.TERRACOTTA_PINK)
            .requiresCorrectToolForDrops()
            .strength(1.5f, 6.0f)
            .sound(SoundType.CALCITE));

    public static void init() {
        Registry.register(Registry.BLOCK, new ResourceLocation(YungsCaveBiomes.MOD_ID, "icicle"), ICICLE);
        Registry.register(Registry.BLOCK, new ResourceLocation(YungsCaveBiomes.MOD_ID, "frost_lily"), FROST_LILY);
        Registry.register(Registry.BLOCK, new ResourceLocation(YungsCaveBiomes.MOD_ID, "marble"), MARBLE);
        Registry.register(Registry.BLOCK, new ResourceLocation(YungsCaveBiomes.MOD_ID, "travertine"), TRAVERTINE);
        Registry.register(Registry.ITEM,
                new ResourceLocation(YungsCaveBiomes.MOD_ID, "icicle"),
                new BlockItem(ICICLE, new FabricItemSettings().group(CreativeModeTab.TAB_DECORATIONS)));
        Registry.register(Registry.ITEM,
                new ResourceLocation(YungsCaveBiomes.MOD_ID, "frost_lily"),
                new BlockItem(FROST_LILY, new FabricItemSettings().group(CreativeModeTab.TAB_DECORATIONS)));
        Registry.register(Registry.ITEM,
                new ResourceLocation(YungsCaveBiomes.MOD_ID, "marble"),
                new BlockItem(MARBLE, new FabricItemSettings().group(CreativeModeTab.TAB_DECORATIONS)));
        Registry.register(Registry.ITEM,
                new ResourceLocation(YungsCaveBiomes.MOD_ID, "travertine"),
                new BlockItem(TRAVERTINE, new FabricItemSettings().group(CreativeModeTab.TAB_DECORATIONS)));

    }
}
