package net.techno573.backrooms.blocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.techno573.backrooms.BackroomsMod;
import net.techno573.backrooms.blocks.advanced.*;
import net.techno573.backrooms.items.ModItemGroup;




public class ModBlocks {

    //Blocks List - Level 0
    public static final Block LVL0_WALL_BLOCK = registerBlock("lvl0_wall_block", new Block(FabricBlockSettings.of(Material.WOOD)
            .strength(3.0f).hardness(2.0f).sounds(BlockSoundGroup.WOOD)), ModItemGroup.TECHNO_BACKROOMS);

    public static final Block LVL0_PORTAL_BLOCK = registerBlock("lvl0_portal_block", new Lvl0PortalBlock(FabricBlockSettings.of(Material.PORTAL)
            .strength(3600000f).hardness(-1f).dropsNothing().noCollision().luminance(15).sounds(BlockSoundGroup.WOOD)), ModItemGroup.TECHNO_BACKROOMS);

    public static final Block LVL0_FLOOR_BLOCK = registerBlock("lvl0_floor_block", new Block(FabricBlockSettings.of(Material.WOOD)
            .strength(3.0f).hardness(2.0f).sounds(BlockSoundGroup.WOOD)), ModItemGroup.TECHNO_BACKROOMS);

    public static final Block LVL0_CEILING_BLOCK = registerBlock("lvl0_ceiling_block", new Block(FabricBlockSettings.of(Material.WOOD)
            .strength(3.0f).hardness(2.0f).requiresTool().sounds(BlockSoundGroup.WOOD)), ModItemGroup.TECHNO_BACKROOMS);

    //Blocks List - Level 1
    public static final Block LVL1_WALL_BLOCK = registerBlock("lvl1_wall_block", new Block(FabricBlockSettings.of(Material.STONE)
            .strength(6.0f).hardness(2.0f).requiresTool().sounds(BlockSoundGroup.STONE)), ModItemGroup.TECHNO_BACKROOMS);

    public static final Block LVL1_PORTAL_BLOCK = registerBlock("lvl1_portal_block", new Lvl1PortalBlock(FabricBlockSettings.of(Material.PORTAL)
            .strength(3600000f).hardness(-1f).dropsNothing().noCollision().luminance(15).sounds(BlockSoundGroup.STONE)), ModItemGroup.TECHNO_BACKROOMS);

    public static final Block LVL1_FLOOR_BLOCK = registerBlock("lvl1_floor_block", new Block(FabricBlockSettings.of(Material.STONE)
            .strength(6.0f).hardness(2.0f).requiresTool().sounds(BlockSoundGroup.STONE)), ModItemGroup.TECHNO_BACKROOMS);

    public static final Block LVL1_CEILING_BLOCK = registerBlock("lvl1_ceiling_block", new Block(FabricBlockSettings.of(Material.STONE)
            .strength(6.0f).hardness(2.0f).requiresTool().sounds(BlockSoundGroup.STONE)), ModItemGroup.TECHNO_BACKROOMS);

    //Blocks List - Level 2
    public static final Block LVL2_WALL_BLOCK = registerBlock("lvl2_wall_block", new Block(FabricBlockSettings.of(Material.STONE)
            .strength(6.0f).hardness(2.0f).requiresTool().sounds(BlockSoundGroup.STONE)), ModItemGroup.TECHNO_BACKROOMS);

    public static final Block LVL2_PORTAL_BLOCK = registerBlock("lvl2_portal_block", new Lvl2PortalBlock(FabricBlockSettings.of(Material.PORTAL)
            .strength(3600000f).hardness(-1f).dropsNothing().noCollision().luminance(15).sounds(BlockSoundGroup.STONE)), ModItemGroup.TECHNO_BACKROOMS);

    public static final Block LVL2_FLOOR_BLOCK = registerBlock("lvl2_floor_block", new Block(FabricBlockSettings.of(Material.STONE)
            .strength(6.0f).hardness(2.0f).requiresTool().sounds(BlockSoundGroup.STONE)), ModItemGroup.TECHNO_BACKROOMS);

    public static final Block LVL2_CEILING_BLOCK = registerBlock("lvl2_ceiling_block", new Block(FabricBlockSettings.of(Material.STONE)
            .strength(6.0f).hardness(2.0f).requiresTool().sounds(BlockSoundGroup.STONE)), ModItemGroup.TECHNO_BACKROOMS);

    //Blocks List - Level 3
    public static final Block LVL3_WALL_BLOCK = registerBlock("lvl3_wall_block", new Block(FabricBlockSettings.of(Material.STONE)
            .strength(6.0f).hardness(2.0f).requiresTool().sounds(BlockSoundGroup.STONE)), ModItemGroup.TECHNO_BACKROOMS);

    public static final Block LVL3_PORTAL_BLOCK = registerBlock("lvl3_portal_block", new Lvl3PortalBlock(FabricBlockSettings.of(Material.PORTAL)
            .strength(3600000f).hardness(-1f).dropsNothing().noCollision().luminance(15).sounds(BlockSoundGroup.STONE)), ModItemGroup.TECHNO_BACKROOMS);

    public static final Block LVL3_FLOOR_BLOCK = registerBlock("lvl3_floor_block", new Block(FabricBlockSettings.of(Material.STONE)
            .strength(6.0f).hardness(2.0f).requiresTool().sounds(BlockSoundGroup.STONE)), ModItemGroup.TECHNO_BACKROOMS);

    public static final Block LVL3_CEILING_BLOCK = registerBlock("lvl3_ceiling_block", new Block(FabricBlockSettings.of(Material.STONE)
            .strength(6.0f).hardness(2.0f).requiresTool().sounds(BlockSoundGroup.STONE)), ModItemGroup.TECHNO_BACKROOMS);

    //Blocks List - Level 4
    public static final Block LVL4_WALL_BLOCK = registerBlock("lvl4_wall_block", new Block(FabricBlockSettings.of(Material.WOOD)
            .strength(3.0f).hardness(2.0f).sounds(BlockSoundGroup.WOOD)), ModItemGroup.TECHNO_BACKROOMS);

    public static final Block LVL4_PORTAL_BLOCK = registerBlock("lvl4_portal_block", new Lvl4PortalBlock(FabricBlockSettings.of(Material.PORTAL)
            .strength(3600000f).hardness(-1f).dropsNothing().noCollision().luminance(15).sounds(BlockSoundGroup.WOOD)), ModItemGroup.TECHNO_BACKROOMS);

    public static final Block LVL4_FLOOR_BLOCK = registerBlock("lvl4_floor_block", new Block(FabricBlockSettings.of(Material.WOOD)
            .strength(3.0f).hardness(2.0f).sounds(BlockSoundGroup.WOOD)), ModItemGroup.TECHNO_BACKROOMS);

    public static final Block LVL4_CEILING_BLOCK = registerBlock("lvl4_ceiling_block", new Block(FabricBlockSettings.of(Material.WOOD)
            .strength(3.0f).hardness(2.0f).requiresTool().sounds(BlockSoundGroup.WOOD)), ModItemGroup.TECHNO_BACKROOMS);

    //Blocks List - Level 5
    public static final Block LVL5_WALL_BLOCK = registerBlock("lvl5_wall_block", new Block(FabricBlockSettings.of(Material.WOOD)
            .strength(3.0f).hardness(2.0f).sounds(BlockSoundGroup.WOOD)), ModItemGroup.TECHNO_BACKROOMS);

    public static final Block LVL5_WALL_BASE_BLOCK = registerBlock("lvl5_wall_base_block", new Block(FabricBlockSettings.of(Material.STONE)
            .strength(3.0f).hardness(2.0f).sounds(BlockSoundGroup.STONE)), ModItemGroup.TECHNO_BACKROOMS);

    public static final Block LVL5_PORTAL_BLOCK = registerBlock("lvl5_portal_block", new Lvl5PortalBlock(FabricBlockSettings.of(Material.PORTAL)
            .strength(3600000f).hardness(-1f).dropsNothing().noCollision().luminance(15).sounds(BlockSoundGroup.WOOD)), ModItemGroup.TECHNO_BACKROOMS);

    public static final Block LVL5_PORTAL_BASE_BLOCK = registerBlock("lvl5_portal_base_block", new Lvl5PortalBlock(FabricBlockSettings.of(Material.PORTAL)
            .strength(3600000f).hardness(-1f).dropsNothing().noCollision().luminance(15).sounds(BlockSoundGroup.STONE)), ModItemGroup.TECHNO_BACKROOMS);

    public static final Block LVL5_FLOOR_BLOCK = registerBlock("lvl5_floor_block", new Block(FabricBlockSettings.of(Material.WOOD)
            .strength(3.0f).hardness(2.0f).sounds(BlockSoundGroup.WOOD)), ModItemGroup.TECHNO_BACKROOMS);

    public static final Block LVL5_CEILING_BLOCK = registerBlock("lvl5_ceiling_block", new Block(FabricBlockSettings.of(Material.STONE)
            .strength(3.0f).hardness(2.0f).requiresTool().sounds(BlockSoundGroup.STONE)), ModItemGroup.TECHNO_BACKROOMS);

    //Blocks List - Generic

    public static final Block FLUORESCENT_LAMP = registerBlock("fluorescent_lamp", new FluorescentLampBlock(FabricBlockSettings.of(Material.REDSTONE_LAMP)
            .strength(1.5f).hardness(0.5f).requiresTool().lightLevel((state) -> state.get(FluorescentLampBlock.LIT) ? 15 : 0).sounds(BlockSoundGroup.GLASS)), ModItemGroup.TECHNO_BACKROOMS);

    public static final Block WIRED_FLUORESCENT_LAMP = registerBlock("wired_fluorescent_lamp", new WiredFluorescentLampBlock(FabricBlockSettings.of(Material.REDSTONE_LAMP)
            .strength(1.5f).hardness(0.5f).requiresTool().lightLevel((state) -> state.get(WiredFluorescentLampBlock.LIT) ? 15 : 0).sounds(BlockSoundGroup.GLASS)), ModItemGroup.TECHNO_BACKROOMS);

    public static final Block ELECTRICAL_WIRING = registerBlock("electrical_wiring", new ElectricalWiringBlock(FabricBlockSettings.of(Material.METAL)
            .strength(1.5f).hardness(0.5f).sounds(BlockSoundGroup.METAL)), ModItemGroup.TECHNO_BACKROOMS);

    public static final Block LARGE_PIPES = registerBlock("large_pipes", new PipeBlock(Blocks.COPPER_BLOCK.getDefaultState(),FabricBlockSettings.of(Material.METAL)
            .strength(6.0f).hardness(2.0f).requiresTool().sounds(BlockSoundGroup.METAL)), ModItemGroup.TECHNO_BACKROOMS);

    public static final Block SMALL_PIPES = registerBlock("small_pipes", new PipeBlock(Blocks.COPPER_BLOCK.getDefaultState(), FabricBlockSettings.of(Material.METAL)
            .strength(6.0f).hardness(2.0f).requiresTool().sounds(BlockSoundGroup.METAL)), ModItemGroup.TECHNO_BACKROOMS);

    public static final Block OFFICE_DRAWER = registerBlock("office_drawer", new OfficeDrawerBlock(FabricBlockSettings.of(Material.WOOD)
            .strength(3.0f).hardness(2.0f).nonOpaque().sounds(BlockSoundGroup.WOOD)), ModItemGroup.TECHNO_BACKROOMS);

    public static final Block SMALL_TABLE = registerBlock("small_table", new Block(FabricBlockSettings.of(Material.WOOD)
            .strength(3.0f).nonOpaque().hardness(2.0f).sounds(BlockSoundGroup.WOOD)), ModItemGroup.TECHNO_BACKROOMS);

    public static final Block CHANDELIER = registerBlock("chandelier", new Block(FabricBlockSettings.of(Material.METAL)
            .strength(1.5f).hardness(0.5f).nonOpaque().dropsNothing().luminance(15).sounds(BlockSoundGroup.CHAIN)), ModItemGroup.TECHNO_BACKROOMS);

    public static final Block FLASHLIGHT_LIGHT = registerBlock("flashlight_light", new FlashlightLightBlock(FabricBlockSettings.of(Material.STONE)
            .strength(1.5f).hardness(0.5f).luminance(11).ticksRandomly().sounds(BlockSoundGroup.STONE)),null);

    //Register Blocks
    private static Block registerBlock(String name, Block block, ItemGroup group) {
      registerBlockItem(name, block, group);
      return Registry.register(Registry.BLOCK, new Identifier(BackroomsMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, BackroomsMod.id(name), new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlocks() {
        BackroomsMod.LOGGER.info("Registering Mod Blocks for " + BackroomsMod.MOD_ID);
    }
}
