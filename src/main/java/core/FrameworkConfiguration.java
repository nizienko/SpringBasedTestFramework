package core;

import core.block.InitBlockPostProcessor;
import core.page.Page;
import core.steps.Steps;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

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
}
