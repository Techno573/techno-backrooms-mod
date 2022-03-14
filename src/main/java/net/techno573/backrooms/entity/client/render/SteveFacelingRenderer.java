package net.techno573.backrooms.entity.client.render;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.techno573.backrooms.BackroomsMod;
import net.techno573.backrooms.entity.client.model.SteveFacelingModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class SteveFacelingRenderer extends GeoEntityRenderer {
    public SteveFacelingRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new SteveFacelingModel());
    }

    @Override
    public Identifier getTextureLocation(Object object) {
        return BackroomsMod.id("textures/entity/faceling/steve.png");
    }
}
