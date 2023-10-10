package com.rjavey.common.model.query.production;

import com.rjavey.common.model.query.KeywordQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author rjavey
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductionPlanQuery extends KeywordQuery {

    /**
     * 计划名称
     */
    @ApiModelProperty("计划名称")
    private String planName;
    /**
     * 计划状态
     */
    @ApiModelProperty(value = "计划状态", notes = "初始状态 wait/待开始 start/开始 finish/完成 overtime/超时 stop/中止 cancel/取消")
    private String status;


}