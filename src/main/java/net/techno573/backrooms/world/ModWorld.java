package net.techno573.backrooms.world;

import com.mojang.serialization.Codec;
import net.ludocrypt.limlib.api.sound.ReverbSettings;
import net.ludocrypt.limlib.api.world.LiminalWorld;
import net.ludocrypt.limlib.impl.LiminalEffects;
import net.ludocrypt.limlib.impl.world.LiminalDimensions;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.FixedBiomeSource;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.techno573.backrooms.BackroomsMod;
import net.techno573.backrooms.world.biomes.Level0Biome;
import net.techno573.backrooms.world.biomes.Level1Biome;
import net.techno573.backrooms.world.biomes.Level2Biome;
import net.techno573.backrooms.world.chunks.Level0ChunkGen;
import net.techno573.backrooms.world.chunks.Level1ChunkGen;
import net.techno573.backrooms.world.chunks.Level2ChunkGen;
import net.techno573.backrooms.world.chunks.Level3ChunkGen;

import java.util.Optional;
import java.util.OptionalLong;

public class ModWorld {

    public static RegistryKey<Biome> getBiome(String id, Biome biome) {
        Registry.register(BuiltinRegistries.BIOME, BackroomsMod.id(id), biome);
        return RegistryKey.of(Registry.BIOME_KEY, BackroomsMod.id(id));
    }

    public static <T extends LiminalWorld> T getWorld(String id, T block) {
        return Registry.register(LiminalDimensions.LIMINAL_WORLD_REGISTRY, BackroomsMod.id(id), block);
    }

    public static <T extends Codec<? extends ChunkGenerator>> T getChunkGen(String id, T item) {
        return Registry.register(Registry.CHUNK_GENERATOR, BackroomsMod.id(id), item);
    }

    //Biome List
    public static final RegistryKey<Biome> LEVEL_0_BIOME = getBiome("level_0", Level0Biome.create());
    public static final RegistryKey<Biome> LEVEL_1_BIOME = getBiome("level_1", Level1Biome.create());
    public static final RegistryKey<Biome> LEVEL_2_BIOME = getBiome("level_2", Level2Biome.create());
    public static final RegistryKey<Biome> LEVEL_3_BIOME = getBiome("level_3", Level2Biome.create());


    //Effects List

    public static final LiminalEffects LEVEL_0_EFFECTS = new LiminalEffects(Optional.empty(), Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(), Optional.of(new ReverbSettings().setEnabled(false)));
    public static final LiminalEffects LEVEL_1_EFFECTS = new LiminalEffects(Optional.empty(), Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(), Optional.of(new ReverbSettings().setEnabled(true).setDecayTime(1.5f).setDensity(1.25f)));
    public static final LiminalEffects LEVEL_2_EFFECTS = new LiminalEffects(Optional.empty(), Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(), Optional.of(new ReverbSettings().setEnabled(true).setDecayTime(1.75f).setDensity(1.5f)));
    public static final LiminalEffects LEVEL_3_EFFECTS = new LiminalEffects(Optional.empty(), Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(), Optional.of(new ReverbSettings().setEnabled(true).setDecayTime(1.75f).setDensity(1.5f)));


    //Dimension List
    public static final LiminalWorld LEVEL_0_WORLD = getWorld("level_0",new LiminalWorld(BackroomsMod.id("level_0"),DimensionType.create(
            OptionalLong.of(6000),true,false,false, false,1.0f,false,
            false,true,true,false,0,128,5, BackroomsMod.id("level_0"), BackroomsMod.id("level_0"),
            0.0f), (biomeRegistry, seed) -> new Level0ChunkGen(new FixedBiomeSource(biomeRegistry.getOrThrow(ModWorld.LEVEL_0_BIOME)),seed),LEVEL_0_EFFECTS));

    public static final LiminalWorld LEVEL_1_WORLD = getWorld("level_1",new LiminalWorld(BackroomsMod.id("level_1"),DimensionType.create(
            OptionalLong.of(6000),true,false,false, false,1.0f,false,
            false,true,true,false,0,128,5, BackroomsMod.id("level_1"), BackroomsMod.id("level_1"),
            0.0f), (biomeRegistry, seed) -> new Level1ChunkGen(new FixedBiomeSource(biomeRegistry.getOrThrow(ModWorld.LEVEL_1_BIOME)),seed),LEVEL_1_EFFECTS));

    public static final LiminalWorld LEVEL_2_WORLD = getWorld("level_2",new LiminalWorld(BackroomsMod.id("level_2"),DimensionType.create(
            OptionalLong.of(6000),true,false,false, false,1.0f,false,
            false,true,true,false,0,128,5, BackroomsMod.id("level_2"), BackroomsMod.id("level_2"),
            0.0f), (biomeRegistry, seed) -> new Level2ChunkGen(new FixedBiomeSource(biomeRegistry.getOrThrow(ModWorld.LEVEL_2_BIOME)),seed),LEVEL_2_EFFECTS));

    public static final LiminalWorld LEVEL_3_WORLD = getWorld("level_3",new LiminalWorld(BackroomsMod.id("level_3"),DimensionType.create(
            OptionalLong.of(6000),true,false,false, false,1.0f,false,
            false,true,true,false,0,128,5, BackroomsMod.id("level_3"), BackroomsMod.id("level_3"),
            0.0f), (biomeRegistry, seed) -> new Level3ChunkGen(new FixedBiomeSource(biomeRegistry.getOrThrow(ModWorld.LEVEL_3_BIOME)),seed),LEVEL_3_EFFECTS));

    //Chunk Generator List
    public static void init() {

        getChunkGen("level_0_chunk_generator", Level0ChunkGen.CODEC);
        getChunkGen("level_1_chunk_generator", Level1ChunkGen.CODEC);
        getChunkGen("level_2_chunk_generator", Level2ChunkGen.CODEC);
        getChunkGen("level_3_chunk_generator", Level3ChunkGen.CODEC);


    }
}
