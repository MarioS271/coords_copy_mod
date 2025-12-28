package net.marios271.coords_copy.config;

import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Modmenu;
import net.marios271.coords_copy.CoordsCopy;

@Modmenu(modId = CoordsCopy.MOD_ID)
@Config(name = "coords_copy_config", wrapperName = "CoordsCopyModConfig")
public class ConfigScreen {
    public boolean chat_instead_of_actionbar = false;
}