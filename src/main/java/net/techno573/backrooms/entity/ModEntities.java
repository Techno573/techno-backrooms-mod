package net.techno573.backrooms.entity;

import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.registry.Registry;
import net.techno573.backrooms.BackroomsMod;
import net.techno573.backrooms.entity.advanced.DullerEntity;
import net.techno573.backrooms.entity.advanced.FacelingEntity;
import net.techno573.backrooms.entity.client.render.AlexFacelingRenderer;
import net.techno573.backrooms.entity.client.render.DullerRenderer;
import net.techno573.backrooms.entity.client.render.SteveFacelingRenderer;

public class ModEntities{

    public static final EntityType<FacelingEntity> STEVE_FACELING = registerEntity("steve_faceling",FabricEntityTypeBuilder
            .create(SpawnGroup.CREATURE,FacelingEntity::new)
            .dimensions(EntityDimensions.fixed(0.5f,1.8f))
            .build());

    public static final EntityType<FacelingEntity> ALEX_FACELING = registerEntity("alex_faceling",FabricEntityTypeBuilder
            .create(SpawnGroup.CREATURE,FacelingEntity::new)
            .dimensions(EntityDimensions.fixed(0.5f,1.8f))
            .build());

    public static final EntityType<DullerEntity> DULLER = registerEntity("duller",FabricEntityTypeBuilder
            .create(SpawnGroup.CREATURE,DullerEntity::new)
            .dimensions(EntityDimensions.fixed(0.5f,2.3f))
            .build());

    private static EntityType registerEntity(String name, EntityType entityType) {
        return Registry.register(Registry.ENTITY_TYPE, BackroomsMod.id(name), entityType);
    }

    public static void registerEntityAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.STEVE_FACELING, FacelingEntity.createFacelingAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.ALEX_FACELING, FacelingEntity.createFacelingAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.DULLER, DullerEntity.createFacelingAttributes());


    }

    public static void registerEntityRenderers() {
        EntityRendererRegistry.INSTANCE.register(ModEntities.STEVE_FACELING, SteveFacelingRenderer::new);
        EntityRendererRegistry.INSTANCE.register(ModEntities.ALEX_FACELING, AlexFacelingRenderer::new);
        EntityRendererRegistry.INSTANCE.register(ModEntities.DULLER, DullerRenderer::new);

    }
}
