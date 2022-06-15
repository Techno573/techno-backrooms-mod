package net.techno573.backrooms.world.biomes;

import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.techno573.backrooms.entity.ModEntities;
import net.techno573.backrooms.sounds.ModSounds;

public class Level2Biome {

    public static Biome create() {
        Biome.Builder biome = new Biome.Builder();

        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();

        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();

        BiomeEffects.Builder biomeEffects = new BiomeEffects.Builder();
        biomeEffects.skyColor(16777215);
        biomeEffects.waterColor(16777215);
        biomeEffects.waterFogColor(16777215);
        biomeEffects.fogColor(16777215);
        biomeEffects.loopSound(ModSounds.LEVEL_2_AMBIENT);
        BiomeEffects effects = biomeEffects.build();

        biome.spawnSettings(spawnSettings
                .spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(ModEntities.DULLER,1,0,1))
                .spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(ModEntities.SMILER,1,0,1))
                .creatureSpawnProbability(0.05f)
                .build());
        biome.generationSettings(generationSettings.build());
        biome.effects(effects);

        biome.precipitation(Biome.Precipitation.NONE);
        biome.category(Biome.Category.NONE);

        biome.temperature(0.8F);
        biome.downfall(0.0F);

        return biome.build();
    }
}
