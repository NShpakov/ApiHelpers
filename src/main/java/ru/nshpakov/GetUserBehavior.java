package ru.nshpakov;

import com.consol.citrus.context.TestContext;
import com.consol.citrus.dsl.runner.AbstractTestBehavior;
import com.consol.citrus.validation.json.JsonMappingValidationCallback;
import org.springframework.http.HttpStatus;
import org.testng.Assert;
import ru.nshpakov.dto.UserDto;

import java.util.Map;

public class GetUserBehavior extends AbstractTestBehavior {
    private TestContext testContext;

    public GetUserBehavior(TestContext testContext) {
        this.testContext = testContext;
    }

    @Override
    public void apply() {
        http(httpActionBuilder -> httpActionBuilder.client("lhost")
                .send()
                .get("/user/get/all"));

        http(httpActionBuilder -> httpActionBuilder.client("lhost")
                .receive()
                .response(HttpStatus.OK)
                .validationCallback(new JsonMappingValidationCallback<UserDto>(UserDto.class) {
                    @Override
                    public void validate(UserDto userDto, Map<String, Object> map, TestContext testContext) {
                        Assert.assertEquals(userDto.getEmail(), getExpectedUser().getEmail(), "email");
                        Assert.assertEquals(userDto.getCource(), getExpectedUser().getCource(), "Cource");
                        Assert.assertEquals(userDto.getName(), getExpectedUser().getName(), "Name");
                        Assert.assertEquals(userDto.getAge(), getExpectedUser().getAge(), "Age");
                    }
                })
        );
    }

    private UserDto getExpectedUser() {
        UserDto expectedUserDto = new UserDto();
        expectedUserDto.setEmail("test@test.test");
        expectedUserDto.setCource("QA");
        expectedUserDto.setName("Test user");
        expectedUserDto.setAge(23L);
        return expectedUserDto;
    }
}