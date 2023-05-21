package de.pascxl.minecraft.minecore.brand;

import de.pascxl.minecraft.minecore.utilities.future.FutureHandler;

import java.util.List;

/**
 * Created by Pascal K. on 17.05.2023.
 */
public interface BrandManager {

    List<Brand> getLoadedBrands();

    Brand getDefaultBrand();

    void updateDatabase();

    void updateDatabaseAsync(FutureHandler<BrandManager> future);

    void reload();

    void $a();

}
