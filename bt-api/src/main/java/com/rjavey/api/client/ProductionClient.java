package com.rjavey.api.client;

import com.rjavey.api.client.fallback.ProductionClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author: Rjavey
 * @create: 2023-12-25 12:10:39
 **/
@FeignClient(value = "product-service", fallbackFactory = ProductionClientFallbackFactory.class)
public interface ProductionClient {
}
