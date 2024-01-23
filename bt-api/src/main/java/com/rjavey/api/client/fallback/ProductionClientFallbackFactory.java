package com.rjavey.api.client.fallback;

import com.rjavey.api.client.ProductionClient;
import com.rjavey.common.model.po.production.Product;
import org.springframework.cloud.openfeign.FallbackFactory;

import java.util.ArrayList;
import java.util.List;
//import feign.hystrix.FallbackFactory;

/**
 * @author: Rjavey
 * @create: 2023-12-25 12:13:29
 **/
public class ProductionClientFallbackFactory implements FallbackFactory<ProductionClient> {
    @Override
    public ProductionClient create(Throwable throwable) {
        return new ProductionClient() {
            @Override
            public List<Product> productDetailBySupplier(Long supplierId) {
                return new ArrayList<>();
            }
        };
    }
}
