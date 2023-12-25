package com.rjavey.supplier.biz;

import com.rjavey.common.model.command.production.AddProductionPlan;
import com.rjavey.common.model.query.production.ProductionPlanQuery;
import com.rjavey.common.result.PageResult;
import com.rjavey.common.result.Result;

/**
 * @author rjavey
 */
public interface ProductionPlanService {

    /**
     * 创建生产计划
     *
     * @param productionPlan
     * @return
     */
    Result<?> addPlan(AddProductionPlan productionPlan);

    /**
     * 修改生产计划（不支持修改生产计划项）
     *
     * @param productionPlan
     * @return
     */
    Result<?> editPlan(AddProductionPlan productionPlan);

    /**
     * 分页查询生产计划
     *
     * @return
     */
    PageResult<?> page(ProductionPlanQuery page);


}
