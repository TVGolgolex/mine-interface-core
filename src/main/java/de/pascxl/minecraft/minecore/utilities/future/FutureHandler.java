package de.pascxl.minecraft.minecore.utilities.future;

public interface FutureHandler<E> {

    void onPreExecute(E e);

    void onCompleted(E e);

}