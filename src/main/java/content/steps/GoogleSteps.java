package content.steps;

import content.pages.GooglePage;
import core.steps.Steps;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by def on 16.05.2016.
 */

@Steps
public class GoogleSteps {
    @Autowired
    private GooglePage googlePage;

    public void open(){
        googlePage.open();
    }

    public void fillSearchField(String text) {
        googlePage.fillSearchField(text);
    }
}
