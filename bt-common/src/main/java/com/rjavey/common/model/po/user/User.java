package com.rjavey.common.model.po.user;

import com.baomidou.mybatisplus.annotation.TableName;
import com.rjavey.common.model.po.BaseEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户表
 * @TableName bt_user
 */
@TableName("bt_user")
@Data
public class User extends BaseEntity implements Serializable {

    /**
     * 用户名/邮箱
     TableName     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 用户类型
     */
    private String userType;

    /**
     * 用户状态
     */
    private String userStatus;

    /**
     * 性别
     */
    private String gender;

    private static final long serialVersionUID = 1L;
}