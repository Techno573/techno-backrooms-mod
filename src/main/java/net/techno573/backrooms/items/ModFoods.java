package net.techno573.backrooms.items;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;

public class ModFoods extends FoodComponents {
    public static final FoodComponent ALMOND_WATER = new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).snack().build();
}
