import content.steps.CommonSteps;
import core.ExecutionListener;
import core.FrameworkConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import content.steps.GoogleSteps;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by def on 16.05.2016.
 */

public class Suite1Test extends Suite {

    @Autowired
    private GoogleSteps googleSteps;

    @Test
    public void test1(){
        googleSteps.open();
        googleSteps.fillSearchField("Россия Германия");
        commonSteps.wait(3000);
    }

    @Test
    public void test3(){
        googleSteps.open();
        commonSteps.wait(3000);
    }
}
