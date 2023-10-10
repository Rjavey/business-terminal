package com.rjavey.common.model.po.production;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.rjavey.common.model.po.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 生产计划表
 *
 * @author rjavey
 * @TableName bt_erp_production_plan
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "bt_erp_production_plan")
@Data
public class ProductionPlan extends BaseEntity implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 所属租户
     */
    private Long tanentId;
    /**
     *
     */
    private String planName;
    /**
     * 状态
     */
    private String status;
    /**
     * 预计完成时间
     */
    private LocalDateTime estimatedFinishTime;
    /**
     * 实际完成时间
     */
    private LocalDateTime actualFinishTime;
    /**
     * 计划进度 0-100
     */
    private Integer schedule;
    /**
     *
     */
    private Long createAt;
    /**
     *
     */
    private Long updateAt;
}