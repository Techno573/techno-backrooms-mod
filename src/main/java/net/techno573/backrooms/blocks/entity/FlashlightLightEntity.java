package net.techno573.backrooms.blocks.entity;


import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FlashlightLightEntity extends BlockEntity {

    public int age;

    public FlashlightLightEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.FLASHLIGHT_LIGHT, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, FlashlightLightEntity blockEntity) {
        if (!world.isClient()) {
            blockEntity.age += 1;
            if (blockEntity.age > 2){
                world.removeBlock(pos,true);
                world.removeBlockEntity(pos);
            }
        }
    }
}
