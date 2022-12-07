package com.samp.common.component.redis;


import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Repository
@Slf4j
public class RedisOperator<T> {

    @Autowired
    @Qualifier("redisObjectTemplate")
    private RedisTemplate<String, T> redisTemplate;

    @Resource(name = "redisObjectTemplate")
    private ValueOperations<String, T> valueOperations;

    @Resource(name = "redisObjectTemplate")
    private ValueOperations<String, List<T>> valueOperationsList;

    public RedisOperator() {

    }

    /**
     * Key Value
     * @param key
     * @return key or null(Error 발생시 null로 리턴)
     */
    public T getValue(String key) {
        try {
            log.debug("RedisOperator getValue --- key: {}", key);
            return valueOperations.get(key);
        } catch (Exception e) {
            log.error("RedisOperator getValue error : {}", e.getMessage());
            return null;
        }
    }

    /**
     * Key List Value
     * @param key
     * @return key or null(Error 발생시 null로 리턴)
     */
    public List<T> getListValue(String key) {
        try {
            log.debug("RedisOperator getListValue --- key: {}", key);
            return valueOperationsList.get(key);
        } catch (Exception e) {
            log.error("RedisOperator getListValue error : {}", e.getMessage());
            return null;
        }
    }

    /**
     * Redis Key Set
     * @param key = redis key name
     * @param value = key에 속한 값
     * @param timeout = redis key 생명 주기 시간 지정
     * @param timeUnit = 시간, 분, 초 단위 설정
     */
    public void set(String key, T value, long timeout, TimeUnit timeUnit) {
        try {
            valueOperations.set(key, value, timeout, timeUnit);
            log.debug("RedisOperator set --- key: {}. key");
        } catch (Exception e) {
            log.error("RedisOperator set error : {}", e.getMessage());
        }
    }

    /**
     * Redis Key List Set
     * @param key = redis key name
     * @param value = key에 속한 값
     * @param timeout = redis key 생명 주기 시간 지정
     * @param timeUnit = 시간, 분, 초 단위 설정
     */
    public void setList(String key, List<T> value, long timeout, TimeUnit timeUnit) {
        try {
            valueOperationsList.set(key, value, timeout, timeUnit);
            log.debug("RedisOperator setList --- key : {}", key);
        } catch (Exception e) {
            log.error("RedisOperator setList error : {}", e.getMessage());
        }
    }

    /**
     * Redis key delete
     * @param key = key delete
     */
    public void delete(String key) {
        try {
            redisTemplate.delete(key);
            log.debug("RedisOperator delete --- key : {}", key);
        } catch (Exception e) {
            log.error("RedisOperator delete error : {}", e.getMessage());
        }
    }
}
