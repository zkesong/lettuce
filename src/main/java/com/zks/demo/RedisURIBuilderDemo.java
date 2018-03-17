package com.zks.demo;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import io.lettuce.core.protocol.RedisCommand;

/**
 * @author KeSong Zeng
 * @version V1.0
 * @e-mail kesongzeng@163.com
 * @date 2018/3/17 14:56
 * @Description:
 */
public class RedisURIBuilderDemo {
    public static void main(String[] args) {
        RedisURI redisURI = RedisURI.Builder.redis("ip", 6379)
                .withPassword("pwd").withDatabase(0).build();

        RedisClient redisClient = RedisClient.create(redisURI);
        StatefulRedisConnection<String, String> connection = redisClient.connect();

        RedisCommands<String, String> commands = connection.sync();
        String value = commands.get("key");
        System.out.println("key: " + value);

        connection.close();
        redisClient.shutdown();
    }
}
