package com.rjavey.user.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rjavey.common.model.po.user.Tenant;
import com.rjavey.user.dao.TenantMapper;
import org.springframework.stereotype.Service;

/**
* @author Admin
* @description 针对表【bt_tenant(租户表)】的数据库操作Service实现
* @createDate 2023-12-19 16:35:37
*/
@Service
public class TenantServiceImpl extends ServiceImpl<TenantMapper, Tenant>
    implements TenantService{

}




