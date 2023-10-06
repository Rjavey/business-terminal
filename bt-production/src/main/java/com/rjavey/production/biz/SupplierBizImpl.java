package com.rjavey.production.biz;

import cn.hutool.core.bean.BeanUtil;
import com.rjavey.common.model.command.AddSupplier;
import com.rjavey.common.model.po.production.Supplier;
import com.rjavey.common.result.Result;
import com.rjavey.production.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author rjavey
 */
@Service
public class SupplierBizImpl implements SupplierBizService {

    @Autowired
    private SupplierService supplierService;

    @Override
    public Result<?> add(AddSupplier addSupplier) {

        Supplier data = BeanUtil.copyProperties(addSupplier, Supplier.class);
        // todo 注入用户相关信息
        data.setTenantId(1L);
        supplierService.save(data);
        return Result.ok();
    }
}
