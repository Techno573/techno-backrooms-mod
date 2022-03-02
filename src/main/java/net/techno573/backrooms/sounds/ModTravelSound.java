package net.techno573.backrooms.sounds;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.ludocrypt.limlib.api.sound.LiminalTravelSound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import org.apache.commons.lang3.mutable.Mutable;

import java.util.Optional;

public class ModTravelSound extends LiminalTravelSound {

    public static boolean isTraveling = false;

    public static final Codec<ModTravelSound> CODEC = RecordCodecBuilder.create((instance) -> instance.stable(new ModTravelSound()));

    @Override
    public void hookSound(ServerWorld from, ServerWorld to, Mutable<Optional<SoundEvent>> mutable) {
        if(isTraveling) {
            mutable.setValue(Optional.of(ModSounds.TRAVEL_GLITCH));
        }
        isTraveling = false;
    }

    @Override
    public Codec<? extends LiminalTravelSound> getCodec() {
        return CODEC;
    }

    @Override
    public int priority() {
        return 600;
    }
}
