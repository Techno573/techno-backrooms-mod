package net.techno573.backrooms.world;

import com.mojang.serialization.Codec;
import net.ludocrypt.limlib.api.sound.LiminalTravelSound;
import net.ludocrypt.limlib.api.sound.ReverbSettings;
import net.ludocrypt.limlib.api.world.LiminalWorld;
import net.ludocrypt.limlib.impl.LiminalEffects;
import net.ludocrypt.limlib.impl.world.LiminalDimensions;
import net.minecraft.client.render.DimensionEffects;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.FixedBiomeSource;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.techno573.backrooms.Main;
import net.techno573.backrooms.sounds.ModSounds;
import net.techno573.backrooms.world.biomes.Level0Biome;
import net.techno573.backrooms.world.biomes.Level1Biome;
import net.techno573.backrooms.world.chunks.Level0ChunkGen;
import net.techno573.backrooms.world.chunks.Level1ChunkGen;
import org.apache.commons.lang3.mutable.Mutable;

import java.util.Optional;
import java.util.OptionalLong;

public class ModWorld {

    public static RegistryKey<Biome> getBiome(String id, Biome biome) {
        Registry.register(BuiltinRegistries.BIOME, Main.id(id), biome);
        return RegistryKey.of(Registry.BIOME_KEY, Main.id(id));
    }

    public static <T extends LiminalWorld> T getWorld(String id, T block) {
        return Registry.register(LiminalDimensions.LIMINAL_WORLD_REGISTRY, Main.id(id), block);
    }

    public static <T extends Codec<? extends ChunkGenerator>> T getChunkGen(String id, T item) {
        return Registry.register(Registry.CHUNK_GENERATOR, Main.id(id), item);
    }

    //Biome List
    public static final RegistryKey<Biome> LEVEL_0_BIOME = getBiome("level_0", Level0Biome.create());
    public static final RegistryKey<Biome> LEVEL_1_BIOME = getBiome("level_1", Level1Biome.create());

    //Effects List

    public static final LiminalEffects LEVEL_0_EFFECTS = new LiminalEffects(Optional.empty(), Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(), Optional.of(new ReverbSettings().setEnabled(false)));
    public static final LiminalEffects LEVEL_1_EFFECTS = new LiminalEffects(Optional.empty(), Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(), Optional.of(new ReverbSettings().setEnabled(true)));

    //Dimension List
    public static final LiminalWorld LEVEL_0_WORLD = getWorld("level_0",new LiminalWorld(Main.id("level_0"),DimensionType.create(
            OptionalLong.of(6000),true,false,false, false,1.0f,false,
            false,true,true,false,0,128,128,Main.id("level_0"),Main.id("level_0"),
            0.0f), (biomeRegistry, seed) -> new Level0ChunkGen(new FixedBiomeSource(biomeRegistry.getOrThrow(ModWorld.LEVEL_0_BIOME)),seed),LEVEL_0_EFFECTS));

    public static final LiminalWorld LEVEL_1_WORLD = getWorld("level_1",new LiminalWorld(Main.id("level_1"),DimensionType.create(
            OptionalLong.of(6000),true,false,false, false,1.0f,false,
            false,true,true,false,0,128,128,Main.id("level_1"),Main.id("level_1"),
            0.0f), (biomeRegistry, seed) -> new Level1ChunkGen(new FixedBiomeSource(biomeRegistry.getOrThrow(ModWorld.LEVEL_1_BIOME)),seed),LEVEL_1_EFFECTS));


    //Chunk Generator List
    public static void init() {

        getChunkGen("level_0_chunk_generator", Level0ChunkGen.CODEC);
        getChunkGen("level_1_chunk_generator", Level1ChunkGen.CODEC);

    }
}
