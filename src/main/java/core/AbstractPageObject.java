package core;

import core.PageObjectFactoryUtils;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;

/**
 * Created by def on 17.05.2016.
 */

public class AbstractPageObject {

    @Autowired
    protected WebDriver webDriver;

    @PostConstruct
    public void init(){
        PageObjectFactoryUtils.init(webDriver, this);
    }
}
