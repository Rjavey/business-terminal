package com.rjavey.user.biz;

import com.rjavey.common.model.command.user.LoginCommand;
import com.rjavey.common.model.vo.user.UserLoginInfoVO;
import com.rjavey.common.result.Result;
import com.rjavey.user.enums.LoginType;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: Rjavey
 * @create: 2023-12-17 22:32:20
 **/
@Service
@AllArgsConstructor(onConstructor_ = {@Lazy})
@Slf4j
public class PhoneNumberLoginServiceImpl implements LoginService {

    @PostConstruct
    public void init() {
        LoginStrategyRegistry.register(LoginType.PhoneNumber.getCode(), this);
    }

    @Override
    public Result<UserLoginInfoVO> login(LoginCommand loginCommand, HttpServletResponse response) {
        return null;
    }

}
