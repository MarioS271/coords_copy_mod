package net.marios271.coords_copy.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.marios271.coords_copy.CoordsCopy;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConfigData {
    private static final File FILE = new File(FabricLoader.getInstance().getConfigDir().toFile(), CoordsCopy.CONFIG_FILE);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public boolean chat_instead_of_actionbar = false;

    public void save() {
        try (FileWriter writer = new FileWriter(FILE)) {
            GSON.toJson(this, writer);
            CoordsCopy.LOGGER.info("Saved CoordsCopy config");
        } catch (IOException exception) {
            CoordsCopy.LOGGER.error("Failed to save config", exception);
        }
    }

    public static ConfigData load() {
        if (FILE.exists()) {
            try (FileReader reader = new FileReader(FILE)) {
                CoordsCopy.LOGGER.info("Loaded CoordsCopy config");
                return GSON.fromJson(reader, ConfigData.class);
            } catch (IOException exception) {
                CoordsCopy.LOGGER.warn("Failed to load config, returning default values");
            }
        }
        return new ConfigData();
    }
}
