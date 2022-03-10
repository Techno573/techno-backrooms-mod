package net.techno573.backrooms.blocks.advanced;

import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneLampBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class FluorescentLampBlock extends RedstoneLampBlock {
    public FluorescentLampBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(0f, 0.875f, 0f, 1f, 1.0f, 1f);
    }

    @Override
    public boolean hasSidedTransparency(BlockState state) {
        return true;
    }
}
