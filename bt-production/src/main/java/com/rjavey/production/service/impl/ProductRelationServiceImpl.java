package com.rjavey.production.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rjavey.common.model.po.production.ProductRelation;
import com.rjavey.production.dao.ProductRelationMapper;
import com.rjavey.production.service.ProductRelationService;
import org.springframework.stereotype.Service;

/**
 * @author rjavey
 * @description 针对表【bt_erp_product_relation(产品关系表)】的数据库操作Service实现
 * @createDate 2023-10-09 22:30:54
 */
@Service
public class ProductRelationServiceImpl extends ServiceImpl<ProductRelationMapper, ProductRelation>
        implements ProductRelationService {

}




