package com.yungnickyoung.minecraft.yungscavebiomes.world;

import net.minecraft.core.Registry;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate;

/**
 * Used to attach data to NoiseChunk instances.
 * This data is needed for Marble Caves aquifer noise modification.
 */
public interface NoiseSamplerBiomeHolder {

    BiomeSource getBiomeSource();
    Registry<Biome> getBiomeRegistry();
    Climate.Sampler getClimateSampler();
    long getWorldSeed();

    void setBiomeSource(BiomeSource source);
    void setBiomeRegistry(Registry<Biome> registry);
    void setClimateSampler(Climate.Sampler sampler);
    void setWorldSeed(long seed);
}
