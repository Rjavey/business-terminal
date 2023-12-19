package com.rjavey.production.biz;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rjavey.common.exception.ServiceException;
import com.rjavey.common.model.command.production.AddProduct;
import com.rjavey.common.model.command.production.AddProductRelation;
import com.rjavey.common.model.command.production.UpdateProduct;
import com.rjavey.common.model.po.production.Product;
import com.rjavey.common.model.po.production.ProductRelation;
import com.rjavey.common.model.po.production.Supplier;
import com.rjavey.common.model.po.production.SupplierProduct;
import com.rjavey.common.model.query.production.ProductQuery;
import com.rjavey.common.model.vo.production.ProductDetailVo;
import com.rjavey.common.model.vo.production.ProductVo;
import com.rjavey.common.model.vo.production.SupplierVo;
import com.rjavey.common.result.PageResult;
import com.rjavey.common.result.Result;
import com.rjavey.common.utils.CollectionUtils;
import com.rjavey.common.utils.SnowflakeUtil;
import com.rjavey.common.utils.ThreadIdentityUtil;
import com.rjavey.production.service.ProductRelationService;
import com.rjavey.production.service.ProductService;
import com.rjavey.production.service.SupplierProductService;
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

    @Resource
    private SupplierProductService supplierProductService;

    @Resource
    private ProductRelationService productRelationService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<ProductVo> add(AddProduct data) {

        //
        Product product = BeanUtil.copyProperties(data,Product.class);
        product.setId(SnowflakeUtil.getInstance().nextId());
        product.setTenantId(ThreadIdentityUtil.get().getTenantId());
        product.setCreateAt(ThreadIdentityUtil.get().getId());
        product.setUpdateAt(ThreadIdentityUtil.get().getId());
        product.setGmtCreate(LocalDateTime.now());
        product.setGmtUpdate(LocalDateTime.now());
        productService.save(product);

        // 配置供应商信息
        if (!CollectionUtils.isEmpty(data.getSupplierIds())) {
            data.getSupplierIds().parallelStream().forEach(s -> {
                SupplierProduct sp = new SupplierProduct();
                sp.setId(SnowflakeUtil.getInstance().nextId());
                sp.setSupplierId(s);
                sp.setProductId(product.getId());
                supplierProductService.save(sp);
            });
        }


        // 配置父级子级信息 todo
        if (!CollectionUtils.isEmpty(data.getParentIds())) {

        }

        if (!CollectionUtils.isEmpty(data.getChildIds())) {

        }

        return Result.success(BeanUtil.copyProperties(product, ProductVo.class));
    }

    @Override
    public PageResult<ProductVo> page(ProductQuery query) {
        return null;
    }

    @Override
    public Result<ProductVo> edit(UpdateProduct data) {
        Product product = getTenantProduct(data.getId());
        if (product == null) {
            return Result.error("");
        }
        BeanUtil.copyProperties(data, product);
        productService.updateById(product);
        return Result.ok();
    }

    @Override
    public Result<?> remove(List<Long> productIds) {
        productIds.parallelStream().forEachOrdered(productId -> {
            Product product = getTenantProduct(productId);
            if (product == null) {
                throw new ServiceException("参数错误");
            }
            product.setStatus("delete");
            productService.updateById(product);
        });

        return Result.ok();
    }

    @Override
    public Result<ProductDetailVo> detail(Long productId) {
        Product product = getTenantProduct(productId);
        if (product == null) {
            return Result.error("");
        }

        ProductDetailVo detail = BeanUtil.copyProperties(product, ProductDetailVo.class);

        List<Supplier> supplierList = supplierService.supplierDetailByProduct(productId);
        detail.setSuppliers(BeanUtil.copyToList(supplierList, SupplierVo.class));

        // 查询上下级物料
        List<Product> parents = productService.getParentProduct(productId);
        List<Product> childs = productService.getChildProduct(productId);
        detail.setParentProducts(BeanUtil.copyToList(parents, ProductVo.class));
        detail.setChildProducts(BeanUtil.copyToList(childs, ProductVo.class));
        return Result.success(detail);
    }

    @Override
    public Result<?> setProductRelation(AddProductRelation relation) {
        Product parent = getTenantProduct(relation.getParentId());
        Product child = getTenantProduct(relation.getChildId());
        if (parent != null && child != null) {
            productRelationService.save(BeanUtil.copyProperties(relation, ProductRelation.class));
            return Result.ok();
        }

        return Result.error("");
    }

    @Override
    public Result<?> removeProductRelation(AddProductRelation relation) {
        Product parent = getTenantProduct(relation.getParentId());
        Product child = getTenantProduct(relation.getChildId());
        if (parent != null && child != null) {
            productRelationService.remove(new LambdaQueryWrapper<ProductRelation>()
                    .eq(ProductRelation::getParentId, relation.getParentId())
                    .eq(ProductRelation::getChildId, relation.getChildId()));
            return Result.ok();
        }
        return Result.error("");
    }

    private Product getTenantProduct(Long productId) {
        return productService.getOne(new LambdaQueryWrapper<Product>()
//                .eq(Product::getTenantId, ThreadIdentityUtil.get().getTenantId())
                .eq(Product::getTenantId, 1L)
                .eq(Product::getId, productId));
    }
}
