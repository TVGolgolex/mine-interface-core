package de.pascxl.minecraft.minecore.database.mongodb;

import org.bson.Document;

public interface DocumentSerializer<T> {

    Document serialize( T t );

    T deserialize( Document document );
}
