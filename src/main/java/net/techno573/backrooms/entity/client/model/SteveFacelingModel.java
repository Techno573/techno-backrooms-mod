package net.techno573.backrooms.entity.client.model;

import net.minecraft.util.Identifier;
import net.techno573.backrooms.BackroomsMod;
import net.techno573.backrooms.entity.advanced.FacelingEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SteveFacelingModel extends AnimatedGeoModel<FacelingEntity> {

    @Override
    public Identifier getModelLocation(FacelingEntity object) {
        return BackroomsMod.id("geo/steve_faceling.geo.json");
    }

    @Override
    public Identifier getTextureLocation(FacelingEntity object) {
        return BackroomsMod.id("textures/entity/faceling/steve.png");
    }

    @Override
    public Identifier getAnimationFileLocation(FacelingEntity animatable) {
        return BackroomsMod.id("animations/faceling.animation.json");
    }
}
