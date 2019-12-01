package com.xiaoi.service;

import java.util.List;

/**
 * @author kevin.zhu
 * @date 2019/11/29 18:08
 */
public interface RedisLockService {

    public boolean lockByScript(List<String> keys, Object... argv);

}
