package com.rjavey.production.biz;

import com.rjavey.common.model.command.AddProduct;
import com.rjavey.common.model.command.AddProductRelation;
import com.rjavey.common.model.command.UpdateProduct;
import com.rjavey.common.model.query.production.ProductQuery;
import com.rjavey.common.model.vo.production.ProductDetailVo;
import com.rjavey.common.model.vo.production.ProductVo;
import com.rjavey.common.result.PageResult;
import com.rjavey.common.result.Result;

import java.util.List;

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
    Result<ProductVo> edit(UpdateProduct data);

    /**
     * 删除物料
     * @param productIds
     * @return
     */
    Result<?> remove(List<Long> productIds);

    /**
     * 查询物料产品详情
     *
     * @param productId
     * @return
     */
    Result<ProductDetailVo> detail(Long productId);


    /**
     * 设置物料产品上下级关系
     *
     * @param relation
     * @return
     */
    Result<?> setProductRelation(AddProductRelation relation);

    /**
     * 移除物料关系
     *
     * @param relation
     * @return
     */
    Result<?> removeProductRelation(AddProductRelation relation);
}
