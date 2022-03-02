package net.techno573.backrooms;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.world.WorldTickCallback;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.techno573.backrooms.blocks.ModBlocks;
import net.techno573.backrooms.items.ModItems;
import net.techno573.backrooms.sounds.ModSounds;
import net.techno573.backrooms.world.ModWorld;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main implements ModInitializer {

	public static final String MOD_ID = "techno_backrooms";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModSounds.registerSounds();
		ModWorld.init();

	}

	public static Identifier id(String id) {
		return new Identifier(Main.MOD_ID, id);
	}
}
