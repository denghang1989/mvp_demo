package fgecctv.com.xiaodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import fgecctv.com.module.remote.HttpManager;
import fgecctv.com.module.remote.HttpOnNextListener;
import fgecctv.com.module.remote.HttpSubscriber;
import fgecctv.com.xiaodemo.entity.DeviceEntity;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.activity_main);
        HttpManager.getInstance(this).dealHttp(new DeviceEntity("1","1","1",new HttpSubscriber(mListener,this)));
    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    HttpOnNextListener<String> mListener = new HttpOnNextListener<String>() {
        @Override
        public void onNext(String s) {
            Log.d(TAG, "onNext: "+s);
        }
    };

}
