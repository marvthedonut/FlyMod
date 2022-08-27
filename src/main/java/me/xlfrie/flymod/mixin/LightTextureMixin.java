package me.xlfrie.flymod.mixin;

import me.xlfrie.flymod.modules.Fullbright;
import me.xlfrie.flymod.modules.XRay;
import net.minecraft.client.renderer.LightTexture;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(LightTexture.class)
public class LightTextureMixin {
    @ModifyArg(method = "updateLightTexture", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/platform/NativeImage;setPixelRGBA(III)V"), index = 2)
    private int stink(int pX) {
        if (XRay.xraying || Fullbright.fullbright.get())
            return 0xFFFFFFFF;
        else return pX;
    }
}
