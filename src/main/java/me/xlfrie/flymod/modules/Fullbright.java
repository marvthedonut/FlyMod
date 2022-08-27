package me.xlfrie.flymod.modules;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.ForgeConfigSpec;

public class Fullbright {
    public static ForgeConfigSpec.BooleanValue fullbright;

    public static void toggle() {
        fullbright.set(!fullbright.get());
        Minecraft.getInstance().levelRenderer.allChanged();
    }

    public static void registerClientConfig(ForgeConfigSpec.Builder CLIENT_BUILDER) {
        CLIENT_BUILDER.comment("Fullbright").push("fullbright");
        fullbright = CLIENT_BUILDER.comment("Fullbright").define("enabled", false);
        CLIENT_BUILDER.pop();
    }
}
