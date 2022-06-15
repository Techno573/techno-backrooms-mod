package net.techno573.backrooms.sounds;


import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.techno573.backrooms.BackroomsMod;
import net.minecraft.util.registry.Registry;

public class ModSounds {

    //Travel Sound
    public static SoundEvent TRAVEL_GLITCH = registerSoundEvent("misc.travel_glitch");

    //Ambiences
    public static SoundEvent LEVEL_0_AMBIENT = registerSoundEvent("ambient.level_0");
    public static SoundEvent LEVEL_1_AMBIENT = registerSoundEvent("ambient.level_1");
    public static SoundEvent LEVEL_2_AMBIENT = registerSoundEvent("ambient.level_2");
    public static SoundEvent LEVEL_3_AMBIENT = registerSoundEvent("ambient.level_3");
    public static SoundEvent LEVEL_6_AMBIENT = registerSoundEvent("ambient.level_6");
    public static SoundEvent LEVEL_FUN_AMBIENT = registerSoundEvent("ambient.level_fun");


    //Mob Sounds - Duller
    public static SoundEvent DULLER_AMBIENT = registerSoundEvent("entity.duller.ambient");
    public static SoundEvent DULLER_SCREAM = registerSoundEvent("entity.duller.scream");

    //MobSounds - Hound
    public static SoundEvent HOUND_GROWL = registerSoundEvent("entity.hound.growl");
    public static SoundEvent HOUND_BARK = registerSoundEvent("entity.hound.bark");

    //MobSounds - Partygoer
    public static SoundEvent PARTYGOER_GIGGLES = registerSoundEvent("entity.partygoer.giggles");


    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = BackroomsMod.id(name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }

    public static void registerSounds() {
        System.out.println("Registering Mod Sounds for" + BackroomsMod.MOD_ID);
    }
}
