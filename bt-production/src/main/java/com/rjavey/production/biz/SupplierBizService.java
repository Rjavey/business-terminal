package com.rjavey.production.biz;

import com.rjavey.common.model.command.AddSupplier;
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
    Result<?> add(AddSupplier addSupplier);
}
