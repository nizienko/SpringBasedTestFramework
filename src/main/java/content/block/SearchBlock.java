package content.block;

import core.block.AbstractBlock;
import core.block.Block;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by def on 18.05.2016.
 */

@Block
@FindBy(name = "f")
public class SearchBlock extends AbstractBlock {

    private SubBlock subBlock;

    public void fillSearchField(String text) {
        subBlock.fillSearchField(text);
    }

}
