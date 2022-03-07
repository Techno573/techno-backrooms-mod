package net.techno573.backrooms.entities.renderers;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;
import net.techno573.backrooms.BackroomsMod;
import net.techno573.backrooms.entities.advanced.FacelingEntity;
import net.techno573.backrooms.entities.models.AlexFacelingEntityModel;
import net.techno573.backrooms.entities.models.SteveFacelingEntityModel;

@Environment(EnvType.CLIENT)
public class AlexFacelingEntityRenderer extends BipedEntityRenderer<FacelingEntity, AlexFacelingEntityModel<FacelingEntity>> {

    private static final Identifier TEXTURE = BackroomsMod.id("textures/entity/faceling/alex.png");

    public AlexFacelingEntityRenderer(EntityRendererFactory.Context context) {
        this(context, EntityModelLayers.PLAYER_SLIM, EntityModelLayers.PLAYER_SLIM_INNER_ARMOR, EntityModelLayers.PLAYER_SLIM_OUTER_ARMOR);
    }

    public AlexFacelingEntityRenderer(EntityRendererFactory.Context ctx, EntityModelLayer layer, EntityModelLayer legArmorLayer, EntityModelLayer bodyArmorLayer) {
        super(ctx, new AlexFacelingEntityModel(ctx.getPart(layer)), 0.5f);
        this.addFeature(new ArmorFeatureRenderer(this, new AlexFacelingEntityModel(ctx.getPart(legArmorLayer)), new AlexFacelingEntityModel(ctx.getPart(bodyArmorLayer))));
    }

    @Override
    public Identifier getTexture(FacelingEntity femaleFacelingEntity) {
        return TEXTURE;
    }

}
