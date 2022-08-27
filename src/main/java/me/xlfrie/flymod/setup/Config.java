package me.xlfrie.flymod.setup;

import me.xlfrie.flymod.modules.Fullbright;
import me.xlfrie.flymod.modules.ToggleSprint;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public class Config {
    public static void register() {
        registerClientConfigs();
    }

    public static ForgeConfigSpec spec;
    private static void registerClientConfigs() {
        ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();
        Fullbright.registerClientConfig(CLIENT_BUILDER);
        ToggleSprint.registerClientConfig(CLIENT_BUILDER);
        spec = CLIENT_BUILDER.build();
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, CLIENT_BUILDER.build(), "flymod-client.toml");
    }
}
