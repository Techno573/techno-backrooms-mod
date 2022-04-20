package net.techno573.backrooms.sounds;

import net.ludocrypt.limlib.api.sound.LiminalTravelSound;
import net.ludocrypt.limlib.impl.world.LiminalSoundRegistry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.techno573.backrooms.BackroomsMod;
import net.minecraft.util.registry.Registry;

public class ModSounds {

    public static SoundEvent TRAVEL_GLITCH = registerSoundEvent("misc.travel_glitch");
    public static SoundEvent LEVEL_0_AMBIENT = registerSoundEvent("ambient.level_0");
    public static SoundEvent LEVEL_1_AMBIENT = registerSoundEvent("ambient.level_1");
    public static SoundEvent LEVEL_2_AMBIENT = registerSoundEvent("ambient.level_2");
    public static SoundEvent LEVEL_3_AMBIENT = registerSoundEvent("ambient.level_3");
    public static SoundEvent DULLER_AMBIENT = registerSoundEvent("entity.duller.ambient");
    public static SoundEvent DULLER_SCREAM = registerSoundEvent("entity.duller.scream");
    public static SoundEvent HOUND_GROWL = registerSoundEvent("entity.hound.growl");
    public static SoundEvent HOUND_BARK = registerSoundEvent("entity.hound.bark");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = BackroomsMod.id(name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }

    public static void registerSounds() {
        System.out.println("Registering Mod Sounds for" + BackroomsMod.MOD_ID);
    }

    public static LiminalTravelSound travelSoundRegister = LiminalSoundRegistry.registerOverride(BackroomsMod.id("travel_glitch"), new ModTravelSound());
}
