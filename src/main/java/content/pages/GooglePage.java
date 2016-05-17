package content.pages;
import core.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by def on 16.05.2016.
 */

@Page
public class GooglePage extends AbstractPage {

    @FindBy(name = "q")
    private WebElement searchField;

    public void open() {
        webDriver.get("https://google.com");
    }

    public void fillSearchField(String text){
        searchField.clear();
        searchField.sendKeys(text);
    }

}
