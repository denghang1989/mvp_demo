package fgecctv.com.module.remote;

import rx.Observable;
import rx.Subscriber;

/**
 * 2016/9/30 15
 */
public abstract class BaseStringEntity<T> implements BaseFunc1<String,T> {

    public abstract Observable getObservable(HttpService method);

    public abstract Subscriber getSubscriber();

    public abstract T formJson(String s);

    @Override
    public T call(String s) {
        return formJson(s);
    }
}
