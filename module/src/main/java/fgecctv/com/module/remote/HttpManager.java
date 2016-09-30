package fgecctv.com.module.remote;

import android.content.Context;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 2016/9/29 11
 */
public class HttpManager {
    private static final String TAG      = "HttpManager";
    public static final  String BASE_URL = "http://s.epg.ott.cibntv.net/epg/web/v40/";
    private static HttpManager manager;
    private        HttpService mHttpService;

    private HttpManager(Context context) {
        OkHttpClient client = OkHttpHelper.createClient(context);
        Retrofit retrofit = new Retrofit.Builder().
                client(client).
                addCallAdapterFactory(RxJavaCallAdapterFactory.create()).
                addConverterFactory(GsonConverterFactory.create()).
                baseUrl(BASE_URL).
                build();
        mHttpService = retrofit.create(HttpService.class);
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

    public HttpService getHttpService() {
        return mHttpService;
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

//    /**
//     * 处理http的请求
//     */
//    public void dealHttp(BaseEntity basePar){
//        Observable observable = basePar.getObservable(mHttpService)
//                .subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .map(basePar);
//        observable.subscribe(basePar.getSubscriber());
//    }

}
