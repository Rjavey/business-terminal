package com.rjavey.common.model.vo.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: Rjavey
 * @create: 2023-12-17 21:50:39
 **/
@Data
@ApiModel("用户登录信息返回")
public class UserLoginInfoVO {

    @ApiModelProperty("商户名称")
    private String bName;

    @ApiModelProperty("商户logo")
    private String bAvatar;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("头像")
    private String avatar;


}
