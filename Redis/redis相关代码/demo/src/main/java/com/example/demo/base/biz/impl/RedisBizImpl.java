package com.example.demo.base.biz.impl;

import com.example.demo.base.biz.RedisBiz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * 
 * @author 
 * @date 2022/10/17 22:15
 * @version 1.0
 */
@Service("redisBiz")
public class RedisBizImpl implements RedisBiz {

    private static final Logger log = LoggerFactory.getLogger(RedisBizImpl.class);

    private StringRedisTemplate stringRedisTemplate;

    /**
     * 向Reids中写入数据（写入string类型的数据）
     *
     * @param key
     * @param value
     * @author
     * @date 2022/10/17 22:18
     * @version 1.0
     */
    @Override
    public void saveMsg2Redis(String key, String value) {
        log.info("向Redis中插入数据：key = [{}],value = [{}]", key, value);

    }

    /**
     * 根据key从Redis中获取数据
     *
     * @param key
     * @return redis中保存的value值
     * @author
     * @date 2022/10/17 22:28
     * @version 1.0
     */
    @Override
    public String queryMsgFromRedis(String key) {
        log.info("从Redis中根据key = [{}]获取数据", key);
        return key;
    }


    @Autowired
    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }
}
