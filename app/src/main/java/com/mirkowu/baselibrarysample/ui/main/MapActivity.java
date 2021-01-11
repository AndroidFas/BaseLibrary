package com.mirkowu.baselibrarysample.ui.main;

import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.mirkowu.baselibrarysample.R;
import com.mirkowu.baselibrarysample.api.RetrofitClient;
import com.mirkowu.baselibrarysample.ui.bean.DashBordBean;
import com.mirkowu.baselibrarysample.ui.bean.JmLogBean;
import com.softgarden.baselibrary.base.BaseActivity;
import com.softgarden.baselibrary.network.RxCallback;
import com.softgarden.baselibrary.utils.RxPermissionsUtil;

import java.util.Iterator;
import java.util.Locale;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MapActivity extends BaseActivity {
    private TextToSpeech mTextToSpeech;
    AMap aMap;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_map;
    }

    private void setKeepScreenOnFlag() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapView mMap = findViewById(R.id.map);
        mMap.onCreate(savedInstanceState);// 此方法必须重写
        aMap = mMap.getMap();
    }

    @Override
    protected void initialize() {
        setOrientationPortrait(false);
        setKeepScreenOnFlag();
        speakChina();
//        mTextToSpeech.speak("这个填你想要转成语音的文字", TextToSpeech.QUEUE_FLUSH, null);
        getData();
    }


    private void speakChina() {
        //设置朗读语言
        mTextToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {

            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    //设置朗读语言
                    int supported = mTextToSpeech.setLanguage(Locale.US);
                    if ((supported != TextToSpeech.LANG_AVAILABLE) && (supported != TextToSpeech.LANG_COUNTRY_AVAILABLE)) {
                        Toast.makeText(MapActivity.this, "不支持当前语言！", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }

    private void getData() {
        RetrofitClient.getCrmApi()
                .getJmLogList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RxCallback<JmLogBean>() {
                    @Override
                    public void onSuccess(@Nullable JmLogBean data) {
//                        adapter.setNewData(data.data);
                        if (!data.code.equals("0"))
                            return;
                        Log.d(TAG, "onSuccess: " + data.data);

//                        String next1 = keys.next();
//                        Log.d(TAG, "onSuccess next1: " + next1);

                        //step1 将所有点置于图内
                        LatLngBounds.Builder boundsBuilder = new LatLngBounds.Builder();//存放所有点的经纬度
//                        for (CircleBean circleBean : circleList) {
//                            boundsBuilder.include(new LatLng(circleBean.circleBusinessBean.latitude, circleBean.circleBusinessBean.longitude));//把所有点都include进去（LatLng类型）
//                        }
                        aMap.animateCamera(CameraUpdateFactory.newLatLngBounds(boundsBuilder.build(), 30));//第二个参数为四周留空宽度

                        //step2 画商家icon

                        //step3 画智工轨迹
                    }
                });

    }
}