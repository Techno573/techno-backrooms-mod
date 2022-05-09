package net.techno573.backrooms.world.chunks;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import com.mojang.serialization.Lifecycle;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.ludocrypt.limlib.api.LiminalUtil;
import net.ludocrypt.limlib.api.world.AbstractNbtChunkGenerator;
import net.minecraft.server.world.ChunkHolder;
import net.minecraft.server.world.ServerLightingProvider;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.StructureSet;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.SimpleRegistry;
import net.minecraft.world.ChunkRegion;
import net.minecraft.world.HeightLimitView;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.techno573.backrooms.BackroomsMod;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Function;

public class Level0ChunkGen extends AbstractNbtChunkGenerator {

    public static final Codec<Level0ChunkGen> CODEC = RecordCodecBuilder.create((level0ChunkGenInstance -> {
        return level0ChunkGenInstance.group(BiomeSource.CODEC.fieldOf("biome_source").stable().forGetter(
                (Level0ChunkGen) -> Level0ChunkGen.biomeSource
        ),Codec.LONG.fieldOf("seed").stable().forGetter((Level0ChunkGen) -> Level0ChunkGen.worldSeed)).apply(
                level0ChunkGenInstance,level0ChunkGenInstance.stable(Level0ChunkGen::new));
    }));

    private long worldSeed;

    public Level0ChunkGen(BiomeSource biomeSource, long worldSeed) {
        super(new SimpleRegistry<StructureSet>(Registry.STRUCTURE_SET_KEY, Lifecycle.stable(), null), Optional.empty(), biomeSource, biomeSource, worldSeed, BackroomsMod.id("level_0"), LiminalUtil.createMultiNoiseSampler());    }


    private int mod(int x, int n) {
        int r = x % n;
        if (r < 0) {
            r += n;
        }
        return r;
    }

    @Override
    protected Codec<? extends ChunkGenerator> getCodec() {
        return CODEC;
    }

    @Override
    public ChunkGenerator withSeed(long seed) {
        return new Level0ChunkGen(this.biomeSource,seed);
    }


    @Override
    public int getWorldHeight() {
        return 128;
    }

    @Override
    public int getHeight(int x, int z, Heightmap.Type heightmap, HeightLimitView world) {
        return 6;
    }

    @Override
    public void storeStructures(ServerWorld world) {
        store("roomset_light",world,0,6);
        store("roomset_dark",world,0,6);
        store("roomset_portal",world,0,6);
    }

    @Override
    public CompletableFuture<Chunk> populateNoise(ChunkRegion chunkRegion, ChunkStatus targetStatus, Executor executor, ServerWorld world, ChunkGenerator generator, StructureManager structureManager, ServerLightingProvider lightingProvider, Function<Chunk, CompletableFuture<Either<Chunk, ChunkHolder.Unloaded>>> function, List<Chunk> chunks, Chunk chunk, boolean bl) {
        int x = chunk.getPos().getStartX();
        int z = chunk.getPos().getStartZ();
        Random random = new Random(chunkRegion.getSeed() + MathHelper.hashCode(chunk.getPos().getStartX(), chunk.getPos().getStartZ(), x + z));

        if (mod(x, 48) == 0 && mod(z, 48) == 0) {

            if (random.nextInt(100) < 7){
                generateNbt(chunkRegion, chunk.getPos().getStartPos(), "roomset_portal_" + (random.nextInt(7)), BlockRotation.NONE);
            }
            else if (random.nextInt(100) >=7 && random.nextInt(100) < 30) {
                generateNbt(chunkRegion, chunk.getPos().getStartPos(), "roomset_dark_" + (random.nextInt(7)), BlockRotation.NONE);
            }
            else {
                generateNbt(chunkRegion, chunk.getPos().getStartPos(), "roomset_light_" + (random.nextInt(7)), BlockRotation.NONE);
            }

        }

        return CompletableFuture.completedFuture(chunk);
    }

    @Override
    public int chunkRadius() {
        return 3;
    }
}
