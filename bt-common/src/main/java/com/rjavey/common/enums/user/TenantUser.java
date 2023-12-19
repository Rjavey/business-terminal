package com.rjavey.common.enums.user;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
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