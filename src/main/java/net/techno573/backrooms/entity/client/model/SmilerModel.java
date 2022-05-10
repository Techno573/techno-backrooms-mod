package net.techno573.backrooms.entity.client.model;

import net.minecraft.util.Identifier;
import net.techno573.backrooms.BackroomsMod;
import net.techno573.backrooms.entity.advanced.DullerEntity;
import net.techno573.backrooms.entity.advanced.SmilerEntity;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class SmilerModel extends AnimatedGeoModel<SmilerEntity> {

    @Override
    public Identifier getModelLocation(SmilerEntity object) {
        return BackroomsMod.id("geo/smiler.geo.json");
    }

    @Override
    public Identifier getTextureLocation(SmilerEntity object) {
        return BackroomsMod.id("textures/entity/smiler.png");
    }

    @Override
    public Identifier getAnimationFileLocation(SmilerEntity animatable) {
        return null;
    }

    @Override
    public void setLivingAnimations(SmilerEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("Head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}
