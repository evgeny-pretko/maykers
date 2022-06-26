package steps.hooks;

import core.driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void beforeEach() {
        Driver.createDriver();
    }

    @After
    public void afterEach() {
        Driver.cleanUpDriver();
    }

}
