package com.yungnickyoung.minecraft.yungscavebiomes.module;

import com.yungnickyoung.minecraft.yungsapi.api.autoregister.AutoRegister;
import com.yungnickyoung.minecraft.yungscavebiomes.YungsCaveBiomesCommon;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

@AutoRegister(YungsCaveBiomesCommon.MOD_ID)
public class BiomeModule {
    public static final ResourceKey<Biome> FROSTED_CAVES = register("frosted_caves");
    public static final ResourceKey<Biome> LOST_CAVES = register("lost_caves");

    private static ResourceKey<Biome> register(String path) {
        return ResourceKey.create(Registries.BIOME, YungsCaveBiomesCommon.id(path));
    }
}
