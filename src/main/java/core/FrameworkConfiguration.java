package core;

import core.block.InitBlockPostProcessor;
import core.page.Page;
import core.steps.Steps;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Proxy;

/**
 * Created by def on 16.05.2016.
 */
@Configuration
@ComponentScan(basePackages = "content",
        includeFilters = @ComponentScan.Filter({Page.class, Steps.class}),
        lazyInit = true)
public class FrameworkConfiguration {

    @Bean
    public InitBlockPostProcessor initBlockPostProcessor() {
        return new InitBlockPostProcessor();
    }

    @Bean
    public WebDriverPool webDriverPool() {
        return new WebDriverPool();
    }

    @Bean(destroyMethod = "")
    public WebDriver webDriver() {
        return (WebDriver) Proxy.newProxyInstance(
                webDriverPool().getClass().getClassLoader(),
                new Class<?>[] { WebDriver.class },
                new MultiThreadWebDriverInvocationHandler(webDriverPool()));}
}
