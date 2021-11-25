package ru.nshpakov.store.inventory;

import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.dsl.testng.TestNGCitrusTestRunner;
import org.testng.annotations.Test;
import ru.nshpakov.GetUserGradeBehavior;

@Test
public class GetUserGradeTest extends TestNGCitrusTestRunner {

    @CitrusTest(name = "/user/get/{id} - получение оценки пользователя")
    public void getAllUserGradeFromMock() {
        applyBehavior(new GetUserGradeBehavior().setUserId(1));
    }
}