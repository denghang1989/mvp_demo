package fgecctv.com.module.remote.response;

/**
 * 2016/9/30 10
 * 推荐 栏目
 */
public class Recommend {


    /**
     * action : OPEN_PROGRAM_LIST
     * actionParam : {"select":"强档热播","channelId":"43","groupid":"9"}
     * descInfo : 电视剧
     * id : 00050000000000000000000000019614
     * image : http://images.ott.cibntv.net/pdimage/newall/2016/05/13/17402559822.jpg
     * isLiveshow :
     * name :
     * subName :
     */

    public String      action;
    /**
     * select : 强档热播
     * channelId : 43
     * groupid : 9
     */

    public ActionParam actionParam;
    public String      descInfo;
    public String      id;
    public String      image;
    public String      isLiveshow;
    public String      name;
    public String      subName;

    public static class ActionParam {
        public String select;
        public String channelId;
        public String groupid;
    }
}
