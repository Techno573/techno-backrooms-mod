package net.techno573.backrooms.items.advanced;

import net.minecraft.item.HoneyBottleItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.UseAction;

public class AlmondWaterItem extends HoneyBottleItem {
    public AlmondWaterItem(Settings settings) {
        super(settings);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }
}
