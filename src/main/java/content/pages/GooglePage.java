package content.pages;
import content.block.SearchBlock;
import core.AbstractPageObject;
import core.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by def on 16.05.2016.
 */

@Page
public class GooglePage extends AbstractPageObject {

    @FindBy(name = "f")
    private SearchBlock searchBlock;

    public void open() {
        webDriver.get("https://google.com");
    }

    public void fillSearchField(String text) {
        searchBlock.fillSearchField(text);
    }


}
