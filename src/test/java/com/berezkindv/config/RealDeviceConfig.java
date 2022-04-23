package com.berezkindv.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/realdevice.properties"
})
public interface RealDeviceConfig extends Config {
    @Key("platform.name")
    String platformName();

    @Key("ud.id")
    String udid();

    @Key("device.name")
    String deviceName();

    @Key("os.version")
    String osVersion();

    @Key("app.package")
    String appPackage();

    @Key("app.activity")
    String appActivity();

    @Key("local.url")
    String localUrl();
}
