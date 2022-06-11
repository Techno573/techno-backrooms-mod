package net.techno573.backrooms.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.registry.Registry;
import net.techno573.backrooms.BackroomsMod;
import net.techno573.backrooms.entity.ModEntities;
import net.techno573.backrooms.items.advanced.AlmondWaterItem;
import net.techno573.backrooms.items.advanced.MedicalKitItem;

public class ModItems {

    //Items List

    public static final Item ALMOND_WATER = registerItem("almond_water", new AlmondWaterItem(
            new FabricItemSettings().maxCount(16).food(ModFoods.ALMOND_WATER).group(ModItemGroup.TECHNO_BACKROOMS)));

    public static final Item MEDICAL_KIT = registerItem("medical_kit", new MedicalKitItem(
            new FabricItemSettings().maxCount(1).group(ModItemGroup.TECHNO_BACKROOMS)));

    public static final Item FLASHLIGHT = registerItem("flashlight", new Item(
            new FabricItemSettings().maxCount(1).group(ModItemGroup.TECHNO_BACKROOMS)));

    //Spawn Eggs
    public static final Item STEVE_FACELING_SPAWN_EGG = registerItem("steve_faceling_spawn_egg", new SpawnEggItem(
            ModEntities.STEVE_FACELING, 44975, 4602533, new Item.Settings().group(ModItemGroup.TECHNO_BACKROOMS)));

    public static final Item ALEX_FACELING_SPAWN_EGG = registerItem("alex_faceling_spawn_egg", new SpawnEggItem(
            ModEntities.ALEX_FACELING, 9223818, 6570284, new Item.Settings().group(ModItemGroup.TECHNO_BACKROOMS)));

    public static final Item DULLER_SPAWN_EGG = registerItem("duller_spawn_egg", new SpawnEggItem(
            ModEntities.DULLER, 1250067, 2039583, new Item.Settings().group(ModItemGroup.TECHNO_BACKROOMS)));

    public static final Item HOUND_SPAWN_EGG = registerItem("hound_spawn_egg", new SpawnEggItem(
            ModEntities.HOUND, 16769202, 2039583, new Item.Settings().group(ModItemGroup.TECHNO_BACKROOMS)));

    public static final Item SMILER_SPAWN_EGG = registerItem("smiler_spawn_egg", new SpawnEggItem(
            ModEntities.SMILER, 1250067, 16777215, new Item.Settings().group(ModItemGroup.TECHNO_BACKROOMS)));

    public static final Item FROWNER_SPAWN_EGG = registerItem("frowner_spawn_egg", new SpawnEggItem(
            ModEntities.FROWNER, 1250067, 16777215, new Item.Settings().group(ModItemGroup.TECHNO_BACKROOMS)));

    //Register Items

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, BackroomsMod.id(name), item);
    }

    public static void registerModItems() {
        BackroomsMod.LOGGER.info("Registering Mod Items for " + BackroomsMod.MOD_ID);
    }
}
