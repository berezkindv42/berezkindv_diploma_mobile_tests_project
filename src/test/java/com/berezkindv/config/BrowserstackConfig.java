package com.berezkindv.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/browserstack.properties"
})
public interface BrowserstackConfig extends Config {
    @Key("browserstack.login")
    String browserstackLogin();

    @Key("browserstack.password")
    String browserstackPassword();

    @Key("browserstack.app.key")
    String browserstackAppKey();

    @Key("device.name")
    String deviceName();

    @Key("os.version")
    String osVersion();
}
