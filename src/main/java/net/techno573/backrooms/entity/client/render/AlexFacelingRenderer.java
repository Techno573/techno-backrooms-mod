package net.techno573.backrooms.entity.client.render;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.techno573.backrooms.BackroomsMod;
import net.techno573.backrooms.entity.client.model.AlexFacelingModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class AlexFacelingRenderer extends GeoEntityRenderer {

    public AlexFacelingRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new AlexFacelingModel());
    }

    @Override
    public Identifier getTextureLocation(Object object) {
        return BackroomsMod.id("textures/entity/faceling/alex.png");
    }

}
