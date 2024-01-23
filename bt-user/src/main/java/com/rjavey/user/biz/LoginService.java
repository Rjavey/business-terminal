package com.rjavey.user.biz;

import com.rjavey.common.model.command.user.LoginCommand;
import com.rjavey.common.model.vo.user.UserLoginInfoVO;
import com.rjavey.common.result.Result;
import jakarta.servlet.http.HttpServletResponse;

public interface LoginService {

    /**
     * 用户登录
     *
     * @param loginCommand
     * @return
     */
    Result<UserLoginInfoVO> login(LoginCommand loginCommand, HttpServletResponse response);

}
