package com.rjavey.production.controller;

import com.rjavey.common.model.po.production.Product;
import com.rjavey.production.service.ProductService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Rjavey
 * @create: 2024-01-23 22:42:13
 **/
@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
public class ProductApiController {

    private final ProductService productService;

    @ApiOperation(value = "查询物料详情", notes = "查询物料详情，包括物料上下级关系及可提供供应商")
    @GetMapping("/supplier/{supplierId}")
    public List<Product> getProductBySupplier(@PathVariable Long supplierId) {
        return productService.productDetailBySupplier(supplierId);
    }
}
