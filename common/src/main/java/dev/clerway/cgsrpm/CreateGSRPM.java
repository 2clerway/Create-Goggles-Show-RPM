package dev.clerway.cgsrpm;

import com.simibubi.create.Create;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateGSRPM {
    public static final String MOD_ID = "creategsrpm";
    public static final String NAME = "Create GSRPM";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);


    public static void init() {
        LOGGER.info("{} initializing.", NAME, "6.0.8", GSRPMExpectPlatform.platformName());
        GSRPMBlocks.init();
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
