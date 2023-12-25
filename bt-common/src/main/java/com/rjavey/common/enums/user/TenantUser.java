package com.rjavey.common.enums.user;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import com.rjavey.common.model.po.BaseEntity;
import lombok.Data;

/**
 * @TableName bt_tenant_user
 */
@TableName(value ="bt_tenant_user")
@Data
public class TenantUser extends BaseEntity implements Serializable {
    private Long id;

    private Long tenantId;

    private Long userId;

    private String status;

    private static final long serialVersionUID = 1L;
}