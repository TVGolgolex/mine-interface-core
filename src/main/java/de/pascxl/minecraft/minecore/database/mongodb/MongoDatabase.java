package de.pascxl.minecraft.minecore.database.mongodb;

import com.mongodb.client.MongoClient;

import java.util.Map;

/**
 * Created by Pascal K. on 17.05.2023.
 */
public interface MongoDatabase {

    Map<String, MongoClient> getConnections();

    GsonToBsonAdapter getGsonToBsonAdapter();

    MongoClient openClientConnection(String id, String string);

    MongoClient getClientConnection(String id);

    MongoClient getOrOpen(String id, String string);

    void terminate();

}
