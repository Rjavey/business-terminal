package com.rjavey.common.model.po.user;

import com.baomidou.mybatisplus.annotation.TableName;
import com.rjavey.common.model.po.BaseEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * 租户表
 * @TableName bt_tenant
 */
@TableName("bt_tenant")
@Data
public class Tenant extends BaseEntity implements Serializable {


    /**
     * 租户名
     */
    private String tenantName;

    private String tenantUsername;

    private static final long serialVersionUID = 1L;
}