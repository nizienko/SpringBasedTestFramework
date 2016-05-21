package core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by def on 21.05.2016.
 */
public class MultiThreadWebDriverInvocationHandler implements InvocationHandler {
    public WebDriverPool webDriverPool;

    public MultiThreadWebDriverInvocationHandler(WebDriverPool webDriverPool) {
        this.webDriverPool = webDriverPool;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(webDriverPool.getWebDriver(), args);
    }
}
