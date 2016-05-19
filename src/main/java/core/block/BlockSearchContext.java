package core.block;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by nizienko on 19.05.2016.
 */

public class BlockSearchContext implements SearchContext {
    private WebDriver webDriver;
    private By parentLocator;

    public BlockSearchContext(WebDriver webDriver, By parentLocator) {
        this.webDriver = webDriver;
        this.parentLocator = parentLocator;
    }

    public List<WebElement> findElements(By by) {
        return webDriver.findElement(parentLocator).findElements(by);
    }

    public WebElement findElement(By by) {
        return webDriver.findElement(parentLocator).findElement(by);
    }
}
