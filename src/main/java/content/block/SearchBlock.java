package content.block;

import core.AbstractBlock;
import core.AbstractPageObject;
import core.Block;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by def on 18.05.2016.
 */

@Block
public class SearchBlock extends AbstractBlock {

    @FindBy(name = "q")
    private WebElement searchField;

    public void fillSearchField(String text){
        searchField.clear();
        searchField.sendKeys(text);
    }
}
