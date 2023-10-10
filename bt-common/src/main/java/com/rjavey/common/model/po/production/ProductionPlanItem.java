package com.rjavey.common.model.po.production;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.rjavey.common.model.po.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 生产计划项目表
 *
 * @author rjavey
 * @TableName bt_erp_production_plan_item
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "bt_erp_production_plan_item")
@Data
public class ProductionPlanItem extends BaseEntity implements Serializable {


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 所属租户
     */
    private Long tenantId;
    /**
     * 计划id
     */
    private Long planId;
    /**
     * 状态
     */
    private String status;
    /**
     * 产品id
     */
    private Long productId;
    /**
     * 数量
     */
    private Integer num;
    /**
     * 进度
     */
    private Integer schedule;
    /**
     * 工时
     */
    private Integer manHour;
    /**
     * 流水线id
     */
    private Long productionLineId;
    /**
     * 父项目id
     */
    private Long parentId;
}