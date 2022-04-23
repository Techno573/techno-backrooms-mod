package net.techno573.backrooms.entity.client.model;

import net.minecraft.util.Identifier;
import net.techno573.backrooms.BackroomsMod;
import net.techno573.backrooms.entity.advanced.DullerEntity;
import net.techno573.backrooms.entity.advanced.FacelingEntity;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

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

    @Override
    public void setLivingAnimations(DullerEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("Head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}
