package net.marios271.coords_copy.action;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.Clipboard;
import net.minecraft.text.Text;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import java.util.Objects;

public class CopyBlockCoordsAction {
    public static void player(){
        MinecraftClient client = MinecraftClient.getInstance();
        assert client.player != null;

        String playerPos = String.format("%d %d %d", (int) client.player.getX(), (int) client.player.getY(), (int) client.player.getZ());

        copyToClipboard(playerPos);
        client.player.sendMessage(Text.translatable("message.coords_copy.copied_player_coords"), true);
    }

    public static void block(){
        MinecraftClient client = MinecraftClient.getInstance();
        assert client.player != null;
        HitResult hit = client.crosshairTarget;

        switch(Objects.requireNonNull(hit).getType()){
            case MISS, ENTITY:
                client.player.sendMessage(Text.translatable("message.coords_copy.no_block"), true);
                break;
            case BLOCK:
                BlockHitResult blockHit = (BlockHitResult) hit;
                BlockPos blockPos = blockHit.getBlockPos();
                String formattedBlockPos = String.format("%d %d %d", blockPos.getX(), blockPos.getY(), blockPos.getZ());
                copyToClipboard(formattedBlockPos);

                client.player.sendMessage(Text.translatable("message.coords_copy.copied_block_coords"), true);
                break;
            default:
                client.player.sendMessage(Text.translatable("message.coords_copy.error"), true);
                break;
        }
    }

    private static void copyToClipboard(String string){
        MinecraftClient client = MinecraftClient.getInstance();
        assert client.player != null;

        Clipboard clipboard = new Clipboard();
        clipboard.setClipboard(client.getWindow().getHandle(), string);
    }
}
