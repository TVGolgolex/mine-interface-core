package de.pascxl.minecraft.minecore.utilities.cloud;

import eu.cloudnetservice.driver.event.Event;
import lombok.NonNull;

/**
 * Created by Pascal K. on 18.05.2023.
 */
public interface CloudUtil {

    @NonNull CloudUtil unregisterListeners(@NonNull ClassLoader var1);

    @NonNull CloudUtil unregisterListener(@NonNull Object... var1);

    default <T extends Event> @NonNull T callEvent(@NonNull T event) {
        if (event == null) {
            throw new NullPointerException("event is marked non-null but is null");
        } else {
            return this.callEvent("*", event);
        }
    }

    <T extends Event> @NonNull T callEvent(@NonNull String var1, @NonNull T var2);

    @NonNull CloudUtil registerListener(@NonNull Class<?> var1);

    @NonNull CloudUtil registerListener(@NonNull Object var1);

    default @NonNull CloudUtil registerListeners(@NonNull Object... listeners) {
        if (listeners == null) {
            throw new NullPointerException("listeners is marked non-null but is null");
        } else {
            Object[] var2 = listeners;
            int var3 = listeners.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                Object listener = var2[var4];
                this.registerListener(listener);
            }

            return this;
        }
    }

}
