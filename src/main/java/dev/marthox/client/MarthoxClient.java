package dev.marthox.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public final class MarthoxClient implements ClientModInitializer {
    private static KeyBinding chunkInfoKey;
    private static KeyBinding storageInfoKey;
    private static KeyBinding playerInfoKey;

    private static boolean chunkInfoEnabled = true;
    private static boolean storageInfoEnabled = true;
    private static boolean playerInfoEnabled = true;

    @Override
    public void onInitializeClient() {
        chunkInfoKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.marthox.chunk_info",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_G,
                KeyBinding.Category.MISC
        ));
        storageInfoKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.marthox.storage_info",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_H,
                KeyBinding.Category.MISC
        ));
        playerInfoKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.marthox.player_info",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_J,
                KeyBinding.Category.MISC
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (chunkInfoKey.wasPressed()) chunkInfoEnabled = !chunkInfoEnabled;
            while (storageInfoKey.wasPressed()) storageInfoEnabled = !storageInfoEnabled;
            while (playerInfoKey.wasPressed()) playerInfoEnabled = !playerInfoEnabled;
        });
    }

    public static boolean isChunkInfoEnabled() { return chunkInfoEnabled; }
    public static boolean isStorageInfoEnabled() { return storageInfoEnabled; }
    public static boolean isPlayerInfoEnabled() { return playerInfoEnabled; }
}
