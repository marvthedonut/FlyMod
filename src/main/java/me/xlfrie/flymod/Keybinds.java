package me.xlfrie.flymod;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.apache.commons.lang3.ArrayUtils;
import org.lwjgl.glfw.GLFW;

public class Keybinds {
    public static final String FLYMOD_CATEGORY = "key.category.flymod.flymod";
    public static final String KEY_FLIGHT = "key.flymod.flight";
    public static final String KEY_XRAY = "key.flymod.xray";
    public static final String KEY_FULLBRIGHT = "key.flymod.fullbright";
    public static final String KEY_SPRINT = "key.flymod.toggle_sprint";

    public static KeyMapping[] KEYS = new KeyMapping[4];
    static {
        KEYS[0] = new KeyMapping(KEY_FLIGHT, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_B, FLYMOD_CATEGORY);
        KEYS[1] = new KeyMapping(KEY_XRAY, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_X, FLYMOD_CATEGORY);
        KEYS[2] = new KeyMapping(KEY_FULLBRIGHT, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_G, FLYMOD_CATEGORY);
        KEYS[3] = new KeyMapping(KEY_SPRINT, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_I, FLYMOD_CATEGORY);
    }

    public static void init() {
        for (KeyMapping key : KEYS) {
            Minecraft.getInstance().options.keyMappings = ArrayUtils.add(Minecraft.getInstance().options.keyMappings, key);
        }
    }
}
