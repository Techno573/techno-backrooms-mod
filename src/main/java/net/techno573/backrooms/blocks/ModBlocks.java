package net.techno573.backrooms.blocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.techno573.backrooms.Main;
import net.techno573.backrooms.blocks.advanced.FluorescentLampBlock;
import net.techno573.backrooms.blocks.advanced.Lvl0PortalBlock;
import net.techno573.backrooms.items.ModItemGroup;




public class ModBlocks {

    //Blocks List
    public static final Block LVL0_WALL_BLOCK = registerBlock("lvl0_wall_block", new Block(FabricBlockSettings.of(Material.WOOD)
            .strength(3.0f).hardness(2.0f).sounds(BlockSoundGroup.WOOD)), ModItemGroup.TECHNO_BACKROOMS);

    public static final Block LVL0_PORTAL_BLOCK = registerBlock("lvl0_portal_block", new Lvl0PortalBlock(FabricBlockSettings.of(Material.PORTAL)
            .strength(3600000f).hardness(-1f).dropsNothing().noCollision().luminance(15).sounds(BlockSoundGroup.WOOD)), ModItemGroup.TECHNO_BACKROOMS);

    public static final Block LVL0_FLOOR_BLOCK = registerBlock("lvl0_floor_block", new Block(FabricBlockSettings.of(Material.WOOD)
            .strength(3.0f).hardness(2.0f).sounds(BlockSoundGroup.WOOD)), ModItemGroup.TECHNO_BACKROOMS);

    public static final Block LVL0_CEILING_BLOCK = registerBlock("lvl0_ceiling_block", new Block(FabricBlockSettings.of(Material.WOOD)
            .strength(3.0f).hardness(2.0f).requiresTool().sounds(BlockSoundGroup.WOOD)), ModItemGroup.TECHNO_BACKROOMS);

    public static final Block FLUORESCENT_LAMP = registerBlock("fluorescent_lamp", new FluorescentLampBlock(FabricBlockSettings.of(Material.REDSTONE_LAMP)
            .strength(0.5f).hardness(0.5f).requiresTool().lightLevel((state) -> state.get(FluorescentLampBlock.LIT) ? 15 : 0).sounds(BlockSoundGroup.GLASS)), ModItemGroup.TECHNO_BACKROOMS);

    public static final Block LVL1_WALL_BLOCK = registerBlock("lvl1_wall_block", new Block(FabricBlockSettings.of(Material.STONE)
            .strength(6.0f).hardness(2.0f).requiresTool().sounds(BlockSoundGroup.STONE)), ModItemGroup.TECHNO_BACKROOMS);

    public static final Block LVL1_FLOOR_BLOCK = registerBlock("lvl1_floor_block", new Block(FabricBlockSettings.of(Material.STONE)
            .strength(6.0f).hardness(2.0f).requiresTool().sounds(BlockSoundGroup.STONE)), ModItemGroup.TECHNO_BACKROOMS);

    public static final Block LVL1_CEILING_BLOCK = registerBlock("lvl1_ceiling_block", new Block(FabricBlockSettings.of(Material.STONE)
            .strength(6.0f).hardness(2.0f).requiresTool().sounds(BlockSoundGroup.STONE)), ModItemGroup.TECHNO_BACKROOMS);

    //Register Blocks
    private static Block registerBlock(String name, Block block, ItemGroup group) {
      registerBlockItem(name, block, group);
      return Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, name), new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlocks() {
        Main.LOGGER.info("Registering Mod Blocks for " + Main.MOD_ID);
    }
}
