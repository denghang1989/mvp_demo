package fgecctv.com.module.remote.response;

/**
 * 2016/9/30 10
 * 推荐 栏目
 */
public class Recommend<T> {

    /**
     * action : OPEN_USER_CENTER
     * actionParam : {}
     * descInfo : 个人中心
     * id :
     * image : http://114.247.94.15:8080/epg/image/app_8.png
     * isLiveshow :
     * name :
     * subName :
     */

    public String action;
    public T      t;
    public String descInfo;
    public String id;
    public String image;
    public String isLiveshow;
    public String name;
    public String subName;
}
