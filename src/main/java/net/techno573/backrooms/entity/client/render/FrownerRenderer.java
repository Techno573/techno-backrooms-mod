package net.techno573.backrooms.entity.client.render;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.techno573.backrooms.BackroomsMod;
import net.techno573.backrooms.entity.client.model.FrownerModel;
import net.techno573.backrooms.entity.client.model.SmilerModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class FrownerRenderer extends GeoEntityRenderer {

    public FrownerRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new FrownerModel());
    }

    @Override
    public Identifier getTextureLocation(Object object) {
        return BackroomsMod.id("textures/entity/frowner.png");
    }

    @Override
    protected int getBlockLight(Entity entity, BlockPos pos) {
        return 15;
    }
}
