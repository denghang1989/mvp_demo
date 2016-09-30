package fgecctv.com.module.remote.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 2016/9/30 10
 * 影片
 */
public class SearchMovie {

    /**
     * count : 3
     * programSerialList : [{"name":"非诚勿扰 2015","seriesId":"CIBN_6ecf831063e411e4b2ad","type":"综艺"},{"name":"土豪男开20辆豪车求婚非诚女遭拒","seriesId":"000108622693202509109","type":"新闻资讯"},{"name":"非诚勿扰 2016","seriesId":"CIBN_7566f9be9d5011e59e2a","type":"综艺"}]
     */

    public String                        count;
    /**
     * name : 非诚勿扰 2015
     * seriesId : CIBN_6ecf831063e411e4b2ad
     * type : 综艺
     */

    @SerializedName("programSerialList")
    public List<ProgramSerialListEntity> programList;

    public static class ProgramSerialListEntity {
        public String name;
        public String seriesId;
        public String type;
    }
}
