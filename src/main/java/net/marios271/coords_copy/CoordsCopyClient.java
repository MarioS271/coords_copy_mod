package net.marios271.coords_copy;

import net.fabricmc.api.ClientModInitializer;
import net.marios271.coords_copy.event.KeyInputHandler;

public class CoordsCopyClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        KeyInputHandler.register();
    }
}
