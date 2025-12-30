package net.marios271.coords_copy.action;

import net.marios271.coords_copy.CoordsCopy;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

import java.util.Objects;

public class CopyBlockCoordsAction {
    public static void player(){
        Minecraft client = Minecraft.getInstance();
        if (client.player == null) return;

        String playerPos = String.format("%d %d %d", (int) client.player.getX(), (int) client.player.getY(), (int) client.player.getZ());

        copyToClipboard(playerPos);
        sendCopyMessage(CopyMessage.COPY_MSG_COPIED_PLAYER, playerPos);
    }

    public static void block(){
        Minecraft client = Minecraft.getInstance();
        if (client.player == null || client.hitResult == null) return;
        HitResult hit = client.hitResult;

        switch(Objects.requireNonNull(hit).getType()){
            case MISS, ENTITY:
                sendCopyMessage(CopyMessage.COPY_MSG_NO_BLOCK, "");
                break;
            case BLOCK:
                BlockHitResult blockHit = (BlockHitResult) hit;
                BlockPos blockHitPos = blockHit.getBlockPos();

                String blockPos = String.format("%d %d %d", blockHitPos.getX(), blockHitPos.getY(), blockHitPos.getZ());

                copyToClipboard(blockPos);
                sendCopyMessage(CopyMessage.COPY_MSG_COPIED_BLOCK, blockPos);
                break;
            default:
                sendCopyMessage(CopyMessage.COPY_MSG_ERROR, "");
                break;
        }
    }

    private static void copyToClipboard(String string){
        Minecraft client = Minecraft.getInstance();
        client.keyboardHandler.setClipboard(string);
    }

    private enum CopyMessage {
        COPY_MSG_NO_BLOCK,
        COPY_MSG_COPIED_PLAYER,
        COPY_MSG_COPIED_BLOCK,
        COPY_MSG_ERROR
    }

    private static void sendCopyMessage(CopyMessage copyMessage, String coords) {
        boolean chat_output = CoordsCopy.CONFIG.chat_instead_of_actionbar;

        Minecraft client = Minecraft.getInstance();
        if (client.player == null) return;

        Component msg = switch (copyMessage) {
            case COPY_MSG_COPIED_PLAYER -> Component.translatable("message.coords_copy.copied_player_coords", coords);
            case COPY_MSG_COPIED_BLOCK -> Component.translatable("message.coords_copy.copied_block_coords", coords);
            case COPY_MSG_NO_BLOCK -> Component.translatable("message.coords_copy.no_block");
            case COPY_MSG_ERROR -> Component.translatable("message.coords_copy.error");
        };

        client.player.displayClientMessage(msg, !chat_output);
    }
}
