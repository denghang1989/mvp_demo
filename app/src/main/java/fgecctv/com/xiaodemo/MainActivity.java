package fgecctv.com.xiaodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

import fgecctv.com.module.remote.HttpManager;
import fgecctv.com.module.remote.HttpOnNextListener;
import fgecctv.com.module.remote.HttpSubscriber;
import fgecctv.com.module.remote.response.Recommend;
import fgecctv.com.xiaodemo.entity.CategoryEntity;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;

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
        HttpSubscriber subscriber = new HttpSubscriber(mHttpOnNextListener,this);
        httpManager.dealHttp(new CategoryEntity(subscriber,"4"));
    }

    HttpOnNextListener<List<Recommend>> mHttpOnNextListener = new HttpOnNextListener<List<Recommend>>() {
        @Override
        public void onNext(List<Recommend> recommends) {
            mTextView.setText(recommends.size()+"");
        }
    };


}
