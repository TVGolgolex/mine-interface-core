package de.pascxl.minecraft.minecore.brand;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Pascal K. on 17.05.2023.
 */
public interface Brand {

    String getName();

    String getTopLevelDomain();

    List<String> getTags();

    HashMap<String, String> getSocialMedias();

    String getFullDomain();

    String getHexColoring();

    String getAltColoring();

    boolean isDefault();

}
