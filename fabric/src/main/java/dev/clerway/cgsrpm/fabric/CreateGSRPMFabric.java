package dev.clerway.cgsrpm.fabric;

import io.github.fabricators_of_create.porting_lib.util.EnvExecutor;
import dev.clerway.cgsrpm.GSRPMBlocks;
import dev.clerway.cgsrpm.CreateGSRPM;
import net.fabricmc.api.ModInitializer;

public class CreateGSRPMFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        CreateGSRPM.init();
        CreateGSRPM.LOGGER.info(EnvExecutor.unsafeRunForDist(
                () -> () -> "{} is accessing Porting Lib on a Fabric client!",
                () -> () -> "{} is accessing Porting Lib on a Fabric server!"
                ), CreateGSRPM.NAME);
        // on fabric, Registrates must be explicitly finalized and registered.
        // GSRPMBlocks.REGISTRATE.register();
    }
}
