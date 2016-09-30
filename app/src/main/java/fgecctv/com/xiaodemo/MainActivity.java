package fgecctv.com.xiaodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

import fgecctv.com.module.remote.HttpManager;
import fgecctv.com.module.remote.HttpOnNextListener;
import fgecctv.com.module.remote.HttpSubscriber;
import fgecctv.com.module.remote.response.CarouselChannel;
import fgecctv.com.xiaodemo.entity.CarouselChannelEntity;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        HttpManager httpManager = HttpManager.getInstance(this);

/*        HttpSubscriber subscriber = new HttpSubscriber(mHttpOnNextListener,this);
        httpManager.dealHttp(new CategoryEntity(subscriber,"4"));*/

        /*HttpSubscriber subscriber = new HttpSubscriber(mHttpOnNextListener,this);
        httpManager.dealHttp(new CarouselChannelEntity("9",subscriber));*/

        HttpSubscriber subscriber = new HttpSubscriber(mHttpOnNextListener,this);
        httpManager.dealHttp(new CarouselChannelEntity("9",subscriber));
    }

    HttpOnNextListener<List<CarouselChannel>> mHttpOnNextListener = new HttpOnNextListener<List<CarouselChannel>>() {
        @Override
        public void onNext(List<CarouselChannel> recommends) {
            mTextView.setText(recommends.size()+"");
        }
    };




}
