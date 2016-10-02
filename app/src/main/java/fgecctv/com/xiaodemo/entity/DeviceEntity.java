package fgecctv.com.xiaodemo.entity;

import fgecctv.com.module.remote.BaseFunc1;
import fgecctv.com.module.remote.HttpJsonService;
import fgecctv.com.module.remote.response.Device;
import rx.Observable;
import rx.Subscriber;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.xiaodemo.entity
 * @Description: (用一句话描述该文件做什么)
 * @date 2016/9/30 21
 */
public class DeviceEntity implements BaseFunc1<Device,Device> {
    private String type;
    private String recordmode;
    private String addr;
    private Subscriber mSubscriber;

    public DeviceEntity(String type, String recordmode, String addr,Subscriber mSubscriber) {
        this.type = type;
        this.recordmode = recordmode;
        this.addr = addr;
        this.mSubscriber = mSubscriber;
    }

    @Override
    public Observable getObservable(HttpJsonService method) {
        return method.getDeviceId(type,recordmode,addr);
    }

    @Override
    public Subscriber getSubscriber() {
        return mSubscriber;
    }

    @Override
    public Device call(Device device) {
        return device;
    }
}
