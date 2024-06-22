package net.marios271.coords_copy;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CoordsCopy implements ModInitializer {
	public static final String MOD_ID = "coords_copy";
    public static final Logger LOGGER = LoggerFactory.getLogger("coords_copy");

	@Override
	public void onInitialize() {
		LOGGER.info("initialized " + MOD_ID);
	}
}