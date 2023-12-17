package com.rjavey.user.controller;

import com.rjavey.common.model.command.user.LoginCommand;
import com.rjavey.common.result.Result;
import com.rjavey.user.biz.LoginService;
import com.rjavey.user.biz.LoginStrategyRegistry;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Rjavey
 * @create: 2023-12-17 22:41:59
 **/
@RestController
@RequestMapping("/login")
public class LoginController {

    @PostMapping("/")
    public Result login(LoginCommand command) {
        LoginService loginService = LoginStrategyRegistry.getStrategy(command.getLoginType());
        if (loginService == null) {
            throw new IllegalArgumentException("Invalid login type: " + command.getLoginType());
        }
        return loginService.login(command);
    }

}
