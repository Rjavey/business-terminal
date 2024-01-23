package com.rjavey.production.controller;

import com.rjavey.api.client.SupplierClient;
import com.rjavey.common.model.command.production.AddProduct;
import com.rjavey.common.model.command.production.AddProductRelation;
import com.rjavey.common.model.command.production.DeleteIds;
import com.rjavey.common.model.command.production.UpdateProduct;
import com.rjavey.common.model.po.production.Product;
import com.rjavey.common.model.po.production.SupplierProduct;
import com.rjavey.common.model.query.production.ProductQuery;
import com.rjavey.common.model.vo.production.ProductDetailVo;
import com.rjavey.common.model.vo.production.ProductVo;
import com.rjavey.common.result.PageResult;
import com.rjavey.common.result.Result;
import com.rjavey.common.utils.SnowflakeUtil;
import com.rjavey.production.biz.ProductBizService;
import com.rjavey.production.service.ProductService;
import io.seata.spring.annotation.GlobalTransactional;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * @author rjavey
 */
@Api(tags = "物料产品管理")
@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    private final ProductBizService bizService;
    private final ProductService productService;
    private final SupplierClient supplierClient;

    @ApiOperation(value = "分页查询物料", notes = "分页查询物料")
    @PostMapping("/page")
    public PageResult<ProductVo> get(@RequestBody ProductQuery query){
        return bizService.page(query);
    }

    @ApiOperation(value = "添加物料", notes = "添加物料")
    @PostMapping("/")
    public Result<ProductVo> add(@RequestBody @Valid AddProduct data) {
        return bizService.add(data);
    }

    @ApiOperation(value = "编辑物料", notes = "编辑物料")
    @PutMapping("/")
    public Result<ProductVo> edit(@RequestBody @Valid UpdateProduct data) {
        return bizService.edit(data);
    }

    @ApiOperation(value = "删除物料", notes = "删除物料")
    @DeleteMapping("/{id}")
    public Result<?> remove(@RequestBody @Valid DeleteIds ids) {
        return bizService.remove(ids.getIds());
    }

    @ApiOperation(value = "查询物料详情", notes = "查询物料详情，包括物料上下级关系及可提供供应商")
    @GetMapping("/{id}")
    public Result<ProductDetailVo> detail(@PathVariable Long id) {
        return bizService.detail(id);
    }

    @PutMapping("/set_relation")
    @ApiOperation(value = "绑定物料产品的上下级关系", notes = "绑定物料产品的上下级关系")
    public Result<?> setProductRelation(@RequestBody @Valid AddProductRelation relation) {
        return bizService.setProductRelation(relation);
    }

    @DeleteMapping("/remove_relation")
    @ApiOperation(value = "移除物料产品关系")
    public Result<?> removeProductRelation(@RequestBody @Valid AddProductRelation relation) {
        return bizService.removeProductRelation(relation);
    }

    @GlobalTransactional
    @PostMapping("/test_seata")
    public Result<?> testSeata() {

        Product product = new Product();
        product.setId(SnowflakeUtil.nextId());
        product.setProductName("123123");
        product.setProductType("finished");
        productService.save(product);

        SupplierProduct sp = new SupplierProduct();
        sp.setId(SnowflakeUtil.nextId());
        sp.setProductId(product.getId());
        sp.setSupplierId(SnowflakeUtil.nextId());
        supplierClient.saveSupplierProduct(Arrays.asList(sp));
        return null;
    }

}
