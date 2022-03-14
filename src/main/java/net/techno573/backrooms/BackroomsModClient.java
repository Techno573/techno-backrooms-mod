package net.techno573.backrooms;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.techno573.backrooms.entity.ModEntities;

@Environment(EnvType.CLIENT)
public class BackroomsModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModEntities.registerEntityRenderers();
    }
}
