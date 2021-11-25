package ru.nshpakov.before_after_actions;

import com.consol.citrus.dsl.runner.TestRunner;
import com.consol.citrus.dsl.runner.TestRunnerBeforeSuiteSupport;
import ru.nshpakov.utils.WaermockSingelton;
public class SetUpBeforeSuite extends TestRunnerBeforeSuiteSupport {

    @Override
    public void beforeSuite(TestRunner testRunner) {
        WaermockSingelton.getWaermockInstance().getWireMockServer().start();
        testRunner.echo("Waermock is started");
    }
}
