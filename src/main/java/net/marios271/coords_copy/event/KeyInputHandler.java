package net.marios271.coords_copy.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.marios271.coords_copy.action.CopyBlockCoordsAction;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    public static final String KEY_CATEGORY_COORDS_COPY = "key.category.coords_copy";
    public static final String KEY_COPY_BLOCK_COORDS_SOLID = "key.coords_copy.copy_block_solid_coords";
    public static final String KEY_COPY_BLOCK_COORDS_FLUID = "key.coords_copy.copy_block_fluid_coords";

    public static KeyBinding copyBlockCoordsSolidKey;
    public static KeyBinding copyBlockCoordsFluidKey;

    public static void registerKeyInputs(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (copyBlockCoordsSolidKey.wasPressed()) {
                CopyBlockCoordsAction.solid();
            }
        });

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (copyBlockCoordsFluidKey.wasPressed()) {
                CopyBlockCoordsAction.fluid();
            }
        });
    }

    public static void register(){
        copyBlockCoordsSolidKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_COPY_BLOCK_COORDS_SOLID,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_F12,
                KEY_CATEGORY_COORDS_COPY
        ));
        copyBlockCoordsFluidKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_COPY_BLOCK_COORDS_FLUID,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_NONE,
                KEY_CATEGORY_COORDS_COPY
        ));

        registerKeyInputs();
    }
}