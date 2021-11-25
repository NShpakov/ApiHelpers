package ru.nshpakov.store.inventory;

import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.context.TestContext;
import com.consol.citrus.dsl.testng.TestNGCitrusTestRunner;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ru.nshpakov.GetCoursesListBehavior;

@Test
public class GetCourseListTest extends TestNGCitrusTestRunner {
    private TestContext testContext;

    @BeforeSuite
    public void createContext() {
        testContext = citrus.createTestContext();
    }

    @CitrusTest(name = "/course/get/all - получение списка всех курсов")
    public void getAllCoursesFromMock() {
        applyBehavior(new GetCoursesListBehavior(testContext));
    }
}