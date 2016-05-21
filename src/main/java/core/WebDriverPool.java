package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by def on 16.05.2016.
 */

public class WebDriverPool {
    private ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<WebDriver>();

    public WebDriver getWebDriver() {
        if (webDriverThreadLocal.get() == null) {
            webDriverThreadLocal.set(createWebDriver());}
        return webDriverThreadLocal.get();
    }

    public void closeDriver(){
        webDriverThreadLocal.get().quit();
        webDriverThreadLocal.remove();
    }
    public void remove(){
        webDriverThreadLocal.remove();
    }


    private WebDriver createWebDriver(){
        WebDriver webDriver;
        if (System.getProperty("browser") == null || System.getProperty("browser").equals("")) {
            System.setProperty("browser", "firefox");
        }

        if ("firefox".equals(System.getProperty("browser"))) {
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            webDriver = new FirefoxDriver(capabilities);
        } else {
            if (System.getProperty("webdriver.chrome.driver") == null) {
                System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
            }
            DesiredCapabilities caps = DesiredCapabilities.chrome();
            caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            webDriver = new ChromeDriver(caps);
        }
        webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        return webDriver;    }
}
