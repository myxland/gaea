package com.caitiezhu.gaea.service.config;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class JedisConfiguration {
    @NacosValue("${spring.redis.host:106.13.44.126}")
    private String host;
    @NacosValue("${spring.redis.port:6379}")
    private Integer port;
    @NacosValue("${spring.redis.password:}")
    private String password;
    @NacosValue("${spring.redis.pool.maxIdle:20}")
    private Integer maxIdle;
    @NacosValue("${spring.redis.pool.maxTotal:500}")
    private Integer maxTotal;
    @NacosValue("${spring.redis.pool.numTestsPerEvictionRun:3}")
    private Integer numTestsPerEvictionRun;
    @NacosValue("${spring.redis.pool.testOnBorrow:true}")
    private Boolean testOnBorrow;
    @NacosValue("${spring.redis.pool.blockWhenExhausted:false}")
    private Boolean blockWhenExhausted;
    @NacosValue("${spring.redis.pool.testOnReturn:false}")
    private Boolean testOnReturn;

    @Bean
    public JedisPool jedisPool() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setNumTestsPerEvictionRun(numTestsPerEvictionRun);
        jedisPoolConfig.setTestOnBorrow(testOnBorrow);
        jedisPoolConfig.setBlockWhenExhausted(blockWhenExhausted);
        jedisPoolConfig.setTestOnReturn(testOnReturn);

        return new JedisPool(jedisPoolConfig, host, port, 2000, null);
    }
}
