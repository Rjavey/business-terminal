package com.rjavey.user.biz;

import com.rjavey.common.model.command.user.LoginCommand;
import com.rjavey.common.model.vo.user.UserLoginInfoVO;
import com.rjavey.common.result.Result;
import com.rjavey.user.enums.LoginType;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

/**
 * @author: Rjavey
 * @create: 2023-12-17 22:32:20
 **/
@Service
public class PhoneNumberLoginServiceImpl implements LoginService {

    public PhoneNumberLoginServiceImpl() {
        LoginStrategyRegistry.register(LoginType.PhoneNumber.getCode(), this);
    }

    @Override
    public Result<UserLoginInfoVO> login(LoginCommand loginCommand, HttpServletResponse response) {
        return null;
    }

}
