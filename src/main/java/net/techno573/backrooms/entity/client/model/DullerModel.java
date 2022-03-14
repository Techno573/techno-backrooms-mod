package net.techno573.backrooms.entity.client.model;

import net.minecraft.util.Identifier;
import net.techno573.backrooms.BackroomsMod;
import net.techno573.backrooms.entity.advanced.DullerEntity;
import net.techno573.backrooms.entity.advanced.FacelingEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DullerModel extends AnimatedGeoModel<DullerEntity> {

    @Override
    public Identifier getModelLocation(DullerEntity object) {
        return BackroomsMod.id("geo/duller.geo.json");
    }

    @Override
    public Identifier getTextureLocation(DullerEntity object) {
        return BackroomsMod.id("textures/entity/duller.png");
    }

    @Override
    public Identifier getAnimationFileLocation(DullerEntity animatable) {
        return BackroomsMod.id("animations/duller.animation.json");
    }
}
