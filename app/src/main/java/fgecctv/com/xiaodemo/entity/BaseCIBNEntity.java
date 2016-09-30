package fgecctv.com.xiaodemo.entity;

import fgecctv.com.module.remote.BaseResultEntity;
import rx.Subscriber;

/**
 * 2016/9/30 11
 */
public abstract class BaseCIBNEntity<T> extends BaseResultEntity<T> {
    protected static final String TEMPLATEID = "00080000000000000000000000000050";
    protected Subscriber mSubscriber;

    public BaseCIBNEntity(Subscriber subscriber) {
        mSubscriber = subscriber;
    }
}
