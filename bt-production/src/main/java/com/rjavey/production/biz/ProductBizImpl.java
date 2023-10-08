package com.rjavey.production.biz;

import cn.hutool.core.bean.BeanUtil;
import com.rjavey.common.model.command.AddProduct;
import com.rjavey.common.model.po.production.Product;
import com.rjavey.common.model.query.production.ProductQuery;
import com.rjavey.common.model.vo.production.ProductVo;
import com.rjavey.common.result.PageResult;
import com.rjavey.common.result.Result;
import com.rjavey.production.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author rj
 * @create 2023/10/8 14:54
 */
@Service
@Slf4j
public class ProductBizImpl implements ProductBizService{

    @Resource
    private ProductService productService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<ProductVo> add(AddProduct data) {

        //
        Product product = BeanUtil.copyProperties(data,Product.class);
        product.setTenantId(1L);
        product.setCreateAt(1L);
        product.setUpdateAt(1L);
        product.setGmtCreate(LocalDateTime.now());
        product.setGmtUpdate(LocalDateTime.now());
        productService.save(product);

        // 配置供应商信息 todo

        // 配置父级子级信息 todo
        return null;
    }

    @Override
    public PageResult<ProductVo> page(ProductQuery query) {
        return null;
    }

    @Override
    public Result<ProductVo> edit(AddProduct data) {
        return null;
    }

    @Override
    public Result<?> remove(Long productId) {
        return null;
    }
}
