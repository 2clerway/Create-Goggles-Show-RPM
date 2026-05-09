package dev.clerway.cgsrpm;

import dev.architectury.injectables.annotations.ExpectPlatform;

public class GSRPMExpectPlatform {
    @ExpectPlatform
    public static String platformName() {
        throw new AssertionError();
    }
}
