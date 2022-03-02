package net.techno573.backrooms.mixin;

import net.fabricmc.fabric.api.dimension.v1.FabricDimensions;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.TeleportTarget;
import net.minecraft.world.World;
import net.techno573.backrooms.sounds.ModTravelSound;
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

        if (world instanceof ServerWorld && !player.hasVehicle() && !player.hasPassengers() && player.isInsideWall() && world.getRandom().nextDouble(1) < 0.01) {

            RegistryKey<World> registryKey = world.getRegistryKey() == ModWorld.LEVEL_0_WORLD.worldWorldRegistryKey ? World.OVERWORLD : ModWorld.LEVEL_0_WORLD.worldWorldRegistryKey;
            ServerWorld serverWorld = ((ServerWorld)world).getServer().getWorld(registryKey);
            if (serverWorld == null) {
                return;
            }

            ModTravelSound.isTraveling = true;
            FabricDimensions.teleport(
                    player,
                    serverWorld,
                    new TeleportTarget(
                            new Vec3d(player.getPos().x,5,player.getPos().z),
                            new Vec3d(0,0,0),
                            player.getYaw(),
                            player.getPitch()
                    )
            );
        }

    }

}
