package com.rjavey.user.biz;

import com.rjavey.common.model.command.user.LoginCommand;
import com.rjavey.common.result.Result;
import com.rjavey.user.enums.LoginType;
import org.springframework.stereotype.Service;

/**
 * @author: Rjavey
 * @create: 2023-12-17 22:31:45
 **/
@Service
public class AccountLoginServiceImpl implements LoginService {

    public AccountLoginServiceImpl() {
        LoginStrategyRegistry.register(LoginType.Account.getCode(), this);
    }

    @Override
    public Result login(LoginCommand loginCommand) {
        return null;
    }
}
