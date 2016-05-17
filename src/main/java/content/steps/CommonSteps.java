package content.steps;

import core.Steps;

/**
 * Created by def on 16.05.2016.
 */

@Steps
public class CommonSteps {
    public void wait(int t) {
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
