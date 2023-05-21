package de.pascxl.minecraft.minecore.database.mongodb;

import com.google.common.util.concurrent.FutureCallback;

public interface Callback<V> extends FutureCallback<V> {
    @Override
    void onSuccess(V v);

    @Override
    default void onFailure(Throwable throwable) {
        throwable.printStackTrace();
    }
}
