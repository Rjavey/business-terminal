package com.rjavey.production.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rjavey.common.model.po.production.ProductCate;
import com.rjavey.production.dao.ProductCateMapper;
import com.rjavey.production.service.ProductCateService;
import org.springframework.stereotype.Service;

/**
 * @author rjavey
 * @description 针对表【bt_erp_product_cate(产品分类表)】的数据库操作Service实现
 * @createDate 2024-01-29 22:52:24
 */
@Service
public class ProductCateServiceImpl extends ServiceImpl<ProductCateMapper, ProductCate>
        implements ProductCateService {

}




