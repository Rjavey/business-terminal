package com.rjavey.production.biz;

import com.rjavey.common.model.command.AddSupplier;
import com.rjavey.common.model.vo.production.SupplierVo;
import com.rjavey.common.model.query.production.SupplierQuery;
import com.rjavey.common.result.Result;
import com.rjavey.common.result.PageResult;

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
     * @param addSupplier
     * @return
     */
    PageResult<SupplierVo> page(SupplierQuery query);

    /**
     * 编辑供应商信息
     */
    Result<?> edit(AddSupplier addSupplier);

}
