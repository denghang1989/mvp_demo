package fgecctv.com.module.remote;

import android.content.Context;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 *  2016/9/29 11
 */
public class OkHttpHelper {
    private static OkHttpClient mClient;
    private static final long CONNECT_TIMEOUT = 5000;  // 连接时间
    private static final long READ_TIMEOUT = 5000;  // read超时时间
    private static final long WRITE_TIMEOUT = 5000; // writer超时时间
    private static final int MAX_CACHE_SIZE = 10 * 1024 * 1024; // 缓存文件的大小
    private static final String CACHE_PATH_NAME = "responses";

    public static OkHttpClient createClient(Context context) {
        if (mClient == null) {
            synchronized (OkHttpHelper.class) {
                if (mClient == null) {
                    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                    mClient = new OkHttpClient()
                            .newBuilder()
                            .retryOnConnectionFailure(true)
                            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                            .addInterceptor(interceptor)
                            .addInterceptor(new CacheControl(context))
                            .cache(new Cache(new File(context.getCacheDir(), CACHE_PATH_NAME), MAX_CACHE_SIZE))
                            .build();
                }
            }
        }
        return mClient;
    }

}