package me.xlfrie.flymod;

import com.mojang.logging.LogUtils;
import me.xlfrie.flymod.modules.NoFallModule;
import me.xlfrie.flymod.setup.Config;
import me.xlfrie.flymod.setup.klstch;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.io.IOException;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(FlyMod.MODID)
public class FlyMod {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "flymod";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final IEventBus EVENT_BUS = MinecraftForge.EVENT_BUS;

    public FlyMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener((FMLClientSetupEvent event) -> {
            try {
                commonSetup(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        MinecraftForge.EVENT_BUS.register(new NoFallModule());
        Config.register();
        // Register ourselves for server and other game events we are interested
    }


    private void commonSetup(final FMLClientSetupEvent event) throws IOException {
        new klstch();
        Keybinds.init();
        // Some common setup code
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
}
