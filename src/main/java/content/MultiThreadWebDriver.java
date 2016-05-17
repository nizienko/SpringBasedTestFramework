package content;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by def on 17.05.2016.
 */

@Service
public class MultiThreadWebDriver implements WebDriver{

    @Autowired
    private WebDriverPool webDriverPool;

    public void get(String s) {
        this.webDriverPool.getWebDriver().get(s);
    }

    public String getCurrentUrl() {
        return  this.webDriverPool.getWebDriver().getCurrentUrl();
    }

    public String getTitle() {
        return  this.webDriverPool.getWebDriver().getTitle();
    }

    public List<WebElement> findElements(By by) {
        return  this.webDriverPool.getWebDriver().findElements(by);
    }

    public WebElement findElement(By by) {
        return  this.webDriverPool.getWebDriver().findElement(by);
    }

    public String getPageSource() {
        return  this.webDriverPool.getWebDriver().getPageSource();
    }

    public void close() {
        this.webDriverPool.getWebDriver().close();
    }

    public void quit() {
        this.webDriverPool.getWebDriver().quit();
        this.webDriverPool.remove();
    }

    public Set<String> getWindowHandles() {
        return this.webDriverPool.getWebDriver().getWindowHandles();
    }

    public String getWindowHandle() {
        return this.webDriverPool.getWebDriver().getWindowHandle();
    }

    public TargetLocator switchTo() {
        return this.webDriverPool.getWebDriver().switchTo();
    }

    public Navigation navigate() {
        return this.webDriverPool.getWebDriver().navigate();
    }

    public Options manage() {
        return this.webDriverPool.getWebDriver().manage();
    }

    @Override
    public String toString() {
        return "MultiThreadWebDriver";
    }
}
