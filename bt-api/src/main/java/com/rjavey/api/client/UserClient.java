package com.rjavey.api.client;

import com.rjavey.api.client.fallback.UserClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "user-service", fallbackFactory = UserClientFallbackFactory.class)
public interface UserClient {


}
