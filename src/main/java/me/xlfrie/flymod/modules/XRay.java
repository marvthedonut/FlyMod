package me.xlfrie.flymod.modules;

import net.minecraft.client.Minecraft;

public class XRay {
    /**
     * {@link me.xlfrie.flymod.mixin.BlockMixin}
     * {@link me.xlfrie.flymod.mixin.LightTextureMixin}
     * {@link me.xlfrie.flymod.mixin.MinecraftMixin}
     * {@link me.xlfrie.flymod.mixin.XRayRender}
     */
    public static boolean xraying = false;

    public static void toggle() {
        xraying = !xraying;
        Minecraft.getInstance().levelRenderer.allChanged();
    }
}
