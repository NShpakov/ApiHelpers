package ru.nshpakov.before_after_actions;

import com.consol.citrus.dsl.runner.TestRunner;
import com.consol.citrus.dsl.runner.TestRunnerAfterSuiteSupport;
import ru.nshpakov.utils.WaermockSingelton;
public class SetUpAfterSuite extends TestRunnerAfterSuiteSupport {

    @Override
    public void afterSuite(TestRunner testRunner) {
        WaermockSingelton.getWaermockInstance().getWireMockServer().stop();
        testRunner.echo("Waermock is stoped");
    }
}
