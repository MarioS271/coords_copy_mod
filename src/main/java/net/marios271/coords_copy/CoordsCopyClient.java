package net.marios271.coords_copy;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class CoordsCopyClient implements ClientModInitializer {
    private static KeyBinding keyBinding;
    keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
        "key.examplemod.spook",
        InputUtil.Type.KEYSYM,
        GLFW.GLFW_KEY_R,
        "category.examplemod.test"
    ));

    @Override
    public void onInitializeClient() {

    }
}
