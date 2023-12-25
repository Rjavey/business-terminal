package com.rjavey.supplier.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.rjavey.common.model.po.production.Supplier;

import java.util.List;

/**
 * @author rjavey
 * @description 针对表【bt_erp_supplier(供应商表)】的数据库操作Service
 * @createDate 2023-10-06 22:34:18
 */
public interface SupplierService extends IService<Supplier> {


    /**
     * 根据产品查询供应商
     *
     * @param productId
     * @return
     */
    List<Supplier> supplierDetailByProduct(Long productId);

}
