package com.rjavey.production.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rjavey.common.model.po.production.Supplier;
import com.rjavey.production.dao.SupplierMapper;
import com.rjavey.production.service.SupplierService;
import org.springframework.stereotype.Service;

/**
 * @author rjavey
 * @description 针对表【bt_erp_supplier(供应商表)】的数据库操作Service实现
 * @createDate 2023-10-06 22:34:18
 */
@Service
public class SupplierServiceImpl extends ServiceImpl<SupplierMapper, Supplier>
        implements SupplierService {

}




