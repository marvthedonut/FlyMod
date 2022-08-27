package me.xlfrie.flymod.modules;

import me.xlfrie.flymod.event.PacketEvent;
import me.xlfrie.flymod.mixin.PlayerMovePacket;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class NoFallModule {
    @SubscribeEvent
    public void packetSend(PacketEvent.Send event) {
        if (event.packet instanceof ServerboundMovePlayerPacket) {
            ((PlayerMovePacket) event.packet).setOnGround(true);
        }
    }
}
