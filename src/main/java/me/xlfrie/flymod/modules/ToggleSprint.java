package me.xlfrie.flymod.modules;

import com.mojang.blaze3d.vertex.PoseStack;
import me.xlfrie.flymod.FlyMod;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FlyMod.MODID)
public class ToggleSprint {
    /**
     * {@link me.xlfrie.flymod.mixin.LocalPlayerMixin}
     */
    public static ForgeConfigSpec.BooleanValue sprinting;

    @SubscribeEvent
    public static void render(RenderGuiOverlayEvent event) {
        if (!ToggleSprint.sprinting.get()) return;
        Minecraft.getInstance().gui.getFont().draw(new PoseStack(), "Sprinting [Toggled]", 5, Minecraft.getInstance().getWindow().getGuiScaledHeight()-Minecraft.getInstance().font.lineHeight-5, 0xFF_FF_FF_FF);
    }

    public static void toggle() {
        sprinting.set(!sprinting.get());

    }

    public static void registerClientConfig(ForgeConfigSpec.Builder CLIENT_BUILDER) {
        CLIENT_BUILDER.comment("Sprinting").push("sprinting");
        sprinting = CLIENT_BUILDER.comment("Sprinting").define("enabled", false);
        CLIENT_BUILDER.pop();
    }
}
