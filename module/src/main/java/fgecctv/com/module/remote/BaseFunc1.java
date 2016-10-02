package fgecctv.com.module.remote;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * 2016/9/30 15
 */
public interface BaseFunc1<T,R> extends Func1<T,R> {
    Observable getObservable(HttpJsonService method);
    Subscriber getSubscriber();
}
