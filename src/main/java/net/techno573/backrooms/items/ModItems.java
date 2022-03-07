package net.techno573.backrooms.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;
import net.techno573.backrooms.BackroomsMod;
import net.techno573.backrooms.items.advanced.AlmondWaterItem;
import net.techno573.backrooms.items.advanced.MedicalKitItem;

public class ModItems {

    //Items List

    public static final Item ALMOND_WATER = registerItem("almond_water", new AlmondWaterItem(
            new FabricItemSettings().maxCount(16).food(ModFoods.ALMOND_WATER).group(ModItemGroup.TECHNO_BACKROOMS)));

    public static final Item MEDICAL_KIT = registerItem("medical_kit", new MedicalKitItem(
            new FabricItemSettings().maxCount(1).group(ModItemGroup.TECHNO_BACKROOMS)));

    //Register Items

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, BackroomsMod.id(name), item);
    }

    public static void registerModItems() {
        BackroomsMod.LOGGER.info("Registering Mod Items for " + BackroomsMod.MOD_ID);
    }
}
