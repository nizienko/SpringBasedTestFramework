package core.block;

import core.page.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
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
            for (Field field : bean.getClass().getDeclaredFields()) {
                if (field.getType().isAnnotationPresent(Block.class)) {
                    By locator = null;
                    if (field.isAnnotationPresent(FindBy.class) || field.getType().isAnnotationPresent(FindBy.class)) {
                        locator = new BlockAnnotations(field).buildBy();
                    }
                    try {
                        Object o = field.getType().newInstance();
                        IBlock block = (IBlock) o;
                        block.setWebDriver(webDriver);
                        block.setParentLocator(locator);
                        initHtmlElements(locator, block);

                        field.setAccessible(true);
                        field.set(bean, block);
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

    private void initHtmlElements(By locator, IBlock block) {
        if (locator != null) {
            PageFactory.initElements(new DefaultElementLocatorFactory(new BlockSearchContext(webDriver, locator)), block);
        }
        else {
            PageFactory.initElements(webDriver, block);
        }
    }
}
