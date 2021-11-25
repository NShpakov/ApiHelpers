package ru.nshpakov.utils;

import com.github.tomakehurst.wiremock.WireMockServer;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class WaermockSingelton {
    private static WaermockSingelton waermockInstance;
    private static WireMockServer wireMockServer;
    private static final int PORT_MOCK = 8081;

    private WaermockSingelton() {
    }

    public static synchronized WaermockSingelton getWaermockInstance() {
        if (waermockInstance == null) {
            waermockInstance = new WaermockSingelton();
        }
        return waermockInstance;
    }

    public WireMockServer getWireMockServer() {
        if (wireMockServer == null) {
            wireMockServer = new WireMockServer(wireMockConfig().port(PORT_MOCK));
        }
        return wireMockServer;
    }
}