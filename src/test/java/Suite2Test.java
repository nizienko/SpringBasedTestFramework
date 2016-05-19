import content.steps.CommonSteps;
import content.steps.GoogleSteps;
import core.ExecutionListener;
import core.FrameworkConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by def on 17.05.2016.
 */

public class Suite2Test extends Suite{

    @Autowired
    private GoogleSteps googleSteps;

    @Test
    public void test1(){
        googleSteps.open();
        commonSteps.wait(3000);
    }

    @Test
    public void test3(){
        googleSteps.open();
        commonSteps.wait(3000);
    }
}
