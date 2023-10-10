package com.rjavey.common.model.command;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author rjavey
 */
@Data
public class UpdateProductionPlan {

    @ApiModelProperty("计划id")
    private Long id;

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


}
