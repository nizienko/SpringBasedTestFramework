package core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by def on 18.05.2016.
 */
public class AbstractBlock implements IBlock {
    protected WebDriver webDriver;

    private By locator;

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void initHtmlElements() {
        PageFactory.initElements(webDriver, this);
    }

    public void setLocator(By locator) {
        this.locator = locator;
    }
}
