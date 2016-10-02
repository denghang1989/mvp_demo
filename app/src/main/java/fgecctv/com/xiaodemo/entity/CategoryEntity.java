package fgecctv.com.xiaodemo.entity;

import java.util.List;

import fgecctv.com.module.remote.HttpJsonService;
import fgecctv.com.module.remote.response.Recommend;
import rx.Observable;
import rx.Subscriber;

/**
 * 2016/9/30 11
 */
public class CategoryEntity extends BaseCIBNEntity<List<Recommend>> {

    private String     menuId;

    public CategoryEntity(Subscriber subscriber, String menuId) {
        super(subscriber);
        this.menuId = menuId;
    }

    @Override
    public Observable getObservable(HttpJsonService method) {
        return method.getRecommendProgram(TEMPLATEID,menuId);
    }

    @Override
    public Subscriber getSubscriber() {
        return mSubscriber;
    }
}
