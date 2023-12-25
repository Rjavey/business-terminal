package com.rjavey.production.biz;

import cn.hutool.core.bean.BeanUtil;
import com.rjavey.common.model.command.production.AddProductionPlan;
import com.rjavey.common.model.po.production.ProductionPlan;
import com.rjavey.common.model.query.production.ProductionPlanQuery;
import com.rjavey.common.result.PageResult;
import com.rjavey.common.result.Result;
import com.rjavey.production.service.ProductionPlanService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhangrui
 * @create 2023/12/25 19:33
 */
@Service
@Slf4j
@AllArgsConstructor(onConstructor_ = {@Lazy})
public class ProductionPlanBizServiceImpl implements ProductionPlanBizService{

    private final ProductionPlanService planService;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<?> addPlan(AddProductionPlan productionPlan) {

        ProductionPlan plan = BeanUtil.copyProperties(productionPlan,ProductionPlan.class);
        planService.save(plan);


        return null;
    }

    @Override
    public Result<?> editPlan(AddProductionPlan productionPlan) {
        return null;
    }

    @Override
    public PageResult<?> page(ProductionPlanQuery page) {
        return null;
    }
}
