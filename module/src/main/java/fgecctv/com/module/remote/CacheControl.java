package fgecctv.com.module.remote;

import android.content.Context;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * 2016/9/29 11
 */
public class CacheControl implements Interceptor {
    private static final String CACHE_CONTROL = "Cache-Control";
    private Context mContext;

    public CacheControl(Context context) {
        this.mContext = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());
        if (NetWorkUtil.isNetWorkAvailable(mContext)) {
            int maxAge = 60; // 在线缓存在1分钟内可读取
            return originalResponse.newBuilder()
                    .removeHeader("Pragma")
                    .removeHeader(CACHE_CONTROL)
                    .header(CACHE_CONTROL, "public, max-age=" + maxAge)
                    .build();
        } else {
            int maxStale = 60 * 60 * 24 * 28; // 离线时缓存保存4周
            return originalResponse.newBuilder()
                    .removeHeader("Pragma")
                    .removeHeader(CACHE_CONTROL)
                    .header(CACHE_CONTROL, "public, only-if-cached, max-stale=" + maxStale)
                    .build();
        }
    }
}