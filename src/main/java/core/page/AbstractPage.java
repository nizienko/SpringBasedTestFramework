package core.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;

/**
 * Created by def on 17.05.2016.
 */

public class AbstractPage {

    @Autowired
    protected WebDriver webDriver;

    @PostConstruct
    public void init(){
        PageFactory.initElements(webDriver, this);
    }
}
