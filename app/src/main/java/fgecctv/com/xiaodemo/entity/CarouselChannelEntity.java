package fgecctv.com.xiaodemo.entity;

import fgecctv.com.module.remote.HttpService;
import rx.Observable;
import rx.Subscriber;

/**
 * 2016/9/30 14
 */
public class CarouselChannelEntity extends BaseCIBNEntity {
    private String channelGroupId;

    public CarouselChannelEntity(Subscriber subscriber, String channelGroupId) {
        super(subscriber);
        this.channelGroupId = channelGroupId;
    }

    @Override
    public Observable getObservable(HttpService method) {
        return method.getCarouselChannel(channelGroupId);
    }

    @Override
    public Subscriber getSubscriber() {
        return mSubscriber;
    }
}
