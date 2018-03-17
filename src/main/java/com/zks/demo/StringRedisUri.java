package com.zks.demo;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

/**
 * @author KeSong Zeng
 * @version V1.0
 * @e-mail kesongzeng@163.com
 * @date 2018/3/17 14:35
 * @Description:
 */
public class StringRedisUri {
    public static void main(String[] args) {
        RedisClient redisClient = RedisClient.create("redis://pwd@ip:6379/0");
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        RedisCommands<String, String> syncCommands = connection.sync();
        syncCommands.set("key", "hello redis!");

        connection.close();
        redisClient.shutdown();
    }
}
