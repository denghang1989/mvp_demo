package fgecctv.com.xiaodemo.demo;

import fgecctv.com.module.remote.HttpService;
import fgecctv.com.module.remote.response.Recommend;
import rx.Observable;
import rx.Subscriber;

/**
 * 2016/9/30 11
 */
public class CategoryEntity extends CIBNEntity<Recommend> {

    private String menuId;
    private Subscriber mSubscriber;

    public CategoryEntity(String menuId, Subscriber subscriber) {
        this.menuId = menuId;
        mSubscriber = subscriber;
    }

    @Override
    public Observable getObservable(HttpService method) {
        return method.getRecommendProgram(TEMPLATEID,menuId);
    }

    @Override
    public Subscriber getSubscriber() {
        return mSubscriber;
    }
}
