package fgecctv.com.module.remote;

import fgecctv.com.module.remote.response.Device;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 2016/9/29 13
 */
public interface HttpXmlService {

    @GET("http://cert.ott.cibntv.net/api/auth/?")
    Call<Device> getDeviceId(@Query("type") String type, @Query("recordmode") String recordmode, @Query("addr") String mac);
}
