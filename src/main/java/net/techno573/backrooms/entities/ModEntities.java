package net.techno573.backrooms.entities;

import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.registry.Registry;
import net.techno573.backrooms.BackroomsMod;
import net.techno573.backrooms.entities.advanced.FacelingEntity;
import net.techno573.backrooms.entities.renderers.AlexFacelingEntityRenderer;
import net.techno573.backrooms.entities.renderers.SteveFacelingEntityRenderer;

public class ModEntities{

    public static final EntityType<FacelingEntity> STEVE_FACELING = registerEntity("steve_faceling",FabricEntityTypeBuilder
            .create(SpawnGroup.CREATURE,FacelingEntity::new)
            .dimensions(EntityDimensions.fixed(0.5f,1.8f))
            .build());

    public static final EntityType<FacelingEntity> ALEX_FACELING = registerEntity("alex_faceling",FabricEntityTypeBuilder
            .create(SpawnGroup.CREATURE,FacelingEntity::new)
            .dimensions(EntityDimensions.fixed(0.5f,1.8f))
            .build());

    private static EntityType registerEntity(String name, EntityType entityType) {
        return Registry.register(Registry.ENTITY_TYPE, BackroomsMod.id(name), entityType);
    }

    public static void registerEntityAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.STEVE_FACELING, FacelingEntity.createFacelingAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.ALEX_FACELING, FacelingEntity.createFacelingAttributes());

    }

    public static void registerEntityRenderers() {
        EntityRendererRegistry.INSTANCE.register(ModEntities.STEVE_FACELING, SteveFacelingEntityRenderer::new);
        EntityRendererRegistry.INSTANCE.register(ModEntities.ALEX_FACELING, AlexFacelingEntityRenderer::new);
    }
}
