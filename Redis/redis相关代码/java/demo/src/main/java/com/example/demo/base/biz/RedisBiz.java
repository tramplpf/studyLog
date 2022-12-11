package com.example.demo.base.biz;

/**
 * 操作Redis的相关操作
 *
 * @author
 * @date 2022/10/17 22:15
 * @version 1.0
 */
public interface RedisBiz {

    /**
     * 向Reids中写入数据（写入string类型的数据）
     *
     * @param key
     * @param value
     * @author
     * @date 2022/10/17 22:18
     * @version 1.0
     */
    void saveMsg2Redis(String key, String value);

    /**
     * 根据key从Redis中获取数据
     *
     * @param key
     * @return redis中保存的value值
     * @author
     * @date 2022/10/17 22:28
     * @version 1.0
     */
    String queryMsgFromRedis(String key);
}
