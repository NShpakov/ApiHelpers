package ru.nshpakov;

import com.consol.citrus.dsl.runner.AbstractTestBehavior;
import ru.nshpakov.utils.WaermockSingelton;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
//Оставил в качестве образца для себя
@Deprecated
public class GetCourseAllBehaviorMock extends AbstractTestBehavior {
    @Override
    public void apply() {
        WaermockSingelton.getWaermockInstance().getWireMockServer().stubFor(get(urlMatching("/cource/get/all"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("[\n" +
                                " {\n" +
                                "   \"name\":\"QA java\",\n" +
                                "  \"price\": 15000\n" +
                                " },\n" +
                                " {\n" +
                                "  \"name\":\"Java\",\n" +
                                "   \"price\": 12000\n" +
                                " }\n" +
                                "]")));
    }
}