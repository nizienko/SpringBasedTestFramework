package core.block;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

/**
 * Created by def on 18.05.2016.
 */
public class AbstractBlock implements IBlock {
    protected WebDriver webDriver;

    private By parentLocator;

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void setParentLocator(By parentLocator) {
        this.parentLocator = parentLocator;
    }
}
