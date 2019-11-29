package com.xiaoi.service;

import java.util.Collection;
import java.util.List;

/**
 * @author kevin.zhu
 * @date 2019/11/26 10:48
 */
public interface RedisService {
    public void delete(String key);

    public String get(String key);

    public void set(String key, String value);

    public Long lLeftPushAll(String key, Collection<String> value);

    public Long lLeftPush(String key, String value);

}
