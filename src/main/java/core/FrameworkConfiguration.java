package core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Created by def on 16.05.2016.
 */
@Configuration
@ComponentScan(basePackages = "content",
        includeFilters = @ComponentScan.Filter({Page.class, Steps.class, Block.class}),
        lazyInit = true)
public class FrameworkConfiguration {

    @Bean
    public InitBlockPostProcessor initBlockPostProcessor() {
        return new InitBlockPostProcessor();
    }
}
