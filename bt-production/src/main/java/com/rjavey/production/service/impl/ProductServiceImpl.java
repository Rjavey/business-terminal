package com.rjavey.production.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rjavey.common.model.po.production.Product;
import com.rjavey.production.dao.ProductMapper;
import com.rjavey.production.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author rjavey
 * @description 针对表【bt_erp_product(物料产品表)】的数据库操作Service实现
 * @createDate 2023-10-06 22:34:18
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
        implements ProductService {

    @Override
    public List<Product> productDetailBySupplier(Long supplierId) {
        return null;
    }

    @Override
    public List<Product> getParentProduct(Long productId) {
        return baseMapper.getParentProducts(productId);
    }

    @Override
    public List<Product> getChildProduct(Long productId) {
        return baseMapper.getChildProducts(productId);
    }
}




