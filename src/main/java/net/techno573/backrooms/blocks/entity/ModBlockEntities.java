package net.techno573.backrooms.blocks.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.techno573.backrooms.BackroomsMod;
import net.techno573.backrooms.blocks.ModBlocks;

public class ModBlockEntities {

    public static BlockEntityType<OfficeDrawerEntity> OFFICE_DRAWER;
    public static BlockEntityType<FlashlightLightEntity> FLASHLIGHT_LIGHT;

    public static void registerModBlockEntities() {
        OFFICE_DRAWER = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(BackroomsMod.MOD_ID, "office_drawer"),
                FabricBlockEntityTypeBuilder.create(OfficeDrawerEntity::new,
                        ModBlocks.OFFICE_DRAWER).build(null));

        FLASHLIGHT_LIGHT = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(BackroomsMod.MOD_ID, "flashlight_light"),
                FabricBlockEntityTypeBuilder.create(FlashlightLightEntity::new,
                        ModBlocks.FLASHLIGHT_LIGHT).build(null));
    }
}
