package net.techno573.backrooms.world.chunks;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.ludocrypt.limlib.api.world.NbtChunkGenerator;
import net.minecraft.server.world.ServerLightingProvider;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.structure.StructureManager;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.ChunkRegion;
import net.minecraft.world.HeightLimitView;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.techno573.backrooms.BackroomsMod;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class Level2ChunkGen extends NbtChunkGenerator {

    public static final Codec<Level2ChunkGen> CODEC = RecordCodecBuilder.create((level2ChunkGenInstance -> {
        return level2ChunkGenInstance.group(BiomeSource.CODEC.fieldOf("biome_source").stable().forGetter(
                (Level2ChunkGen) -> Level2ChunkGen.biomeSource
        ),Codec.LONG.fieldOf("seed").stable().forGetter((Level2ChunkGen) -> Level2ChunkGen.worldSeed)).apply(
                level2ChunkGenInstance,level2ChunkGenInstance.stable(Level2ChunkGen::new));
    }));

    public Level2ChunkGen(BiomeSource biomeSource, long worldSeed) {
        super(biomeSource, worldSeed, BackroomsMod.id("level_2"),List.of());
    }

    public Level2ChunkGen(BiomeSource biomeSource, MultiNoiseUtil.MultiNoiseSampler multiNoiseSampler, long worldSeed, Identifier nbtId, List<String> structures) {
        super(biomeSource, multiNoiseSampler, worldSeed, nbtId, structures);
    }

    private int mod(int x, int n) {
        int r = x % n;
        if (r < 0) {
            r += n;
        }
        return r;
    }

    @Override
    public CompletableFuture<Chunk> populateNoise(Executor executor, Chunk chunk, ChunkStatus targetStatus, ServerWorld world, ChunkRegion chunkRegion, StructureManager structureManager, ServerLightingProvider lightingProvider) {

        int x = chunk.getPos().getStartX();
        int z = chunk.getPos().getStartZ();
        Random random = new Random(chunkRegion.getSeed() + MathHelper.hashCode(chunk.getPos().getStartX(), chunk.getPos().getStartZ(), x + z));

        if (mod(x, 48) == 0 && mod(z, 48) == 0) {

            if (random.nextInt(100) < 7){
                generateNbt(chunkRegion, chunk.getPos().getStartPos(), "roomset_portal_" + (random.nextInt(7)), BlockRotation.NONE);
            }
            else if (random.nextInt(100) >=7 && random.nextInt(100) < 50) {
                generateNbt(chunkRegion, chunk.getPos().getStartPos(), "roomset_dark_" + (random.nextInt(7)), BlockRotation.NONE);
            }
            else {
                generateNbt(chunkRegion, chunk.getPos().getStartPos(), "roomset_light_" + (random.nextInt(7)), BlockRotation.NONE);
            }

        }

        return CompletableFuture.completedFuture(chunk);
    }

    @Override
    protected Codec<? extends ChunkGenerator> getCodec() {
        return CODEC;
    }

    @Override
    public ChunkGenerator withSeed(long seed) {
        return new Level2ChunkGen(biomeSource,seed);
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
        super.storeStructures(world);

        store("roomset_light",world,0,6);
        store("roomset_dark",world,0,6);
        store("roomset_portal",world,0,6);

    }

    @Override
    public int getChunkRadius() {
        return 3;
    }

    @Override
    protected Identifier getBarrelLootTable() {
        return BackroomsMod.id("containers/supply_crate");
    }
}
