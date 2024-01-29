package com.rjavey.production.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rjavey.common.model.po.production.ProductCateRelation;
import com.rjavey.production.dao.ProductCateRelationMapper;
import com.rjavey.production.service.ProductCateRelationService;
import org.springframework.stereotype.Service;

/**
 * @author rjavey
 * @description 针对表【bt_erp_product_cate_relation(产品分类关系表)】的数据库操作Service实现
 * @createDate 2024-01-29 23:15:00
 */
@Service
public class ProductCateRelationServiceImpl extends ServiceImpl<ProductCateRelationMapper, ProductCateRelation>
        implements ProductCateRelationService {

}
