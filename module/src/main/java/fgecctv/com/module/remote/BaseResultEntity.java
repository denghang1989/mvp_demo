package fgecctv.com.module.remote;

import com.google.gson.annotations.SerializedName;

/**
 * 2016/9/29 13
 */
public class BaseResultEntity<T> {
    @SerializedName(value = "code", alternate = {"errNum"})
    private int    code;
    @SerializedName(value = "msg", alternate = {"message", "errMsg"})
    private String msg;
    @SerializedName(value = "data", alternate = {"retData","itemList"})
    private T      data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
