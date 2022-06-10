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

public class Lvl5PortalBlock extends Block {
    public Lvl5PortalBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (world instanceof ServerWorld && !entity.hasVehicle() && entity.isPlayer() && !entity.hasPassengers() && entity.canUsePortals() && world.getRegistryKey() != ModWorld.LEVEL_6_WORLD.getWorldKey() && VoxelShapes.matchesAnywhere(VoxelShapes.cuboid(entity.getBoundingBox().offset(-pos.getX(), -pos.getY(), -pos.getZ())), state.getOutlineShape(world, pos), BooleanBiFunction.AND)) {

            ServerWorld serverWorld = ((ServerWorld)world).getServer().getWorld(ModWorld.LEVEL_6_WORLD.getWorldKey());
            if (serverWorld == null) {
                return;
            }

            LiminalUtil.travelTo(
                    entity,
                    serverWorld,
                    new TeleportTarget(
                            new Vec3d(22, 3,22),
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
