package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by def on 18.05.2016.
 */
public class PageObjectFactoryUtils {
    public static void init(WebDriver webDriver, Object page) {
        PageFactory.initElements(webDriver, page);
    }
}
