package core;

import org.openqa.selenium.WebDriver;

/**
 * Created by def on 18.05.2016.
 */
public interface IBlock {
    void setWebDriver(WebDriver webDriver);
    void initHtmlElements();
}
