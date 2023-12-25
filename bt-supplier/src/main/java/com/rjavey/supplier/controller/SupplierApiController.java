package com.rjavey.supplier.controller;

import com.rjavey.common.model.po.production.Supplier;
import com.rjavey.common.model.po.production.SupplierProduct;
import com.rjavey.supplier.service.SupplierProductService;
import com.rjavey.supplier.service.SupplierService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Rjavey
 * @create: 2023-12-25 12:24:59
 **/
@Api(tags = "供应商api管理")
@RestController
@AllArgsConstructor
@RequestMapping("/api/supplier")
public class SupplierApiController {

    private final SupplierService supplierService;
    private final SupplierProductService supplierProductService;

    @ApiOperation("根据产品查询可提供供应商")
    @GetMapping("/product/{productId}")
    public List<Supplier> getSupplierByProduct(@PathVariable Long productId) {
        return supplierService.supplierDetailByProduct(productId);
    }

    @ApiOperation("保存供应商产品配置")
    @PostMapping("/supplier-product/save")
    public void saveSupplierProduct(@RequestBody List<SupplierProduct> supplierProduct) {
        supplierProductService.saveBatch(supplierProduct);
    }
}
