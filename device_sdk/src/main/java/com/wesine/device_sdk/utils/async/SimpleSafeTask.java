package com.wesine.device_sdk.utils.async;

/**
 * Created by doug on 18-3-9.
 * 简单的安全异步任务，仅仅指定返回结果的类型，不可输入参数
 */

public abstract class SimpleSafeTask<T> extends SafeTask<Object, Object, T> {
    protected abstract T doInBackgroundSafely() throws Exception;

    //@Override
    //protected void onPreExecuteSafely() throws Exception {}

    @Override
    protected final T doInBackgroundSafely(Object... params) throws Exception {
        return doInBackgroundSafely();
    }

    //@Override
    //protected void onPostExecuteSafely(T result, Exception e) throws Exception {}
}
