package net.techno573.backrooms.entity.advanced;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;
import net.techno573.backrooms.entity.goals.TeleportTargetToMeGoal;
import net.techno573.backrooms.sounds.ModSounds;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;


public class DullerEntity extends HostileEntity implements IAnimatable {

    private AnimationFactory factory = new AnimationFactory(this);

    public DullerEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.ignoreCameraFrustum = true;
    }

    //Attributes
    public static DefaultAttributeContainer.Builder createDullerAttributes() {
        return HostileEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 16)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED,0.35)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5.0)
                .add(EntityAttributes.GENERIC_ARMOR,2.0)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 25);
    }

    //Goals
    @Override
    protected void initGoals() {
        this.goalSelector.add(1,new TeleportTargetToMeGoal(this,8,5));
        this.goalSelector.add(2,new MeleeAttackGoal(this,1.0,false));
        this.goalSelector.add(3,new WanderAroundFarGoal(this,0.6));
        this.goalSelector.add(4,new LookAtEntityGoal(this,PlayerEntity.class,8.0f));
        this.goalSelector.add(5,new LookAroundGoal(this));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, false));
    }

    @Override
    protected boolean isDisallowedInPeaceful() {
        return true;
    }

    @Override
    public void onTrackedDataSet(TrackedData<?> data) {
        super.onTrackedDataSet(data);
    }

    //Sounds
    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.DULLER_SCREAM;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        if (this.isAttacking()) {
            return ModSounds.DULLER_SCREAM;
        }
        return ModSounds.DULLER_AMBIENT;
    }

    //Animations
    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController(this,"controller",0,this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    private <dullerEntity extends IAnimatable>PlayState predicate(AnimationEvent<dullerEntity> event) {
        if (event.isMoving() && !this.isAttacking()) {
            event.getController().setAnimationSpeed(2.5);
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.duller.walk"));
            return PlayState.CONTINUE;
        } else if (event.isMoving() && this.isAttacking()) {
            event.getController().setAnimationSpeed(5.5);
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.duller.run"));
            return PlayState.CONTINUE;
        }
        event.getController().setAnimationSpeed(1.5);
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.duller.idle"));
        return PlayState.CONTINUE;
    }
}
