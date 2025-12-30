package net.marios271.coords_copy.handler;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.marios271.coords_copy.action.CopyBlockCoordsAction;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.Identifier;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    public static final KeyMapping.Category COORDS_COPY_CATEGORY = KeyMapping.Category.register(Identifier.parse("coords_copy"));
    public static final String KEY_COPY_BLOCK_COORDS = "key.coords_copy.copy_block_coords";
    public static final String KEY_COPY_PLAYER_COORDS = "key.coords_copy.copy_player_coords";

    public static KeyMapping copyPlayerCoordsKey;
    public static KeyMapping copyBlockCoordsKey;

    public static void registerKeyInputs(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (copyPlayerCoordsKey.consumeClick()) {
                CopyBlockCoordsAction.player();
            }
        });
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (copyBlockCoordsKey.consumeClick()) {
                CopyBlockCoordsAction.block();
            }
        });
    }

    public static void register(){
        copyPlayerCoordsKey = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                KEY_COPY_PLAYER_COORDS,
                InputConstants.Type.KEYSYM,
                GLFW.GLFW_KEY_F9,
                COORDS_COPY_CATEGORY
        ));
        copyBlockCoordsKey = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                KEY_COPY_BLOCK_COORDS,
                InputConstants.Type.KEYSYM,
                GLFW.GLFW_KEY_F10,
                COORDS_COPY_CATEGORY
        ));

        registerKeyInputs();
    }
}