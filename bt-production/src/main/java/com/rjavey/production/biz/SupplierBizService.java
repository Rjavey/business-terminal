package com.rjavey.production.biz;

import com.rjavey.common.model.command.AddSupplier;
import com.rjavey.common.model.command.UpdateSupplier;
import com.rjavey.common.model.query.production.SupplierQuery;
import com.rjavey.common.model.vo.production.SupplierDetailVo;
import com.rjavey.common.model.vo.production.SupplierVo;
import com.rjavey.common.result.PageResult;
import com.rjavey.common.result.Result;

/**
 * @author rjavey
 */
public interface SupplierBizService {

    /**
     * 添加供应商数据
     *
     * @param addSupplier
     * @return
     */
    Result<SupplierVo> add(AddSupplier addSupplier);


    /**
     * 分页查询供应商数据
     * @param query
     * @return
     */
    PageResult<SupplierVo> page(SupplierQuery query);

    /**
     * 编辑供应商信息
     */
    Result<SupplierVo> edit(UpdateSupplier addSupplier);

    /**
     * 删除供应商数据
     * @param supplierId 供应商id
     * @return
     */
    Result<?> remove(Long supplierId);

    /**
     * 获取供应商详情
     * @param supplierId 供应商id
     * @return
     */
    Result<SupplierDetailVo> detail(Long supplierId);

}
