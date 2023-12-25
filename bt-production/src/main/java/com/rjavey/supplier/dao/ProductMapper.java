package com.rjavey.supplier.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rjavey.common.model.po.production.Product;

import java.util.List;

/**
 * @author rjavey
 * @description 针对表【bt_erp_product(物料产品表)】的数据库操作Mapper
 * @createDate 2023-10-06 22:34:18
 * @Entity com/rjavye/common/model/po/production.domain.Supplier
 */
public interface ProductMapper extends BaseMapper<Product> {

    List<Product> getParentProducts(Long productId);


    List<Product> getChildProducts(Long productId);

}




