package fgecctv.com.module.remote;

import java.util.List;

import fgecctv.com.module.remote.response.CarouselChannel;
import fgecctv.com.module.remote.response.Device;
import fgecctv.com.module.remote.response.Recommend;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 2016/9/29 13
 */
public interface HttpService {

    @GET("program!getIndexList.action?")
    Observable<BaseResult<List<Recommend>>> getRecommendProgram(@Query("templateId") String templateId, @Query("menuId") String menuId);

    @GET("program!getSearchProgramSerialsId.action")
    Observable<BaseResultEntity<String>> getSearchMovie(@Query("templateId") String templateId,
                                                        @Query("searchValue") String searchValue,
                                                        @Query("pageNumber") String pageNumber,
                                                        @Query("pageSize") String pageSize);

    @GET("http://play.live.ott.cibntv.net:8080/broadcast/getChannelList?")
    Observable<List<CarouselChannel>> getCarouselChannel(@Query("channelGroupId") String channelGroupId);

    @GET("http://cert.ott.cibntv.net/api/auth/?")
    Call<Device> getDeviceId(@Query("type") String type, @Query("recordmode") String recordmode, @Query("addr") String mac);
}
