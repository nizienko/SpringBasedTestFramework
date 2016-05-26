package core.block;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by def on 27.05.2016.
 */
public class SearchContextInvocationHandler implements InvocationHandler {
    public SearchContextInvocationHandler(SearchContext searchContext, By locator) {
        this.searchContext = searchContext;
        this.locator = locator;
    }
    private By locator;
    private SearchContext searchContext;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(searchContext.findElement(locator), args);
    }
}
