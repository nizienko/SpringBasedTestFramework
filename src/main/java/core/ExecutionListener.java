package core;

import org.openqa.selenium.WebDriver;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;

/**
 * Created by def on 17.05.2016.
 */
public class ExecutionListener implements TestExecutionListener {

    public void beforeTestClass(TestContext testContext) throws Exception {

    }

    public void prepareTestInstance(TestContext testContext) throws Exception {

    }

    public void beforeTestMethod(TestContext testContext) throws Exception {

    }

    public void afterTestMethod(TestContext testContext) throws Exception {

    }

    public void afterTestClass(TestContext testContext) throws Exception {
        WebDriver webDriver = testContext.getApplicationContext().getBean(WebDriver.class);
        webDriver.quit();
    }
}
