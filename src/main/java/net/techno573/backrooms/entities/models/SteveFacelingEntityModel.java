package net.techno573.backrooms.entities.models;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.util.Arm;
import net.minecraft.util.math.MathHelper;

public class SteveFacelingEntityModel<T extends HostileEntity> extends BipedEntityModel<T> {

	public SteveFacelingEntityModel(ModelPart modelPart) {
		super(modelPart);
	}

	@Override
	public void animateModel(T mobEntity, float f, float g, float h) {
		this.rightArmPose = BipedEntityModel.ArmPose.EMPTY;
		this.leftArmPose = BipedEntityModel.ArmPose.EMPTY;
		super.animateModel(mobEntity, f, g, h);
	}

	@Override
	public void setAngles(T mobEntity, float f, float g, float h, float i, float j) {
		super.setAngles(mobEntity, f, g, h, i, j);
		if (mobEntity.isAttacking()) {
			float k = MathHelper.sin(this.handSwingProgress * (float)Math.PI);
			float l = MathHelper.sin((1.0f - (1.0f - this.handSwingProgress) * (1.0f - this.handSwingProgress)) * (float)Math.PI);
			this.rightArm.roll = 0.0f;
			this.leftArm.roll = 0.0f;
			this.rightArm.yaw = -(0.1f - k * 0.6f);
			this.leftArm.yaw = 0.1f - k * 0.6f;
			this.rightArm.pitch = -1.5707964f;
			this.leftArm.pitch = -1.5707964f;
			this.rightArm.pitch -= k * 1.2f - l * 0.4f;
			this.leftArm.pitch -= k * 1.2f - l * 0.4f;
		}
	}

	@Override
	public void setArmAngle(Arm arm, MatrixStack matrices) {
		float f = arm == Arm.RIGHT ? 1.0f : -1.0f;
		ModelPart modelPart = this.getArm(arm);
		modelPart.pivotX += f;
		modelPart.rotate(matrices);
		modelPart.pivotX -= f;
	}
}