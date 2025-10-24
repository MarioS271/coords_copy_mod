package net.marios271.coords_copy.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.marios271.coords_copy.action.CopyBlockCoordsAction;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    public static final KeyBinding.Category COORDS_COPY_CATEGORY = KeyBinding.Category.create(Identifier.of("key.category.coords_copy"));
    public static final String KEY_COPY_BLOCK_COORDS = "key.coords_copy.copy_block_coords";
    public static final String KEY_COPY_PLAYER_COORDS = "key.coords_copy.copy_player_coords";

    public static KeyBinding copyPlayerCoordsKey;
    public static KeyBinding copyBlockCoordsKey;

    public static void registerKeyInputs(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (copyPlayerCoordsKey.wasPressed()) {
                CopyBlockCoordsAction.player();
            }
        });
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (copyBlockCoordsKey.wasPressed()) {
                CopyBlockCoordsAction.block();
            }
        });
    }

    public static void register(){
        copyPlayerCoordsKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_COPY_PLAYER_COORDS,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_F9,
                COORDS_COPY_CATEGORY
        ));
        copyBlockCoordsKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_COPY_BLOCK_COORDS,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_F10,
                COORDS_COPY_CATEGORY
        ));

        registerKeyInputs();
    }
}