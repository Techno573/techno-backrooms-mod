package net.techno573.backrooms.entity;

import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.registry.Registry;
import net.techno573.backrooms.BackroomsMod;
import net.techno573.backrooms.entity.advanced.*;
import net.techno573.backrooms.entity.client.render.*;

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

    public static final EntityType<HoundEntity> HOUND = registerEntity("hound",FabricEntityTypeBuilder
            .create(SpawnGroup.CREATURE,HoundEntity::new)
            .dimensions(EntityDimensions.fixed(0.9f,0.9f))
            .build());

    public static final EntityType<SmilerEntity> SMILER = registerEntity("smiler",FabricEntityTypeBuilder
            .create(SpawnGroup.CREATURE,SmilerEntity::new)
            .dimensions(EntityDimensions.fixed(0.8f,1.8f))
            .build());

    public static final EntityType<FrownerEntity> FROWNER = registerEntity("frower",FabricEntityTypeBuilder
            .create(SpawnGroup.CREATURE,FrownerEntity::new)
            .dimensions(EntityDimensions.fixed(0.8f,1.8f))
            .build());

    public static final EntityType<PartygoerEntity> PARTYGOER = registerEntity("partygoer",FabricEntityTypeBuilder
            .create(SpawnGroup.CREATURE,PartygoerEntity::new)
            .dimensions(EntityDimensions.fixed(0.5f,2.3f))
            .build());

    private static EntityType registerEntity(String name, EntityType entityType) {
        return Registry.register(Registry.ENTITY_TYPE, BackroomsMod.id(name), entityType);
    }

    public static void registerEntityAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.STEVE_FACELING, FacelingEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.ALEX_FACELING, FacelingEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.DULLER, DullerEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.HOUND, HoundEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.SMILER, SmilerEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.FROWNER, FrownerEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.PARTYGOER, PartygoerEntity.createAttributes());

    }

    public static void registerEntityRenderers() {
        EntityRendererRegistry.INSTANCE.register(ModEntities.STEVE_FACELING, SteveFacelingRenderer::new);
        EntityRendererRegistry.INSTANCE.register(ModEntities.ALEX_FACELING, AlexFacelingRenderer::new);
        EntityRendererRegistry.INSTANCE.register(ModEntities.DULLER, DullerRenderer::new);
        EntityRendererRegistry.INSTANCE.register(ModEntities.HOUND, HoundRenderer::new);
        EntityRendererRegistry.INSTANCE.register(ModEntities.SMILER, SmilerRenderer::new);
        EntityRendererRegistry.INSTANCE.register(ModEntities.FROWNER, FrownerRenderer::new);
        EntityRendererRegistry.INSTANCE.register(ModEntities.PARTYGOER, PartygoerRenderer::new);


    }
}
