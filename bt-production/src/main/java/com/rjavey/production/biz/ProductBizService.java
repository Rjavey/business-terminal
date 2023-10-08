package com.rjavey.production.biz;

import com.rjavey.common.model.command.AddProduct;
import com.rjavey.common.model.query.production.ProductQuery;
import com.rjavey.common.model.vo.production.ProductVo;
import com.rjavey.common.result.PageResult;
import com.rjavey.common.result.Result;

/**
 * @author rj
 * @create 2023/10/8 14:44
 */
public interface ProductBizService {

    /**
     * 新增物料
     * @param data
     * @return
     */
    Result<ProductVo> add(AddProduct data);

    /**
     * 分页查询
     * @param query
     * @return
     */
    PageResult<ProductVo> page(ProductQuery query);

    /**
     * 编辑物料
     * @param data
     * @return
     */
    Result<ProductVo> edit(AddProduct data);

    /**
     * 删除物料
     * @param productId
     * @return
     */
    Result<?> remove(Long productId);
}
