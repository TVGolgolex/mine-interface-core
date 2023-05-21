package de.pascxl.minecraft.minecore.language;

import java.util.List;

/**
 * Created by Pascal K. on 17.05.2023.
 */
public interface Language {

    String getName();

    String[] getTags();

    boolean isDefault();

    List<MessagePool> getPools();

    MessagePool getPool(String name);

}
