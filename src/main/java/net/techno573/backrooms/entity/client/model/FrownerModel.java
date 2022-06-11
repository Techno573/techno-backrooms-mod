package net.techno573.backrooms.entity.client.model;

import net.minecraft.util.Identifier;
import net.techno573.backrooms.BackroomsMod;
import net.techno573.backrooms.entity.advanced.FrownerEntity;
import net.techno573.backrooms.entity.advanced.SmilerEntity;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class FrownerModel extends AnimatedGeoModel<FrownerEntity> {

    @Override
    public Identifier getModelLocation(FrownerEntity object) {
        return BackroomsMod.id("geo/frowner.geo.json");
    }

    @Override
    public Identifier getTextureLocation(FrownerEntity object) {
        return BackroomsMod.id("textures/entity/frowner.png");
    }

    @Override
    public Identifier getAnimationFileLocation(FrownerEntity animatable) {
        return null;
    }

    @Override
    public void setLivingAnimations(FrownerEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("Head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}
