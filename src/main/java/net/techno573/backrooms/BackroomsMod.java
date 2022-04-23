package net.techno573.backrooms;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import net.techno573.backrooms.blocks.ModBlocks;
import net.techno573.backrooms.blocks.entity.ModBlockEntities;
import net.techno573.backrooms.entity.ModEntities;
import net.techno573.backrooms.items.ModItems;
import net.techno573.backrooms.sounds.ModSounds;
import net.techno573.backrooms.world.ModWorld;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib3.GeckoLib;

public class BackroomsMod implements ModInitializer {

	public static final String MOD_ID = "techno_backrooms";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Identifier id(String id) {
		return new Identifier(BackroomsMod.MOD_ID, id);
	}

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModBlockEntities.registerModBlockEntities();
		ModSounds.registerSounds();
		ModWorld.init();
		ModEntities.registerEntityAttributes();
		GeckoLib.initialize();
	}
}
