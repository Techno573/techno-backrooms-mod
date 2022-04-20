package net.techno573.backrooms.entity.client.model;

import net.minecraft.util.Identifier;
import net.techno573.backrooms.BackroomsMod;
import net.techno573.backrooms.entity.advanced.DullerEntity;
import net.techno573.backrooms.entity.advanced.HoundEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class HoundModel extends AnimatedGeoModel<HoundEntity> {

    @Override
    public Identifier getModelLocation(HoundEntity object) {
        return BackroomsMod.id("geo/hound.geo.json");
    }

    @Override
    public Identifier getTextureLocation(HoundEntity object) {
        return BackroomsMod.id("textures/entity/hound.png");
    }

    @Override
    public Identifier getAnimationFileLocation(HoundEntity animatable) {
        return BackroomsMod.id("animations/hound.animation.json");
    }
}
