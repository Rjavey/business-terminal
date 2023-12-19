package com.rjavey.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rjavey.common.enums.user.TenantUser;
import com.rjavey.user.dao.TenantUserMapper;
import com.rjavey.user.service.TenantUserService;
import org.springframework.stereotype.Service;

/**
* @author Admin
* @description 针对表【bt_tenant_user(租户用户表)】的数据库操作Service实现
* @createDate 2023-12-19 20:23:58
*/
@Service
public class TenantUserServiceImpl extends ServiceImpl<TenantUserMapper, TenantUser>
implements TenantUserService {

}
