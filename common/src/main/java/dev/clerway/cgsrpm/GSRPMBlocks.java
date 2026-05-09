package dev.clerway.cgsrpm;

import com.simibubi.create.foundation.data.CreateRegistrate;

public class GSRPMBlocks {
	public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(CreateGSRPM.MOD_ID);

	public static void init() {
		CreateGSRPM.LOGGER.info("Registering blocks for " + CreateGSRPM.NAME);
	}
}
