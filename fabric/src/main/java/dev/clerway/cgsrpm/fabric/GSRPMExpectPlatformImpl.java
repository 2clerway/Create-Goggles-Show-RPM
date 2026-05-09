package dev.clerway.cgsrpm.fabric;

import net.fabricmc.loader.api.FabricLoader;

public class GSRPMExpectPlatformImpl {
	public static String platformName() {
		return FabricLoader.getInstance().isModLoaded("quilt_loader") ? "Quilt" : "Fabric";
	}
}
