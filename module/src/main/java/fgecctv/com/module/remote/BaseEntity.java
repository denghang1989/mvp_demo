package fgecctv.com.module.remote;

import android.util.Log;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * 2016/9/29 13
 */
public abstract class BaseEntity<T> implements Func1<BaseResultEntity<T>, T> {
    private static final String TAG = "BaseEntity";
    public abstract Observable getObservable(HttpService method);

    public abstract Subscriber getSubscriber();

    @Override
    public T call(BaseResultEntity<T> resultEntity) {
        Log.d(TAG, "call: "+resultEntity.getCode());
        if (resultEntity.getCode() != 0) {
            throw new HttpTimeException(resultEntity.getMsg());
        }
        return resultEntity.getData();
    }
}
