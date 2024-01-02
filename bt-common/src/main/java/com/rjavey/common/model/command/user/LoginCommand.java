package com.rjavey.common.model.command.user;

import com.rjavey.common.annotation.ApiPropertyReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;

/**
 * 登录参数
 *
 * @author: Rjavey
 * @create: 2023-12-17 21:10:57
 **/
@Data
@ApiModel("用户登录参数")
public class LoginCommand {

    @ApiModelProperty("租户账号")
    private String tenantAccount;

    @NotEmpty(message = "登录方式参数错误")
    @ApiModelProperty("登录方式")
    private String loginType;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("手机号")
    private String phoneNumber;

    @ApiModelProperty("验证码")
    private String verifyCode;

}
