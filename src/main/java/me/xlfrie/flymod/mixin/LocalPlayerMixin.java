package me.xlfrie.flymod.mixin;

import me.xlfrie.flymod.modules.ToggleSprint;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.player.LocalPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LocalPlayer.class)
public abstract class LocalPlayerMixin {
    @Redirect(method = "aiStep", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/KeyMapping;isDown()Z"))
    private boolean setSprinting(KeyMapping instance) {
        return ToggleSprint.sprinting.get() || instance.isDown();
    }
}
