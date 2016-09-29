package fgecctv.com.module.remote;

import fgecctv.com.module.remote.response.Weather;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 2016/9/29 13
 */
public interface HttpService {
    // 百度天气api 获取天气 手动解析
    @Headers("apikey:cec4e963be2a3073785eeaa9c3aa237f")
    @GET("http://apis.baidu.com/apistore/weatherservice/cityname")
    Observable<BaseResultEntity<Weather>> getWeatherByCityName(@Query("cityname") String cityname);
}
