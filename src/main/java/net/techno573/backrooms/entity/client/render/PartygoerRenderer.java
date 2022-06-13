package net.techno573.backrooms.entity.client.render;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.techno573.backrooms.BackroomsMod;
import net.techno573.backrooms.entity.client.model.DullerModel;
import net.techno573.backrooms.entity.client.model.PartygoerModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class PartygoerRenderer extends GeoEntityRenderer {

    public PartygoerRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new PartygoerModel());
    }

    @Override
    public Identifier getTextureLocation(Object object) {
        return BackroomsMod.id("textures/entity/partygoer.png");
    }
}
