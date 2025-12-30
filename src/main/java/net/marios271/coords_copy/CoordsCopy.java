package net.marios271.coords_copy;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.marios271.coords_copy.config.ConfigData;
import net.marios271.coords_copy.handler.KeyInputHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Environment(EnvType.CLIENT)
public class CoordsCopy implements ClientModInitializer {
    public static final String MOD_ID = "coords_copy";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final String CONFIG_FILE = "coords_copy.json";
    public static final ConfigData CONFIG = ConfigData.load();

    @Override
    public void onInitializeClient() {
        KeyInputHandler.register();

        LOGGER.info("Initialized CoordsCopy");
    }
}