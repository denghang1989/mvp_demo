package fgecctv.com.xiaodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import fgecctv.com.module.remote.HttpManager;
import fgecctv.com.module.remote.HttpXmlService;
import fgecctv.com.module.remote.response.Device;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        HttpXmlService httpXmlService = HttpManager.getInstance(this).createHttpXmlService(this);
        httpXmlService.getDeviceId("1","1","1").enqueue(new Callback<Device>() {
            @Override
            public void onResponse(Call<Device> call, Response<Device> response) {
                Log.d(TAG, "onResponse: ");
            }

            @Override
            public void onFailure(Call<Device> call, Throwable t) {
                Log.d(TAG, "onFailure: ");
            }
        });
    }

}
