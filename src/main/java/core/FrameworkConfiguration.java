package core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by def on 16.05.2016.
 */
@Configuration
@ComponentScan(basePackages = "content", includeFilters = @ComponentScan.Filter({Page.class, Steps.class, Block.class}))
public class FrameworkConfiguration {

}
