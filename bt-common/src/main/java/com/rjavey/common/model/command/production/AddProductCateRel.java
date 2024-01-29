package com.rjavey.common.model.command.production;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author: Rjavey
 * @create: 2024-01-29 23:21:25
 **/
@Data
@ApiModel("添加产品分类")
public class AddProductCateRel {

    @ApiModelProperty("分类id")
    @NotNull(message = "分类id不可为空")
    private Long cateId;

    @ApiModelProperty("产品id")
    @NotNull(message = "产品id不可为空")
    private Long productId;
}
