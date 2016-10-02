package fgecctv.com.module.remote;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 2016/9/29 11
 */
public class HttpManager {
    public static final  String BASE_URL = "http://s.epg.ott.cibntv.net/epg/web/v40/";
    private static HttpManager     manager;
    private        HttpJsonService mHttpService;
    private        HttpXmlService  mHttpXmlService;

    private HttpManager(Context context) {
        Retrofit retrofit = new Retrofit.Builder().
                client(OkHttpHelper.createClient(context)).
                addCallAdapterFactory(RxJavaCallAdapterFactory.create()).
                addConverterFactory(GsonConverterFactory.create()).
                addConverterFactory(SimpleXmlConverterFactory.create()).
                baseUrl(BASE_URL).
                build();
        mHttpService = retrofit.create(HttpJsonService.class);
    }

    public static HttpManager getInstance(Context context) {
        if (manager == null) {
            synchronized (HttpManager.class) {
                if (manager == null) {
                    manager = new HttpManager(context);
                }
            }
        }
        return manager;
    }

    public HttpJsonService getHttpService() {
        return mHttpService;
    }

    public HttpXmlService createHttpXmlService(Context context) {
        if (mHttpXmlService == null) {
            synchronized (HttpManager.class) {
                if (mHttpXmlService == null) {
                    Retrofit retrofit = new Retrofit.Builder().
                            client(OkHttpHelper.createClient(context)).
                            addCallAdapterFactory(RxJavaCallAdapterFactory.create()).
                            addConverterFactory(SimpleXmlConverterFactory.create()).
                            baseUrl(BASE_URL).
                            build();
                    mHttpXmlService = retrofit.create(HttpXmlService.class);
                }
            }
        }
        return mHttpXmlService;
    }

    /**
     * 处理http的请求
     */
    public <T extends BaseFunc1> void dealHttp(T basePar) {
        Observable observable = basePar.getObservable(mHttpService)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(basePar);
        observable.subscribe(basePar.getSubscriber());
    }


}
