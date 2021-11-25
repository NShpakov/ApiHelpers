package ru.nshpakov.store.inventory;

import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.context.TestContext;
import com.consol.citrus.dsl.testng.TestNGCitrusTestRunner;
import org.testng.annotations.*;
import ru.nshpakov.GetUserBehavior;

@Test
public class GetUserListTest extends TestNGCitrusTestRunner {
    private TestContext testContext;

    @BeforeSuite
    public void createContext() {
        testContext = citrus.createTestContext();
    }

    @CitrusTest(name = "/user/get/all - получение списка всех пользователей")
    public void getAllUsersFromMock() {
        applyBehavior(new GetUserBehavior(testContext));
    }


}
