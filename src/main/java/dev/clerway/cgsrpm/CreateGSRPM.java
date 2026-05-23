package dev.clerway.cgsrpm;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(CreateGSRPM.MOD_ID)
public class CreateGSRPM {
    public static final String MOD_ID = "creategsrpm";
    public static final String NAME = "Create GSRPM";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);
    public static GSRPMConfig CONFIG;

    public CreateGSRPM(IEventBus modEventBus) {
        CONFIG = GSRPMConfig.load();
        LOGGER.info("{} initializing.", NAME);

        ModLoadingContext.get().registerExtensionPoint(IConfigScreenFactory.class,
                () -> (mc, parent) -> GSRPMConfigScreen.create(parent));
    }

}
