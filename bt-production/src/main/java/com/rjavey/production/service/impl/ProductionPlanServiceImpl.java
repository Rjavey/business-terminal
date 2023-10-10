package com.rjavey.production.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rjavey.common.model.po.production.ProductionPlan;
import com.rjavey.production.dao.ProductionPlanMapper;
import com.rjavey.production.service.ProductionPlanService;
import org.springframework.stereotype.Service;

/**
 * @author rjavey
 * @description 针对表【bt_erp_production_plan(生产计划表)】的数据库操作Service实现
 * @createDate 2023-10-10 22:16:26
 */
@Service
public class ProductionPlanServiceImpl extends ServiceImpl<ProductionPlanMapper, ProductionPlan>
        implements ProductionPlanService {

}




