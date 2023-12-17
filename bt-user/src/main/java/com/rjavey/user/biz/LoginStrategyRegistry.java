package com.rjavey.user.biz;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LoginStrategyRegistry {

    private static final Map<String, LoginService> strategy = new ConcurrentHashMap<>();

    public static void register(String loginType, LoginService loginService) {
        strategy.put(loginType, loginService);
    }

    public static LoginService getStrategy(String loginType) {
        return strategy.get(loginType);
    }

}
