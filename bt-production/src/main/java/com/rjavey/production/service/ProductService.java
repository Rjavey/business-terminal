package com.rjavey.production.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.rjavey.common.model.po.production.Product;

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

    /**
     * 查询上级物料
     *
     * @param productId
     * @return
     */
    List<Product> getParentProduct(Long productId);

    /**
     * 查询下级物料
     * @param productId
     * @return
     */
    List<Product> getChildProduct(Long productId);


}
