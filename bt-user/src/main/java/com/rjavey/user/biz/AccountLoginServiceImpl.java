package com.rjavey.user.biz;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.Header;
import cn.hutool.jwt.JWTUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rjavey.common.constant.CookieConstant;
import com.rjavey.common.enums.user.TenantUser;
import com.rjavey.common.enums.user.UserStatus;
import com.rjavey.common.exception.serve.UnauthorizedException;
import com.rjavey.common.model.command.user.LoginCommand;
import com.rjavey.common.model.dto.IdentityDTO;
import com.rjavey.common.model.po.user.Tenant;
import com.rjavey.common.model.po.user.User;
import com.rjavey.common.model.vo.user.UserLoginInfoVO;
import com.rjavey.common.result.Result;
import com.rjavey.user.enums.LoginType;
import com.rjavey.user.service.TenantService;
import com.rjavey.user.service.TenantUserService;
import com.rjavey.user.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @author: Rjavey
 * @create: 2023-12-17 22:31:45
 **/
@Service
@Slf4j
@AllArgsConstructor(onConstructor_ = {@Lazy})
public class AccountLoginServiceImpl implements LoginService {

    private final UserService userService;
    private final TenantService tenantService;
    private final TenantUserService tenantUserService;

    @PostConstruct
    public void init() {
        LoginStrategyRegistry.register(LoginType.Account.getCode(), this);
    }

    @Override
    public Result<UserLoginInfoVO> login(LoginCommand command, HttpServletResponse response) {

        // 查询用户账号
        User user = userService.getById(new LambdaQueryWrapper<User>()
                .eq(User::getUsername,command.getUsername())
                .eq(User::getUserStatus, UserStatus.NORMAL.name()));

        // 比对密码信息
        if (!Objects.equals(SecureUtil.md5(command.getPassword()),user.getPassword())){
            throw new UnauthorizedException("账号或密码错误");
        }

        Tenant tenant = tenantService.getOne(new LambdaQueryWrapper<Tenant>().eq(Tenant::getTenantUsername,command.getTenantAccount()));
        // todo 查询租户信息
        TenantUser tenantUser = tenantUserService.getOne(new LambdaQueryWrapper<TenantUser>()
                .eq(TenantUser::getTenantId,tenant.getId())
                .eq(TenantUser::getUserId,user.getId()));


        // 创建jwt
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

        // 查询权限信息


        return Result.success(info);
    }
}
