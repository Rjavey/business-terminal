package com.rjavey.api.client.fallback;

import com.rjavey.api.client.UserClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;

/**
 * @author: Rjavey
 * @create: 2023-12-25 12:29:31
 **/
@Slf4j
public class UserClientFallbackFactory implements FallbackFactory<UserClient> {
    @Override
    public UserClient create(Throwable throwable) {
        return new UserClient() {

        };
    }
}
