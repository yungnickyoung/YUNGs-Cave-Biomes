package com.yungnickyoung.minecraft.yungscavebiomes.init;

import com.yungnickyoung.minecraft.yungscavebiomes.YungsCaveBiomes;
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

    public static void init() {
        Registry.register(Registry.BLOCK, new ResourceLocation(YungsCaveBiomes.MOD_ID, "icicle"), ICICLE);
        Registry.register(Registry.ITEM,
                new ResourceLocation(YungsCaveBiomes.MOD_ID, "icicle"),
                new BlockItem(ICICLE, new FabricItemSettings().group(CreativeModeTab.TAB_DECORATIONS)));
    }
}
