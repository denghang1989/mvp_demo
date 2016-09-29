package fgecctv.com.module.remote;

/**
 * 2016/9/29 13
 */
public class HttpTimeException extends RuntimeException {
    private static final int ONE   = 1;
    private static final int TWO   = 2;
    private static final int THREE = 3;
    private static final int FOUR  = 4;

    public HttpTimeException(int resultCode) {
        this(getApiExceptionMessage(resultCode));
    }

    public HttpTimeException(String message) {
        super(message);
    }


    /**
     * 转换错误数据
     *
     * @param code
     * @return
     */
    private static String getApiExceptionMessage(int code) {
        String message = "";
        switch (code) {
            case ONE:
                message = "无数据";
                break;
            case TWO:
                break;
            case THREE:
                break;
            case FOUR:
                break;
            default:
                message = "error";
                break;

        }
        return message;
    }
}
