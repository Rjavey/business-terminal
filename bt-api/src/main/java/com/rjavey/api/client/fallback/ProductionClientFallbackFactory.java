package com.rjavey.api.client.fallback;

import com.rjavey.api.client.ProductionClient;
import feign.hystrix.FallbackFactory;

/**
 * @author: Rjavey
 * @create: 2023-12-25 12:13:29
 **/
public class ProductionClientFallbackFactory implements FallbackFactory<ProductionClient> {
    @Override
    public ProductionClient create(Throwable throwable) {
        return new ProductionClient() {
        };
    }
}
