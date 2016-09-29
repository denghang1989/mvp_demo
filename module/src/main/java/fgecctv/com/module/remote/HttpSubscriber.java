package fgecctv.com.module.remote;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.net.ConnectException;
import java.net.SocketTimeoutException;

import rx.Subscriber;

/**
 * 2016/9/29 15
 */
public class HttpSubscriber<T> extends Subscriber<T> {
    private HttpOnNextListener     mSubscriberOnNextListener;
    private WeakReference<Context> mActivity;

    public HttpSubscriber(HttpOnNextListener mSubscriberOnNextListener, Context context) {
        this.mSubscriberOnNextListener = mSubscriberOnNextListener;
        this.mActivity = new WeakReference<>(context);
    }

    @Override
    public void onStart() {
        if (mSubscriberOnNextListener != null) {
            mSubscriberOnNextListener.onStart();
        }
    }

    @Override
    public void onCompleted() {
        if (mSubscriberOnNextListener != null) {
            mSubscriberOnNextListener.onFinish();
        }
    }

    @Override
    public void onError(Throwable e) {
        Context context = mActivity.get();
        if (context == null)
            return;
        if (e instanceof SocketTimeoutException) {
            Toast.makeText(context, "网络中断，请检查您的网络状态", Toast.LENGTH_SHORT).show();
        } else if (e instanceof ConnectException) {
            Toast.makeText(context, "网络中断，请检查您的网络状态", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "错误" + e.getMessage(), Toast.LENGTH_SHORT).show();
            Log.i("tag", "error----------->" + e.toString());
        }
    }

    @Override
    public void onNext(T t) {
        if (mSubscriberOnNextListener != null) {
            mSubscriberOnNextListener.onNext(t);
        }
    }

    /**
     * 取消http的请求
     */
    public void onCancel() {
        if (this.isUnsubscribed()) {
            this.unsubscribe();
        }
    }
}
