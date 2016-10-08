package fgecctv.com.module.remote.response;

/**
 * 2016/9/30 14
 */
public class Device {
    public String deviceId;
    public String resultCode;

    @Override
    public String toString() {
        return "Device{" +
                "deviceId='" + deviceId + '\'' +
                ", resultCode='" + resultCode + '\'' +
                '}';
    }
}
