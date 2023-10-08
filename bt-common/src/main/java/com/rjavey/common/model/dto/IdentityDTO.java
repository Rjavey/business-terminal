package com.rjavey.common.model.dto;

import lombok.Data;

/**
 * 用户当前登录身份信息
 *
 * @author rjavey
 */
@Data
public class IdentityDTO {

    /**
     * 用户id
     */
    private Long id;

    /**
     * 租户id
     */
    private Long tenantId;

//    private Long timestamp;

}
