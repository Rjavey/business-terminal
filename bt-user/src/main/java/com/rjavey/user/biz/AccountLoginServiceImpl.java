package com.rjavey.user.biz;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.Header;
import cn.hutool.jwt.JWTUtil;
import com.rjavey.common.constant.CookieConstant;
import com.rjavey.common.exception.serve.UnauthorizedException;
import com.rjavey.common.model.command.user.LoginCommand;
import com.rjavey.common.model.dto.IdentityDTO;
import com.rjavey.common.model.po.user.User;
import com.rjavey.common.model.vo.user.UserLoginInfoVO;
import com.rjavey.common.result.Result;
import com.rjavey.user.enums.LoginType;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

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
    public Result<UserLoginInfoVO> login(LoginCommand loginCommand, HttpServletResponse response) {

        // todo 查询用户账号
        User user = new User();
        // 比对密码信息
        if (!Objects.equals(SecureUtil.md5(loginCommand.getPassword()),user.getPassword())){
            throw new UnauthorizedException();
        }

        // todo 创建jwt
        IdentityDTO identity = new IdentityDTO();
        byte[] key = new byte[1];
        String token = JWTUtil.createToken(BeanUtil.beanToMap(identity),key);
        String refreshToken = JWTUtil.createToken(BeanUtil.beanToMap(identity),key);

        // token放入redis

        response.addHeader(Header.AUTHORIZATION.getValue(),token);
        Cookie cookie = new Cookie(CookieConstant.REFRESH_TOKEN,refreshToken);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);

        // 封装登录信息
        UserLoginInfoVO info = new UserLoginInfoVO();


        return Result.success(info);
    }
}
