package dev.clerway.cgsrpm.forge;

import dev.clerway.cgsrpm.GSRPMBlocks;
import dev.clerway.cgsrpm.CreateGSRPM;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CreateGSRPM.MOD_ID)
public class CreateGSRPMForge {
    public CreateGSRPMForge() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        GSRPMBlocks.REGISTRATE.registerEventListeners(eventBus);
        CreateGSRPM.init();
    }
}
