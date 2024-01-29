package com.rjavey.common.model.command.production;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author: Rjavey
 * @create: 2024-01-29 23:26:53
 **/
@Data
@ApiModel("新增产品分类")
public class AddProductCate {

    @ApiModelProperty("")
    private Long id;

    @ApiModelProperty("分类名称")
    @NotBlank(message = "分类名称不可为空")
    private String cateName;

    @ApiModelProperty("父级id")
    private Long parentId;
}
