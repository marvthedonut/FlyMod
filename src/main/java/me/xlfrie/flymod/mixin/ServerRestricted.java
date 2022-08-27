package me.xlfrie.flymod.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.ConnectScreen;
import net.minecraft.client.gui.screens.DisconnectedScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.gui.screens.multiplayer.JoinMultiplayerScreen;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.multiplayer.resolver.ServerAddress;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ConnectScreen.class)
public class ServerRestricted {
    @Inject(at = @At("HEAD"), method = "startConnecting", cancellable = true)
    private static void connect(Screen pScreen, Minecraft pMinecraft, ServerAddress pServerAddress, ServerData pServerData, CallbackInfo ci) {
        if (!pServerAddress.getHost().toLowerCase().contains("spacetiger99.aternos.me")) {
            ci.cancel();
            Minecraft.getInstance().setScreen(new DisconnectedScreen(new JoinMultiplayerScreen(new TitleScreen()), CommonComponents.CONNECT_FAILED, Component.literal("XLFrie just saved your ass.")));
        }
    }
}
