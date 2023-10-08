package com.rjavey.production.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.rjavey.common.model.po.production.Product;
import com.rjavey.common.model.po.production.Supplier;
import com.rjavey.common.model.vo.production.ProductVo;

import java.util.List;

/**
 * @author rjavey
 * @description 针对表【bt_erp_product(物料产品表)】的数据库操作Service
 * @createDate 2023-10-06 22:34:18
 */
public interface ProductService extends IService<Product> {

    /**
     * 根据供应商id获取提供产品详情
     * @param supplierId
     * @return
     */
    List<Product> productDetailBySupplier(Long supplierId);


}
