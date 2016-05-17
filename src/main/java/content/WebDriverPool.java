package content;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by def on 16.05.2016.
 */

@Component
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
        return new FirefoxDriver();
    }
}
