package net.techno573.backrooms.entity.client.model;

import net.minecraft.util.Identifier;
import net.techno573.backrooms.BackroomsMod;
import net.techno573.backrooms.entity.advanced.FacelingEntity;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

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

    @Override
    public void setLivingAnimations(FacelingEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("Head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}
