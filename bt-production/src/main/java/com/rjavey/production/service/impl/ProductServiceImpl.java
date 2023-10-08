package com.rjavey.production.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rjavey.common.model.po.production.Product;
import com.rjavey.common.model.po.production.Supplier;
import com.rjavey.common.model.vo.production.ProductVo;
import com.rjavey.production.dao.ProductMapper;
import com.rjavey.production.dao.SupplierMapper;
import com.rjavey.production.service.ProductService;
import com.rjavey.production.service.SupplierService;
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
}




