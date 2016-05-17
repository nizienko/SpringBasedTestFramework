import content.steps.CommonSteps;
import core.ExecutionListener;
import core.FrameworkConfiguration;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by def on 17.05.2016.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={FrameworkConfiguration.class})
@TestExecutionListeners(listeners = {ExecutionListener.class}, mergeMode = TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS)
public class Suite {
    @Autowired
    protected CommonSteps commonSteps;
}
