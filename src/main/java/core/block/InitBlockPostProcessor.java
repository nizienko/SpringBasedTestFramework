package core.block;

import core.page.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

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
                initBlock(bean, field, null);
            }
        }
        return bean;
    }

    private void initBlock(Object parentBlock, Field field, SearchContext searchContext) {
        if (field.getType().isAnnotationPresent(Block.class)) {
            By locator = null;
            if (field.isAnnotationPresent(FindBy.class) || field.getType().isAnnotationPresent(FindBy.class)) {
                locator = new BlockAnnotations(field).buildBy();
            }
            try {
                Object o = field.getType().newInstance();
                IBlock block = (IBlock) o;
                System.out.println(block);
                block.setWebDriver(webDriver);
                block.setParentLocator(locator);

                if (searchContext == null) {
                    searchContext = (SearchContext) Proxy.newProxyInstance(block.getClass().getClassLoader(),
                            new Class<?>[] { SearchContext.class },
                            new SearchContextInvocationHandler(webDriver, locator));
                }
                else {
                    searchContext =
                            (SearchContext) Proxy.newProxyInstance(block.getClass().getClassLoader(),
                                    new Class<?>[] { SearchContext.class },
                                    new SearchContextInvocationHandler(searchContext, locator));
                }

                initHtmlElements(searchContext, block);

                field.setAccessible(true);
                field.set(parentBlock, block);
                System.out.println(field.getName());

                for (Field innerField : field.getType().getDeclaredFields()) {
                    initBlock(block, innerField, searchContext);
                }
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    private void initHtmlElements(SearchContext searchContext, IBlock block) {
        if (searchContext != null) {
            PageFactory.initElements(new DefaultElementLocatorFactory(searchContext), block);
        }
        else {
            PageFactory.initElements(webDriver, block);
        }
    }
}
