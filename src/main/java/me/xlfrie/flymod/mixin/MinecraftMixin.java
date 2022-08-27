package me.xlfrie.flymod.mixin;

import me.xlfrie.flymod.modules.Fullbright;
import me.xlfrie.flymod.modules.XRay;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Minecraft.class)
public class MinecraftMixin {
    @Inject(at = @At("HEAD"), method = "useAmbientOcclusion", cancellable = true)
    private static void useAO(CallbackInfoReturnable<Boolean> cir) {
        if (XRay.xraying || Fullbright.fullbright.get())
            cir.setReturnValue(false);
    }
}
