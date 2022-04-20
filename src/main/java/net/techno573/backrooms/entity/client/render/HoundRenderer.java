package net.techno573.backrooms.entity.client.render;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.techno573.backrooms.BackroomsMod;
import net.techno573.backrooms.entity.client.model.HoundModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class HoundRenderer extends GeoEntityRenderer {

    public HoundRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new HoundModel());
    }

    @Override
    public Identifier getTextureLocation(Object object) {
        return BackroomsMod.id("textures/entity/hound.png");
    }
}
