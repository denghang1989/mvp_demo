package fgecctv.com.module.remote;

import rx.Observable;
import rx.Subscriber;

/**
 * 2016/9/29 13
 */
public abstract class BaseResultEntity<T> implements BaseFunc1<BaseResult<T>, T> {
    public abstract Observable getObservable(HttpJsonService method);

    public abstract Subscriber getSubscriber();

    @Override
    public T call(BaseResult<T> resultEntity) {
        if (resultEntity.getCode() != 0) {
            throw new HttpTimeException(resultEntity.getMsg());
        }
        return resultEntity.getData();
    }
}
