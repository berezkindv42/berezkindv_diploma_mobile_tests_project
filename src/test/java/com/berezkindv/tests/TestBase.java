package com.berezkindv.tests;

import com.codeborne.selenide.Configuration;
import com.berezkindv.drivers.BrowserstackMobileDriver;
import com.berezkindv.drivers.EmulatorMobileDriver;
import com.berezkindv.drivers.RealPhoneMobileDriver;
import com.berezkindv.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static com.berezkindv.helpers.Attach.getSessionId;


public class TestBase {
    static String deviceHost = System.getProperty("deviceHost").toLowerCase();

    @BeforeAll
    public static void setup() {
        addListener("AllureSelenide", new AllureSelenide());

        switch (deviceHost) {
            case "browserstack":
                Configuration.browser = BrowserstackMobileDriver.class.getName();
                break;
            case "emulator":
                Configuration.browser = EmulatorMobileDriver.class.getName();
                break;
            case "real":
                Configuration.browser = RealPhoneMobileDriver.class.getName();
                break;
            default:
                throw new RuntimeException("Неверно передан параметр deviceHost, " +
                        "вберите из: browserstack / emulator / real");
        }
        Configuration.browserSize = null;
    }

    @BeforeEach
    public void startDriver() {
        open();
        Attach.attachAsText("Устройство запуска:", deviceHost);
    }

    @AfterEach
    public void afterEach() {
        String sessionId = getSessionId();

        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();

        closeWebDriver();

        if (deviceHost.contains("browserstack"))
            Attach.video(sessionId);
    }
}
