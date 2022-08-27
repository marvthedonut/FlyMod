package me.xlfrie.flymod.mixin;

import me.xlfrie.flymod.event.PacketEvent;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Connection.class)
public class PacketMixin {
    @Inject(method = "send(Lnet/minecraft/network/protocol/Packet;)V", at = @At("HEAD"), cancellable = true)
    public void onSendHead(Packet<?> pPacket, CallbackInfo ci) {
        PacketEvent.Send packetEvent = new PacketEvent.Send(pPacket);
        if (MinecraftForge.EVENT_BUS.post(packetEvent)) ci.cancel();
    }
}
