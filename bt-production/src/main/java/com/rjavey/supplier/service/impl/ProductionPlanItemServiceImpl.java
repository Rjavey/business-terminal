package com.rjavey.supplier.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rjavey.common.model.po.production.ProductionPlanItem;
import com.rjavey.supplier.dao.ProductionPlanItemMapper;
import com.rjavey.supplier.service.ProductionPlanItemService;
import org.springframework.stereotype.Service;

/**
 * @author rjavey
 * @description 针对表【bt_erp_production_plan_item(生产计划项目表)】的数据库操作Service实现
 * @createDate 2023-10-10 22:16:26
 */
@Service
public class ProductionPlanItemServiceImpl extends ServiceImpl<ProductionPlanItemMapper, ProductionPlanItem>
        implements ProductionPlanItemService {

}




