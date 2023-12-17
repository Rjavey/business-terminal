package com.rjavey.user.biz;

import com.rjavey.common.model.command.user.LoginCommand;
import com.rjavey.common.result.Result;

public interface LoginService {

    /**
     * 用户登录
     *
     * @param loginCommand
     * @return
     */
    Result login(LoginCommand loginCommand);

}
