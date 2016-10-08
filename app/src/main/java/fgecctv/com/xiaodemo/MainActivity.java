package fgecctv.com.xiaodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;

import fgecctv.com.module.remote.HttpManager;
import fgecctv.com.module.remote.HttpOnNextListener;
import fgecctv.com.module.remote.HttpSubscriber;
import fgecctv.com.module.remote.response.Device;
import fgecctv.com.xiaodemo.entity.DeviceEntity;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.activity_main);
        HttpManager.getInstance(this).dealHttp(new DeviceEntity("1", "1", "1", new HttpSubscriber(mListener, this)));
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    HttpOnNextListener<String> mListener = new HttpOnNextListener<String>() {
        @Override
        public void onNext(String s) {
            Device device = parseXml(s);
            System.out.println(device.toString());
        }
    };

    private Device parseXml(String s) {
        Device device = null;
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new StringReader(s));
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_DOCUMENT) {
                    device = new Device();
                } else if (eventType == XmlPullParser.START_TAG) {
                    if ("deviceId".equals(xpp.getName())) {
                        device.deviceId = xpp.nextText();
                    } else if ("resultCode".equals(xpp.getName())) {
                        device.resultCode = xpp.nextText();
                    }
                } else if (eventType == XmlPullParser.END_TAG) {
                } else if (eventType == XmlPullParser.TEXT) {
                }
                eventType = xpp.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return device;
    }

}
