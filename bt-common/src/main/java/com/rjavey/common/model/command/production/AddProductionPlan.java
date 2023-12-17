package com.rjavey.common.model.command.production;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author rjavey
 */
@Data
public class AddProductionPlan {


    /**
     *
     */
    @ApiModelProperty("生产计划名称")
    private String planName;

    /**
     * 预计完成时间
     */
    @ApiModelProperty("预计完成时间")
    private LocalDateTime estimatedFinishTime;

    /**
     * 实际完成时间
     */
    @ApiModelProperty("实际完成时间")
    private LocalDateTime actualFinishTime;


    @ApiModelProperty("生产计划项")
    private List<AddProductionPlanItem> items;


}
