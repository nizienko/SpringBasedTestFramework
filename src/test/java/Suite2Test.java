import content.steps.GoogleSteps;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by def on 17.05.2016.
 */
public class Suite2Test extends Suite {

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
