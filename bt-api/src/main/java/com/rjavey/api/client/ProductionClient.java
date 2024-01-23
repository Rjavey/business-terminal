package com.rjavey.api.client;

import com.rjavey.api.client.fallback.ProductionClientFallbackFactory;
import com.rjavey.common.model.po.production.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author: Rjavey
 * @create: 2023-12-25 12:10:39
 **/
@FeignClient(value = "bt-production", fallbackFactory = ProductionClientFallbackFactory.class)
public interface ProductionClient {

    @GetMapping("/api/product/supplier/{supplierId}")
    List<Product> productDetailBySupplier(@PathVariable Long supplierId);
}
