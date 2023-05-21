package de.pascxl.minecraft.minecore.stats.config;

import de.pascxl.minecraft.minecore.config.InternalConverter;
import de.pascxl.minecraft.minecore.config.converter.Converter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import java.lang.reflect.ParameterizedType;

public class LocationConverter implements Converter {

    public LocationConverter(InternalConverter internalConverter) {
    }

    @Override
    public Object toConfig(Class<?> aClass, Object o, ParameterizedType parameterizedType) throws Exception {
        Location location = (Location) o;

        return location.getWorld().getName() + ":" + location.getX() + ":" + location.getY() + ":" + location.getZ() +
                ":" + location.getYaw() + ":" + location.getPitch();
    }

    @Override
    public Object fromConfig(Class<?> aClass, Object o, ParameterizedType parameterizedType) throws Exception {
        String locationData = String.valueOf(o);

        String[] split = locationData.split(":");
        if (split.length != 6) {
            return null;
        }

        World world = Bukkit.getWorld(split[0]);
        if (world == null) {
            world = Bukkit.getWorlds().get(0);
        }

        double x = Double.parseDouble(split[1]);
        double y = Double.parseDouble(split[2]);
        double z = Double.parseDouble(split[3]);
        float yaw = Float.parseFloat(split[4]);
        float pitch = Float.parseFloat(split[5]);

        return new Location(world, x, y, z, yaw, pitch);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Location.class.isAssignableFrom(aClass);
    }
}
