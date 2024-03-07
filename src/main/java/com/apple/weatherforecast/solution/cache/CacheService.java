package com.apple.weatherforecast.solution.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class CacheService<T> {
    private Cache<String, T> cache;

    @Value("${weather.cache.expiryDuration.minutes}")
    private int expiryDuration;

    public CacheService() {

        cache = CacheBuilder.newBuilder()
                .expireAfterAccess(5, TimeUnit.MINUTES)
                .build();
        log.info("cache is created..");
    }

    public boolean containsKey(String key) {
        if (cache != null) {
            return cache.asMap().containsKey(key);
        }
        return false;
    }

    public T get(String key) {
        return cache.getIfPresent(key);
    }

    public void addKey(String key, T value) {
        if (key != null && value != null) {
            cache.put(key, value);
        }
    }
}
