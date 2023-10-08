package com.rjavey.production.biz;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rjavey.common.model.command.AddProduct;
import com.rjavey.common.model.command.UpdateProduct;
import com.rjavey.common.model.po.production.Product;
import com.rjavey.common.model.po.production.Supplier;
import com.rjavey.common.model.query.production.ProductQuery;
import com.rjavey.common.model.vo.production.ProductDetailVo;
import com.rjavey.common.model.vo.production.ProductVo;
import com.rjavey.common.model.vo.production.SupplierVo;
import com.rjavey.common.result.PageResult;
import com.rjavey.common.result.Result;
import com.rjavey.common.utils.SnowflakeUtil;
import com.rjavey.production.service.ProductService;
import com.rjavey.production.service.SupplierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author rj
 * @create 2023/10/8 14:54
 */
@Service
@Slf4j
public class ProductBizImpl implements ProductBizService{

    @Resource
    private ProductService productService;
    @Resource
    private SupplierService supplierService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<ProductVo> add(AddProduct data) {

        //
        Product product = BeanUtil.copyProperties(data,Product.class);
        product.setId(SnowflakeUtil.getInstance().nextId());
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
    public Result<ProductVo> edit(UpdateProduct data) {
        var product = getTenantProduct(data.getId());
        if (product == null) {
            return Result.error("");
        }
        BeanUtil.copyProperties(data, product);
        productService.updateById(product);
        return Result.ok();
    }

    @Override
    public Result<?> remove(Long productId) {
        var product = getTenantProduct(productId);
        if (product == null) {
            return Result.error("");
        }
        productService.removeById(productId);
        return Result.ok();
    }

    @Override
    public Result<ProductDetailVo> detail(Long productId) {
        var product = getTenantProduct(productId);
        if (product == null) {
            return Result.error("");
        }

        var detail = BeanUtil.copyProperties(product, ProductDetailVo.class);

        List<Supplier> supplierList = supplierService.supplierDetailByProduct(productId);
        detail.setSuppliers(BeanUtil.copyToList(supplierList, SupplierVo.class));

        return Result.success(detail);
    }

    private Product getTenantProduct(Long productId) {
        return productService.getOne(new LambdaQueryWrapper<Product>()
                // todo 获取用户tenantId
                .eq(Product::getTenantId, 1L)
                .eq(Product::getId, productId));
    }
}
