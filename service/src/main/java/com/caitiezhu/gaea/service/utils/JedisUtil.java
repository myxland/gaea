package com.caitiezhu.gaea.service.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;

import javax.annotation.PostConstruct;

@Component
public class JedisUtil {
    @Autowired
    private JedisPool jedisPool;
    private static JedisPool jedisPoolHelper;

    @PostConstruct
    public void init() {
        jedisPoolHelper = jedisPool;
    }

    public static String get(String key) {
        return jedisPoolHelper.getResource().get(key);
    }
}
