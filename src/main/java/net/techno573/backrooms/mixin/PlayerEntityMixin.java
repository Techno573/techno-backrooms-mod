package net.techno573.backrooms.mixin;

import net.ludocrypt.limlib.api.LiminalUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.TeleportTarget;
import net.minecraft.world.World;
import net.techno573.backrooms.blocks.ModBlocks;
import net.techno573.backrooms.items.ModItems;
import net.techno573.backrooms.sounds.ModSounds;
import net.techno573.backrooms.world.ModWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {

    @Inject(method = "tick", at = @At("HEAD"))
    protected void injectTick(CallbackInfo info) {
        PlayerEntity player = ((PlayerEntity) (Object) this);
        World world = player.world;

        if (world instanceof ServerWorld && !player.hasVehicle() && !player.hasPassengers() && player.isInsideWall() && world.getRegistryKey() == World.OVERWORLD && world.getRandom().nextDouble(1) < 0.005) {

            ServerWorld serverWorld = ((ServerWorld)world).getServer().getWorld(ModWorld.LEVEL_0_WORLD.getWorldKey());
            if (serverWorld == null) {
                return;
            }

            LiminalUtil.travelTo(
                    player,
                    serverWorld,
                    new TeleportTarget(
                            new Vec3d(serverWorld.getSpawnPos().getX(), 3,serverWorld.getSpawnPos().getZ()),
                            new Vec3d(0,0,0),
                            player.getYaw(),
                            player.getPitch()
                    ),
                    ModSounds.TRAVEL_GLITCH,
                    1.0f,
                    1.0f
            );
        }

        if (!world.isClient()) {
            if (player.isHolding(ModItems.FLASHLIGHT)) {
                if (world.getBlockState(player.getCameraBlockPos()).isAir() || world.getBlockState(player.getCameraBlockPos()).isOf(ModBlocks.FLASHLIGHT_LIGHT)) {
                    world.setBlockState(player.getCameraBlockPos(), ModBlocks.FLASHLIGHT_LIGHT.getDefaultState());
                }
            }
        }
    }
}
