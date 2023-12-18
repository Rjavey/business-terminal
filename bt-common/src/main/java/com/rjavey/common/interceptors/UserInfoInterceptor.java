package com.rjavey.common.interceptors;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.rjavey.common.enums.Header;
import com.rjavey.common.model.dto.IdentityDTO;
import com.rjavey.common.utils.ThreadIdentityUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: Rjavey
 * @create: 2023-12-17 23:06:51
 **/
public class UserInfoInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取用户信息
        String userInfo = request.getHeader(Header.UserInfo.getCode());
        if (StrUtil.isNotBlank(userInfo)) {
            IdentityDTO identity = JSONUtil.toBean(userInfo,IdentityDTO.class);
            ThreadIdentityUtil.set(identity);
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ThreadIdentityUtil.remove();
    }
}
