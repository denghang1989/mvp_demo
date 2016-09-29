package fgecctv.com.xiaodemo.demo;

import fgecctv.com.module.remote.BaseEntity;
import fgecctv.com.module.remote.HttpService;
import rx.Observable;
import rx.Subscriber;

/**
 * 2016/9/29 15
 */
public class WeatherEntity extends BaseEntity {

    private String cityName;
    private Subscriber mSubscriber;

    public WeatherEntity(String cityName, Subscriber subscriber) {
        this.cityName = cityName;
        mSubscriber = subscriber;
    }

    @Override
    public Observable getObservable(HttpService method) {
        return method.getWeatherByCityName(cityName);
    }

    @Override
    public Subscriber getSubscriber() {
        return mSubscriber;
    }
}
