package me.xlfrie.flymod.modules;

import me.xlfrie.flymod.FlyMod;
import me.xlfrie.flymod.Keybinds;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FlyMod.MODID)
public class Flight {
    @SubscribeEvent
    public static void keyInput(InputEvent.Key event) {
        if (Keybinds.KEYS[1].consumeClick()) {
            XRay.toggle();
        } else if (Keybinds.KEYS[0].consumeClick()) {
            if (!Minecraft.getInstance().player.getAbilities().flying && Minecraft.getInstance().player.isOnGround())
                Minecraft.getInstance().player.setDeltaMovement(Minecraft.getInstance().player.getDeltaMovement().x, 0.25, Minecraft.getInstance().player.getDeltaMovement().z);
            Minecraft.getInstance().player.getAbilities().flying = !Minecraft.getInstance().player.getAbilities().flying;
        } else if (Keybinds.KEYS[2].consumeClick()) {
            Fullbright.toggle();
        } else if (Keybinds.KEYS[3].consumeClick()) {
            ToggleSprint.toggle();
        }
    }
}
