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
import net.techno573.backrooms.entities.models.SteveFacelingEntityModel;

@Environment(EnvType.CLIENT)
public class SteveFacelingEntityRenderer extends BipedEntityRenderer<FacelingEntity, SteveFacelingEntityModel<FacelingEntity>> {

    private static final Identifier TEXTURE = BackroomsMod.id("textures/entity/faceling/steve.png");

    public SteveFacelingEntityRenderer(EntityRendererFactory.Context context) {
        this(context, EntityModelLayers.PLAYER, EntityModelLayers.PLAYER_INNER_ARMOR, EntityModelLayers.PLAYER_OUTER_ARMOR);
    }

    public SteveFacelingEntityRenderer(EntityRendererFactory.Context ctx, EntityModelLayer layer, EntityModelLayer legArmorLayer, EntityModelLayer bodyArmorLayer) {
        super(ctx, new SteveFacelingEntityModel(ctx.getPart(layer)), 0.5f);
        this.addFeature(new ArmorFeatureRenderer(this, new SteveFacelingEntityModel(ctx.getPart(legArmorLayer)), new SteveFacelingEntityModel(ctx.getPart(bodyArmorLayer))));
    }

    @Override
    public Identifier getTexture(FacelingEntity maleFacelingEntity) {

        return TEXTURE;
    }

}
