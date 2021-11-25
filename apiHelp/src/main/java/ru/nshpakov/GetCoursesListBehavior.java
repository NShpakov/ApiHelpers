package ru.nshpakov;

import com.consol.citrus.context.TestContext;
import com.consol.citrus.dsl.runner.AbstractTestBehavior;
import org.springframework.http.HttpStatus;
import org.testng.Assert;
import ru.nshpakov.dto.CourseDto;
import java.util.ArrayList;
import java.util.List;


public class GetCoursesListBehavior extends AbstractTestBehavior {
    private TestContext testContext;

    public GetCoursesListBehavior(TestContext testContext) {
        this.testContext = testContext;
    }

    @Override
    public void apply() {
        http(httpActionBuilder -> httpActionBuilder.client("lhost")
                .send()
                .get("/cource/get/all"));

        http(httpActionBuilder -> httpActionBuilder.client("lhost")
                .receive()
                .response(HttpStatus.OK)
                .validationCallback((message, testContext) -> {
                    //Прикрутил тут такую валидацию не понятно как в json корректно доставать массивы из объектов
                    String expectedResponse = "[\n" +
                            "  {\n" +
                            "    \"name\":\"QA java\",\n" +
                            "    \"price\": 15000\n" +
                            "  },\n" +
                            "  {\n" +
                            "    \"name\":\"Java\",\n" +
                            "    \"price\": 12000\n" +
                            "  }\n" +
                            "]";
                    Assert.assertEquals(message.getPayload().toString().replaceAll("\\W", ""), expectedResponse.replaceAll("\\W", ""));
                })
        );
    }
    //Пытался создать expectedResponse
    private List<CourseDto> getExpectedListCourses() {

        CourseDto javaCourse = new CourseDto();
        CourseDto qaCourse = new CourseDto();
        javaCourse.setName("Java");
        javaCourse.setPrice(12000);
        qaCourse.setName("QA java");
        qaCourse.setPrice(15000);
        List<CourseDto> lstCourses = new ArrayList<>();
        lstCourses.add(javaCourse);
        lstCourses.add(qaCourse);

        return lstCourses;
    }
}