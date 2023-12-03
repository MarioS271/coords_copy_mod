package net.marios271.coords_copy.action;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class CopyBlockCoordsAction {
    public static void solid(){
        MinecraftClient client = MinecraftClient.getInstance();
        assert client.player != null;


        /////


        client.player.sendMessage(Text.translatable("message.coords_copy.copied_block_coords"), true);
    }

    public static void fluid(){
        MinecraftClient client = MinecraftClient.getInstance();
        assert client.player != null;


        /////


        client.player.sendMessage(Text.translatable("message.coords.copy.copied_block_coords"), true);
    }
}
