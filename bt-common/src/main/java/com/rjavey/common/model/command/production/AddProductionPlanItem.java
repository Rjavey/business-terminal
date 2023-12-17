package com.rjavey.common.model.command.production;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author rjavey
 */
@Data
public class AddProductionPlanItem {

    /**
     * 计划id
     */
    @ApiModelProperty("计划id")
    private Long planId;

    /**
     * 产品id
     */
    @ApiModelProperty("产品id")
    private Long productId;

    /**
     * 数量
     */
    @ApiModelProperty("数量")
    private Integer num;


    /**
     * 工时
     */
    @ApiModelProperty("工时")
    private Integer manHour;

    /**
     * 流水线id
     */
    @ApiModelProperty("流水线id")
    private Long productionLineId;

    /**
     * 父项目id
     */
    @ApiModelProperty("父项目id")
    private Long parentId;
}
