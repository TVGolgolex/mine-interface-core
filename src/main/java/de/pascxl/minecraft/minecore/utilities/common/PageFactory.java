package de.pascxl.minecraft.minecore.utilities.common;

import java.util.List;

/**
 * Created by Pascal K. on 17.05.2023.
 */
public interface PageFactory<T> {

    void add(T t);

    int getPageLength();

    List<List<T>> getPages();

    List<T> getPage(int i);

    List<T> getElements();

    boolean isPageExists(int i);

    void clear();

}
