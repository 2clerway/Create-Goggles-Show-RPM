package dev.clerway.cgsrpm;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(CreateGSRPM.MOD_ID)
public class CreateGSRPM {
    public static final String MOD_ID = "creategsrpm";
    public static final String NAME = "Create GSRPM";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

    public CreateGSRPM(IEventBus modEventBus) {
        LOGGER.info("{} initializing.", NAME);
    }

}
