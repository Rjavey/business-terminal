package com.rjavey.common.model.command.production;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author: Rjavey
 * @create: 2024-01-29 23:26:53
 **/
@Data
@ApiModel("修改产品分类")
public class ModifyProductCate extends AddProductCate {

    @ApiModelProperty("产品分类id")
    @NotNull(message = "分类id不可为空")
    private Long id;
}
