package net.techno573.backrooms.blocks.advanced;

import net.ludocrypt.limlib.api.LiminalUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.TeleportTarget;
import net.minecraft.world.World;
import net.techno573.backrooms.sounds.ModSounds;
import net.techno573.backrooms.world.ModWorld;

public class Lvl6PortalBlock extends Block {
    public Lvl6PortalBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (world instanceof ServerWorld && !entity.hasVehicle() && entity.isPlayer() && !entity.hasPassengers() && entity.canUsePortals() && world.getRegistryKey() != World.OVERWORLD && VoxelShapes.matchesAnywhere(VoxelShapes.cuboid(entity.getBoundingBox().offset(-pos.getX(), -pos.getY(), -pos.getZ())), state.getOutlineShape(world, pos), BooleanBiFunction.AND)) {

            ServerWorld serverWorld = ((ServerWorld)world).getServer().getWorld(World.OVERWORLD);
            ServerWorld levelFun = ((ServerWorld)world).getServer().getWorld(ModWorld.LEVEL_FUN_WORLD.getWorldKey());

            if (serverWorld == null || levelFun == null) {
                return;
            } else {
                if (entity.world.getRandom().nextDouble() < 0.35) {
                    LiminalUtil.travelTo(
                            entity,
                            levelFun,
                            new TeleportTarget(
                                    new Vec3d(serverWorld.getSpawnPos().getX(), 3,serverWorld.getSpawnPos().getZ()),
                                    new Vec3d(0,0,0),
                                    entity.getYaw(),
                                    entity.getPitch()
                            ),
                            ModSounds.TRAVEL_GLITCH,
                            1.0f,
                            1.0f
                    );
                } else {
                    LiminalUtil.travelTo(
                            entity,
                            serverWorld,
                            new TeleportTarget(
                                    new Vec3d(serverWorld.getSpawnPos().getX(),serverWorld.getSpawnPos().getY(),serverWorld.getSpawnPos().getZ()),
                                    new Vec3d(0,0,0),
                                    entity.getYaw(),
                                    entity.getPitch()
                            ),
                            ModSounds.TRAVEL_GLITCH,
                            1.0f,
                            1.0f
                    );
                }
            }
        }
    }
}
