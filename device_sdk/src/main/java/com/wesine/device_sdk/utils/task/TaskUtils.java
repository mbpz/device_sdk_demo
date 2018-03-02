package com.wesine.device_sdk.utils.task;

import android.os.AsyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * Created by doug on 18-2-27.
 */

public class TaskUtils {
    public static void execute(final Runnable runnable) {
        execute(AsyncTask.THREAD_POOL_EXECUTOR, runnable);
    }

    public static <V> Future<V> submit(final Callable<V> callable) {
        return ((ExecutorService) AsyncTask.THREAD_POOL_EXECUTOR).submit(callable);
    }

    public static void execute(final Executor executor, final Runnable runnable) {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... params) {
                runnable.run();
                return null;
            }
        }.executeOnExecutor(executor);
    }

    public static void execute(final Task task) {
        execute(AsyncTask.THREAD_POOL_EXECUTOR, task);
    }

    public static void execute(final Executor executor, final Task task) {
        task.executeOnExecutor(executor);
    }
}
