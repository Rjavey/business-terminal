package com.rjavey.production.biz;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;

import com.rjavey.common.model.command.AddSupplier;
import com.rjavey.common.model.po.production.Supplier;
import com.rjavey.common.model.vo.production.SupplierVo;
import com.rjavey.common.model.query.production.SupplierQuery;
import com.rjavey.production.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rjavey.common.result.Result;
import com.rjavey.common.result.PageResult;

/**
 * @author rjavey
 */
@Service
public class SupplierBizImpl implements SupplierBizService {

    @Autowired
    private SupplierService supplierService;

    @Override
    public Result<SupplierVo> add(AddSupplier addSupplier) {

        Supplier data = BeanUtil.copyProperties(addSupplier, Supplier.class);
        // todo 注入用户租户相关信息
        data.setTenantId(IdUtil.getSnowflakeNextId());
        supplierService.save(data);
        var vo = BeanUtil.copyProperties(data, SupplierVo.class);
        return Result.ok(vo);
    }


    @Override
    public PageResult<SupplierVo> page(SupplierQuery query){

        // todo 获取用户租户id
        var tenantId = 1L;

        // supplierService.page(query);


    }


    @Override
    public Result<?> edit(AddSupplier addSupplier) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'edit'");
    }
}
