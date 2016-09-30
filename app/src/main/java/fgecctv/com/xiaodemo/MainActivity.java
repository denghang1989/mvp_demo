package fgecctv.com.xiaodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import fgecctv.com.module.remote.HttpManager;
import fgecctv.com.module.remote.HttpOnNextListener;
import fgecctv.com.module.remote.response.CarouselChannel;
import fgecctv.com.module.remote.response.Device;
import retrofit2.Call;
import retrofit2.Callback;

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

//        HttpSubscriber subscriber = new HttpSubscriber(mHttpOnNextListener,this);
//        httpManager.dealHttp(new CarouselChannelEntity("9",subscriber));


        Call<Device> call = httpManager.getHttpService().getDeviceId("1", "1", "1");
        call.enqueue(new Callback<Device>() {
            @Override
            public void onResponse(Call<Device> call, retrofit2.Response<Device> response) {
                Log.d(TAG, "onResponse: ");
            }

            @Override
            public void onFailure(Call<Device> call, Throwable t) {
                Log.d(TAG, "onFailure: ");
            }
        });

//        OkHttpClient client = OkHttpHelper.createClient(this);
//        Request request = new Request.Builder().get().url("http://cert.ott.cibntv.net/api/auth/?type=1&recordmode=1&addr=mac").build();
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Log.d(TAG, "onFailure: ");
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                Log.d(TAG, "onResponse: "+response.body().string());
//            }
//        });
    }

    HttpOnNextListener<List<CarouselChannel>> mHttpOnNextListener = new HttpOnNextListener<List<CarouselChannel>>() {
        @Override
        public void onNext(List<CarouselChannel> recommends) {
            mTextView.setText(recommends.size()+"");
        }
    };




}
