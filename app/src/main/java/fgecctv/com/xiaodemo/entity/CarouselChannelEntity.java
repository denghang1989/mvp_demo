package fgecctv.com.xiaodemo.entity;

import java.util.List;

import fgecctv.com.module.remote.BaseFunc1;
import fgecctv.com.module.remote.HttpJsonService;
import fgecctv.com.module.remote.response.CarouselChannel;
import rx.Observable;
import rx.Subscriber;

/**
 * 2016/9/30 14
 */
public class CarouselChannelEntity implements BaseFunc1<List<CarouselChannel>,List<CarouselChannel>> {
    private static final String TAG = "Carousel";
    private String channelGroupId;
    private Subscriber mSubscriber;

    public CarouselChannelEntity(String channelGroupId, Subscriber subscriber) {
        this.channelGroupId = channelGroupId;
        mSubscriber = subscriber;
    }

    @Override
    public Observable getObservable(HttpJsonService method) {
        return method.getCarouselChannel(channelGroupId);
    }

    @Override
    public Subscriber getSubscriber() {
        return mSubscriber;
    }

    @Override
    public List<CarouselChannel> call(List<CarouselChannel> carouselChannels) {
        return carouselChannels;
    }
}
