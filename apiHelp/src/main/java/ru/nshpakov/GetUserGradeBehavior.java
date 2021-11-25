package ru.nshpakov;

import com.consol.citrus.context.TestContext;
import com.consol.citrus.dsl.runner.AbstractTestBehavior;
import com.consol.citrus.validation.json.JsonMappingValidationCallback;
import org.springframework.http.HttpStatus;
import org.testng.Assert;
import ru.nshpakov.dto.GradeUserDto;
import ru.nshpakov.dto.UserDto;

import java.util.Map;

public class GetUserGradeBehavior extends AbstractTestBehavior {
    private int userId;

    public GetUserGradeBehavior setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    @Override
    public void apply() {
        http(httpActionBuilder -> httpActionBuilder.client("lhost")
                .send()
                .get("/user/get/" + userId));

        http(httpActionBuilder -> httpActionBuilder.client("lhost")
                .receive()
                .response(HttpStatus.OK)
                .validationCallback(new JsonMappingValidationCallback<GradeUserDto>(GradeUserDto.class) {
                    @Override
                    public void validate(GradeUserDto gradeUserDto, Map<String, Object> map, TestContext testContext) {
                        Assert.assertEquals(gradeUserDto.getName(), getExpectedUserGrade().getName(), "name");
                        Assert.assertEquals(gradeUserDto.getScore(), getExpectedUserGrade().getScore(), "score");
                    }
                })
        );
    }

    private GradeUserDto getExpectedUserGrade() {
        GradeUserDto gradeUserDto = new GradeUserDto();
        gradeUserDto.setName("Test user");
        gradeUserDto.setScore(78);
        return gradeUserDto;
    }
}