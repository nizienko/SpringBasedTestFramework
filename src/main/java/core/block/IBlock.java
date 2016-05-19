package core.block;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by def on 18.05.2016.
 */
public interface IBlock {
    void setWebDriver(WebDriver webDriver);
    void initHtmlElements();
    void setLocator(By locator);
}
