package de.pascxl.minecraft.minecore.utilities.common;

import org.bson.Document;

/**
 * Created by Pascal K. on 17.05.2023.
 */
public interface MessageUtil {

    String findMessage(Document document, String s);

    String getMessage(String s, Object... objects);

    String convertMessage(Document document, String s1, Object... objects);

}
