package fgecctv.com.xiaodemo.entity;

import java.io.IOException;

import fgecctv.com.module.remote.BaseFunc1;
import fgecctv.com.module.remote.HttpService;
import okhttp3.ResponseBody;
import rx.Observable;
import rx.Subscriber;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.xiaodemo.entity
 * @Description: (用一句话描述该文件做什么)
 * @date 2016/10/5 09
 */
public class DeviceEntity implements BaseFunc1<ResponseBody, String> {
    private String     type;
    private String     recordmode;
    private String     mac;
    private Subscriber mSubscriber;

    public DeviceEntity(String type, String mac, String recordmode, Subscriber subscriber) {
        this.type = type;
        mSubscriber = subscriber;
        this.mac = mac;
        this.recordmode = recordmode;
    }

    @Override
    public Observable getObservable(HttpService method) {
        return method.getDeviceId(type, recordmode, mac);
    }

    @Override
    public Subscriber getSubscriber() {
        return mSubscriber;
    }

    @Override
    public String call(ResponseBody responseBody) {
        try {
            return responseBody.string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
