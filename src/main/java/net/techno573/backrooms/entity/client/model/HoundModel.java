package net.techno573.backrooms.entity.client.model;

import net.minecraft.util.Identifier;
import net.techno573.backrooms.BackroomsMod;
import net.techno573.backrooms.entity.advanced.DullerEntity;
import net.techno573.backrooms.entity.advanced.FacelingEntity;
import net.techno573.backrooms.entity.advanced.HoundEntity;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

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

    @Override
    public void setLivingAnimations(HoundEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("Head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}
