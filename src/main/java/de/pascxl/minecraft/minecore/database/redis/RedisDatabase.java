package de.pascxl.minecraft.minecore.database.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by Pascal K. on 17.05.2023.
 */
public interface RedisDatabase {

    Jedis getJedis();

    JedisPool getJedisPool();

}
