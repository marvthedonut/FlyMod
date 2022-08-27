package me.xlfrie.flymod.event;

import net.minecraft.network.protocol.Packet;
import net.minecraftforge.eventbus.api.Cancelable;

public class PacketEvent extends Cancellable {
    public Packet<?> packet;

    public PacketEvent(Packet<?> packet) {
        this.packet = packet;
    }

    @Cancelable
    public static class Send extends PacketEvent {
        public Send(Packet<?> packet) {
            super(packet);
        }
    }
}
