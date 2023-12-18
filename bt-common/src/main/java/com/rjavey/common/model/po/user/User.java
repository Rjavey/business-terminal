package com.rjavey.common.model.po.user;

import lombok.Data;

/**
 * @author zhangrui
 * @create 2023/12/18 16:41
 */
@Data
public class User {

    private Long id;

    private String username;

    private String password;

    private String phoneNumber;

    private String email;

    private String avatar;

}
