package net.techno573.backrooms.items;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.techno573.backrooms.Main;
import net.techno573.backrooms.blocks.ModBlocks;

public class ModItemGroup {

    public static final ItemGroup TECHNO_BACKROOMS = FabricItemGroupBuilder.build(new Identifier(Main.MOD_ID,"techno_backrooms"), () -> new ItemStack(ModBlocks.LVL0_WALL_BLOCK));
}
