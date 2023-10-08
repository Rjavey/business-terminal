package com.rjavey.common.filter;

import com.rjavey.common.model.dto.IdentityDTO;
import com.rjavey.common.utils.HttpRequestUtil;
import com.rjavey.common.utils.ThreadIdentityUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author rjavey
 */
@WebFilter("/**")
public class HeaderFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var request = HttpRequestUtil.getRequest();
        // 用户已通过gateway认证，获取请求头包含认证信息 todo
//        var jwt = JWTUtil.parseToken(request.getHeader(Header.AUTHORIZATION.getValue()));
//        IdentityDTO identity = (IdentityDTO) jwt.getPayload(JwtPayloadEnum.IDENTITY.name());

        IdentityDTO id = new IdentityDTO();
        id.setId(1L);
        id.setTenantId(1L);
        ThreadIdentityUtil.set(id);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
