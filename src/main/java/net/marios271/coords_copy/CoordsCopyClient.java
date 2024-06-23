package net.marios271.coords_copy;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.marios271.coords_copy.event.KeyInputHandler;

@Environment(EnvType.CLIENT)
public class CoordsCopyClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        KeyInputHandler.register();
    }
}
