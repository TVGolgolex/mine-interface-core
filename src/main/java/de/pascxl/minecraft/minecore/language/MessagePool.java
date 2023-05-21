package de.pascxl.minecraft.minecore.language;

import java.util.ArrayList;

public interface MessagePool {

    String getPoolMame();

    ArrayList<LanguageContent> getContents();

    String getRawContent(String key);

}
