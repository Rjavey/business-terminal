package com.rjavey.common.model.command.production;


import lombok.Data;

import jakarta.validation.constraints.NotNull;

/**
 * 产品关系
 *
 * @author rjavey
 */
@Data
public class AddProductRelation {

    /**
     * 父级id
     */
    @NotNull(message = "请选择父级物料")
    private Long parentId;

    /**
     * 子级id
     */
    @NotNull(message = "请选择子级物料")
    private Long childId;

}