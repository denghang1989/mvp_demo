package fgecctv.com.module.remote;

import rx.Observable;
import rx.Subscriber;

/**
 * 2016/9/29 13
 */
public abstract class BaseEntity<T> implements BaseFunc1<BaseResultEntity<T>, T> {
    public abstract Observable getObservable(HttpService method);

    public abstract Subscriber getSubscriber();

    @Override
    public T call(BaseResultEntity<T> resultEntity) {
        if (resultEntity.getCode() != 0) {
            throw new HttpTimeException(resultEntity.getMsg());
        }
        return resultEntity.getData();
    }
}
