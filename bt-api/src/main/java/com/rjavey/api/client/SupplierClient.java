package com.rjavey.api.client;

import com.rjavey.api.client.fallback.SupplierClientFallbackFactory;
import com.rjavey.common.model.po.production.Supplier;
import com.rjavey.common.model.po.production.SupplierProduct;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "bt-supplier", fallbackFactory = SupplierClientFallbackFactory.class)
public interface SupplierClient {

    @GetMapping("/product/{productId}")
    List<Supplier> getSupplierByProduct(@PathVariable Long productId);


    @PostMapping("/api/supplier/supplier_product/save")
    void saveSupplierProduct(@RequestBody List<SupplierProduct> supplierProduct);
}
