package net.techno573.backrooms.world;

import com.mojang.serialization.Codec;
import net.ludocrypt.limlib.api.LiminalEffects;
import net.ludocrypt.limlib.api.LiminalWorld;
import net.ludocrypt.limlib.api.render.LiminalBaseEffects;
import net.ludocrypt.limlib.api.render.LiminalSkyRenderer;
import net.ludocrypt.limlib.api.sound.ReverbSettings;
import net.ludocrypt.limlib.impl.LimlibRegistries;
import net.minecraft.client.render.DimensionEffects;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.FixedBiomeSource;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.techno573.backrooms.BackroomsMod;
import net.techno573.backrooms.world.biomes.*;
import net.techno573.backrooms.world.chunks.*;

import java.util.Optional;
import java.util.OptionalLong;

public class ModWorld {

    public static RegistryKey<Biome> getBiome(String id, Biome biome) {
        Registry.register(BuiltinRegistries.BIOME, BackroomsMod.id(id), biome);
        return RegistryKey.of(Registry.BIOME_KEY, BackroomsMod.id(id));
    }

    public static <T extends LiminalWorld> T getWorld(String id, T block) {
        return Registry.register(LimlibRegistries.LIMINAL_WORLD, BackroomsMod.id(id), block);
    }

    public static <T extends Codec<? extends ChunkGenerator>> T getChunkGen(String id, T item) {
        return Registry.register(Registry.CHUNK_GENERATOR, BackroomsMod.id(id), item);
    }

    //Biome List
    public static final RegistryKey<Biome> LEVEL_0_BIOME = getBiome("level_0", Level0Biome.create());
    public static final RegistryKey<Biome> LEVEL_1_BIOME = getBiome("level_1", Level1Biome.create());
    public static final RegistryKey<Biome> LEVEL_2_BIOME = getBiome("level_2", Level2Biome.create());
    public static final RegistryKey<Biome> LEVEL_3_BIOME = getBiome("level_3", Level3Biome.create());
    public static final RegistryKey<Biome> LEVEL_4_BIOME = getBiome("level_4", Level4Biome.create());
    public static final RegistryKey<Biome> LEVEL_5_BIOME = getBiome("level_5", Level5Biome.create());
    public static final RegistryKey<Biome> LEVEL_6_BIOME = getBiome("level_6", Level6Biome.create());
    public static final RegistryKey<Biome> LEVEL_FUN_BIOME = getBiome("level_fun", LevelFunBiome.create());

    //Effects List
    public static final LiminalEffects LEVEL_0_EFFECTS = new LiminalEffects(Optional.of(new LiminalBaseEffects.SimpleBaseEffects(Optional.empty(), false, DimensionEffects.SkyType.NONE.toString(), false, false, false)), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty());
    public static final LiminalEffects LEVEL_1_EFFECTS = new LiminalEffects(Optional.of(new LiminalBaseEffects.SimpleBaseEffects(Optional.empty(), false, DimensionEffects.SkyType.NONE.toString(), false, false, false)), Optional.empty(), Optional.empty(), Optional.empty(), Optional.of(new ReverbSettings().setEnabled(true).setDecayTime(1.25f).setDensity(1.25f)));
    public static final LiminalEffects LEVEL_2_EFFECTS = new LiminalEffects(Optional.of(new LiminalBaseEffects.SimpleBaseEffects(Optional.empty(), false, DimensionEffects.SkyType.NONE.toString(), false, false, false)), Optional.empty(), Optional.empty(), Optional.empty(), Optional.of(new ReverbSettings().setEnabled(true).setDecayTime(1.5f).setDensity(1.25f)));
    public static final LiminalEffects LEVEL_3_EFFECTS = new LiminalEffects(Optional.of(new LiminalBaseEffects.SimpleBaseEffects(Optional.empty(), false, DimensionEffects.SkyType.NONE.toString(), false, false, false)), Optional.empty(), Optional.empty(), Optional.empty(), Optional.of(new ReverbSettings().setEnabled(true).setDecayTime(1.25f).setDensity(1.25f)));
    public static final LiminalEffects LEVEL_4_EFFECTS = new LiminalEffects(Optional.of(new LiminalBaseEffects.SimpleBaseEffects(Optional.empty(), false, DimensionEffects.SkyType.NONE.toString(), false, false, false)), Optional.empty(), Optional.empty(), Optional.empty(),  Optional.empty());
    public static final LiminalEffects LEVEL_5_EFFECTS = new LiminalEffects(Optional.of(new LiminalBaseEffects.SimpleBaseEffects(Optional.empty(), false, DimensionEffects.SkyType.NONE.toString(), false, false, false)), Optional.empty(), Optional.empty(), Optional.empty(), Optional.of(new ReverbSettings().setEnabled(true).setDecayTime(1.25f).setDensity(1.25f)));
    public static final LiminalEffects LEVEL_6_EFFECTS = new LiminalEffects(Optional.of(new LiminalBaseEffects.SimpleBaseEffects(Optional.empty(), false, DimensionEffects.SkyType.NONE.toString(), false, false, false)), Optional.empty(), Optional.empty(), Optional.empty(), Optional.of(new ReverbSettings().setEnabled(true).setDecayTime(1.25f).setDensity(1.25f)));
    public static final LiminalEffects LEVEL_FUN_EFFECTS = new LiminalEffects(Optional.of(new LiminalBaseEffects.SimpleBaseEffects(Optional.empty(), false, DimensionEffects.SkyType.NONE.toString(), false, false, false)), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty());

    //Dimension List
    public static final LiminalWorld LEVEL_0_WORLD = getWorld("level_0", new LiminalWorld(BackroomsMod.id("level_0"), DimensionType.create(
            OptionalLong.of(6000), true, false, false, false, 1.0f, false,
            false, true, false, false, 0, 128, 5,
            TagKey.of(Registry.BLOCK_KEY, BackroomsMod.id("level_0")), BackroomsMod.id("level_0"), 0.0F),
            (world, dimensionTypeRegistry, biomeRegistry, structureRegistry, chunkGeneratorSettingsRegistry, noiseSettingsRegistry, registryManager, seed) -> new DimensionOptions(dimensionTypeRegistry.getOrCreateEntry(world.getDimensionTypeKey()), new Level0ChunkGen(new FixedBiomeSource(biomeRegistry.getOrCreateEntry(ModWorld.LEVEL_0_BIOME)), seed)), LEVEL_0_EFFECTS));

    public static final LiminalWorld LEVEL_1_WORLD = getWorld("level_1", new LiminalWorld(BackroomsMod.id("level_1"), DimensionType.create(
            OptionalLong.of(6000), true, false, false, false, 1.0f, false,
            false, true, false, false, 0, 128, 5,
            TagKey.of(Registry.BLOCK_KEY, BackroomsMod.id("level_1")), BackroomsMod.id("level_1"), 0.0F),
            (world, dimensionTypeRegistry, biomeRegistry, structureRegistry, chunkGeneratorSettingsRegistry, noiseSettingsRegistry, registryManager, seed) -> new DimensionOptions(dimensionTypeRegistry.getOrCreateEntry(world.getDimensionTypeKey()), new Level1ChunkGen(new FixedBiomeSource(biomeRegistry.getOrCreateEntry(ModWorld.LEVEL_1_BIOME)), seed)), LEVEL_1_EFFECTS));


    public static final LiminalWorld LEVEL_2_WORLD = getWorld("level_2", new LiminalWorld(BackroomsMod.id("level_2"), DimensionType.create(
            OptionalLong.of(6000), true, false, false, false, 1.0f, false,
            false, true, false, false, 0, 128, 5,
            TagKey.of(Registry.BLOCK_KEY, BackroomsMod.id("level_2")), BackroomsMod.id("level_2"), 0.0F),
            (world, dimensionTypeRegistry, biomeRegistry, structureRegistry, chunkGeneratorSettingsRegistry, noiseSettingsRegistry, registryManager, seed) -> new DimensionOptions(dimensionTypeRegistry.getOrCreateEntry(world.getDimensionTypeKey()), new Level2ChunkGen(new FixedBiomeSource(biomeRegistry.getOrCreateEntry(ModWorld.LEVEL_2_BIOME)), seed)), LEVEL_2_EFFECTS));


    public static final LiminalWorld LEVEL_3_WORLD = getWorld("level_3", new LiminalWorld(BackroomsMod.id("level_3"), DimensionType.create(
            OptionalLong.of(6000), true, false, false, false, 1.0f, false,
            false, true, false, false, 0, 128, 5,
            TagKey.of(Registry.BLOCK_KEY, BackroomsMod.id("level_3")), BackroomsMod.id("level_3"), 0.0F),
            (world, dimensionTypeRegistry, biomeRegistry, structureRegistry, chunkGeneratorSettingsRegistry, noiseSettingsRegistry, registryManager, seed) -> new DimensionOptions(dimensionTypeRegistry.getOrCreateEntry(world.getDimensionTypeKey()), new Level3ChunkGen(new FixedBiomeSource(biomeRegistry.getOrCreateEntry(ModWorld.LEVEL_3_BIOME)), seed)), LEVEL_3_EFFECTS));

    public static final LiminalWorld LEVEL_4_WORLD = getWorld("level_4", new LiminalWorld(BackroomsMod.id("level_4"), DimensionType.create(
            OptionalLong.of(6000), true, false, false, false, 1.0f, false,
            false, true, false, false, 0, 128, 5,
            TagKey.of(Registry.BLOCK_KEY, BackroomsMod.id("level_4")), BackroomsMod.id("level_4"), 0.0F),
            (world, dimensionTypeRegistry, biomeRegistry, structureRegistry, chunkGeneratorSettingsRegistry, noiseSettingsRegistry, registryManager, seed) -> new DimensionOptions(dimensionTypeRegistry.getOrCreateEntry(world.getDimensionTypeKey()), new Level4ChunkGen(new FixedBiomeSource(biomeRegistry.getOrCreateEntry(ModWorld.LEVEL_4_BIOME)), seed)), LEVEL_4_EFFECTS));

    public static final LiminalWorld LEVEL_5_WORLD = getWorld("level_5", new LiminalWorld(BackroomsMod.id("level_5"), DimensionType.create(
            OptionalLong.of(6000), true, false, false, false, 1.0f, false,
            false, true, false, false, 0, 128, 5,
            TagKey.of(Registry.BLOCK_KEY, BackroomsMod.id("level_5")), BackroomsMod.id("level_5"), 0.0F),
            (world, dimensionTypeRegistry, biomeRegistry, structureRegistry, chunkGeneratorSettingsRegistry, noiseSettingsRegistry, registryManager, seed) -> new DimensionOptions(dimensionTypeRegistry.getOrCreateEntry(world.getDimensionTypeKey()), new Level5ChunkGen(new FixedBiomeSource(biomeRegistry.getOrCreateEntry(ModWorld.LEVEL_5_BIOME)), seed)), LEVEL_5_EFFECTS));

    public static final LiminalWorld LEVEL_6_WORLD = getWorld("level_6", new LiminalWorld(BackroomsMod.id("level_6"), DimensionType.create(
            OptionalLong.of(6000), true, false, false, false, 1.0f, false,
            false, true, false, false, 0, 128, 5,
            TagKey.of(Registry.BLOCK_KEY, BackroomsMod.id("level_6")), BackroomsMod.id("level_6"), 0.0F),
            (world, dimensionTypeRegistry, biomeRegistry, structureRegistry, chunkGeneratorSettingsRegistry, noiseSettingsRegistry, registryManager, seed) -> new DimensionOptions(dimensionTypeRegistry.getOrCreateEntry(world.getDimensionTypeKey()), new Level6ChunkGen(new FixedBiomeSource(biomeRegistry.getOrCreateEntry(ModWorld.LEVEL_6_BIOME)), seed)), LEVEL_6_EFFECTS));

    public static final LiminalWorld LEVEL_FUN_WORLD = getWorld("level_fun", new LiminalWorld(BackroomsMod.id("level_fun"), DimensionType.create(
            OptionalLong.of(6000), true, false, false, false, 1.0f, false,
            false, true, false, false, 0, 128, 5,
            TagKey.of(Registry.BLOCK_KEY, BackroomsMod.id("level_fun")), BackroomsMod.id("level_fun"), 0.0F),
            (world, dimensionTypeRegistry, biomeRegistry, structureRegistry, chunkGeneratorSettingsRegistry, noiseSettingsRegistry, registryManager, seed) -> new DimensionOptions(dimensionTypeRegistry.getOrCreateEntry(world.getDimensionTypeKey()), new LevelFunChunkGen(new FixedBiomeSource(biomeRegistry.getOrCreateEntry(ModWorld.LEVEL_FUN_BIOME)), seed)), LEVEL_FUN_EFFECTS));

    //Chunk Generator List
    public static void registerChunkGenerators() {

        getChunkGen("level_0_chunk_generator", Level0ChunkGen.CODEC);
        getChunkGen("level_1_chunk_generator", Level1ChunkGen.CODEC);
        getChunkGen("level_2_chunk_generator", Level2ChunkGen.CODEC);
        getChunkGen("level_3_chunk_generator", Level3ChunkGen.CODEC);
        getChunkGen("level_4_chunk_generator", Level4ChunkGen.CODEC);
        getChunkGen("level_5_chunk_generator", Level5ChunkGen.CODEC);
        getChunkGen("level_6_chunk_generator", Level6ChunkGen.CODEC);
        getChunkGen("level_fun_chunk_generator", LevelFunChunkGen.CODEC);

    }
}
