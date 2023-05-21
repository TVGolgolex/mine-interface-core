package de.pascxl.minecraft.minecore.thread;

import com.google.common.util.concurrent.ListeningExecutorService;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by P. Kurz on 27.02.2023 (user: Pascal).
 */
public interface MoreExecutors {

    static Executor getDirectExecutor() {
        return Runnable::run;
    }

    static ListeningExecutorService getAsyncExecutor() {
        return com.google.common.util.concurrent.MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());
    }

}
