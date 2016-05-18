package core;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;

/**
 * Created by def on 18.05.2016.
 */
public class InitBlockPostProcessor implements BeanPostProcessor {

    @Autowired
    private WebDriver webDriver;

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(Page.class))
        {
            System.out.println("Page initialized");
            for (Field field : bean.getClass().getDeclaredFields()) {
                System.out.println(field.getName());
                if (field.getType().isAnnotationPresent(Block.class)) {
                    System.out.println("Block detected");
                    try {
                        Object o = field.getType().newInstance();
                        IBlock block = (IBlock) o;
                        block.setWebDriver(webDriver);
                        block.initHtmlElements();
                        field.setAccessible(true);
                        field.set(bean, o);
                    } catch (ReflectiveOperationException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
