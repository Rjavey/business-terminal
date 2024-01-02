package com.rjavey.api.client.fallback;

import com.rjavey.api.client.SupplierClient;
import com.rjavey.common.model.po.production.Supplier;
import com.rjavey.common.model.po.production.SupplierProduct;
//import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;

import java.util.Collections;
import java.util.List;

/**
 * @author: Rjavey
 * @create: 2023-12-25 12:29:31
 **/
@Slf4j
public class SupplierClientFallbackFactory implements FallbackFactory<SupplierClient> {
    @Override
    public SupplierClient create(Throwable throwable) {
        return new SupplierClient() {
            @Override
            public List<Supplier> getSupplierByProduct(Long productId) {
                return Collections.emptyList();
            }

            @Override
            public void saveSupplierProduct(List<SupplierProduct> supplierProduct) {
                log.error("保存供应商可提供产品配置错误：{}", throwable.getMessage(), throwable);
            }
        };
    }
}
