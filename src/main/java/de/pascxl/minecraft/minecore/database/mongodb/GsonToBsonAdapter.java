package de.pascxl.minecraft.minecore.database.mongodb;

import org.bson.Document;

import java.lang.reflect.Type;

/**
 * Created by P. Kurz on 26.02.2023 (user: Pascal).
 */
public interface GsonToBsonAdapter {

    Document toDocument(Object value);

    <T> T toObjective(Document document, Type type);

    String toString(Object value);

    String toString(Document document);

    Document toDocument(String s);

}