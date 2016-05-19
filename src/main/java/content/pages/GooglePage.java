package content.pages;
import content.block.SearchBlock;
import core.page.AbstractPage;
import core.page.Page;

/**
 * Created by def on 16.05.2016.
 */

@Page
public class GooglePage extends AbstractPage {

    private SearchBlock searchBlock;

    public void open() {
        webDriver.get("https://google.com");
    }

    public void fillSearchField(String text) {
        searchBlock.fillSearchField(text);
    }


}
