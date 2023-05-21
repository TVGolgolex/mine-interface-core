package de.pascxl.minecraft.minecore.database;

import de.pascxl.minecraft.minecore.database.mongodb.MongoDatabase;
import de.pascxl.minecraft.minecore.database.redis.RedisDatabase;
import de.pascxl.minecraft.minecore.database.sql.SqlDatabase;

/**
 * Created by Pascal K. on 17.05.2023.
 */
public interface DatabaseManager {

    MongoDatabase getMongoDatabase();

    RedisDatabase getRedisDatabase();

    SqlDatabase getSqlDatabase();

}
