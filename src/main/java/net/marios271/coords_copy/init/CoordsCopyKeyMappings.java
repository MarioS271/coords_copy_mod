package net.marios271.coords_copy.init;

import org.lwjgl.glfw.GLFW;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.KeyMapping;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import com.mojang.blaze3d.platform.InputConstants;
import net.marios271.troll_difficulty.network.TestMessage;
import net.marios271.troll_difficulty.TrollDifficultyMod;

public class CoordsCopyKeyMappings {
    public static class CoordsCopyKeyMapping extends KeyMapping {
        private boolean isDownOld;

        public TrollDifficultyModKeyMapping(String string, int i, String string2) {
            super(string, InputConstants.Type.KEYSYM, i, string2);
        }

        public int action() {
            if (isDownOld != isDown() && isDown()) {
                isDownOld = isDown();
                return 1;
            } else if (isDownOld != isDown() && !isDown()) {
                isDownOld = isDown();
                return 2;
            }
            isDownOld = isDown();
            return 0;
        }
    }

    public static TrollDifficultyModKeyMapping TEST = (TrollDifficultyModKeyMapping) KeyBindingHelper.registerKeyBinding(new TrollDifficultyModKeyMapping("key.troll_difficulty.test", GLFW.GLFW_KEY_F12, "key.categories.test"));

    public static void load() {
        ClientTickEvents.END_CLIENT_TICK.register((client) -> {
            int TESTaction = TEST.action();
            if (TESTaction == 1) {
                ClientPlayNetworking.send(new ResourceLocation(TrollDifficultyMod.MODID, "test"), new TestMessage(true, false));
            } else if (TESTaction == 2) {
                ClientPlayNetworking.send(new ResourceLocation(TrollDifficultyMod.MODID, "test"), new TestMessage(false, true));
            }
        });
    }
}
