package com.mirkowu.baselibrarysample.ui.main;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.mirkowu.baselibrarysample.R;
import com.mirkowu.baselibrarysample.api.GankNetworkTransformer;
import com.mirkowu.baselibrarysample.api.RetrofitClient;

import com.mirkowu.baselibrarysample.ui.bean.DashBordBean;
import com.softgarden.baselibrary.base.BaseActivity;
import com.softgarden.baselibrary.network.RxCallback;
import com.softgarden.baselibrary.utils.ToastUtil;

import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.autosize.utils.LogUtils;

public class DashBordActivity extends BaseActivity {

//    @BindView(R.id.dash_list)
//    RecyclerView recyclerView;
//    private DashBordAdapter adapter;

    @BindView(R.id.tv_title_11)
    TextView title11;
    @BindView(R.id.tv_title_12)
    TextView title12;
    @BindView(R.id.tv_title_13)
    TextView title13;
    @BindView(R.id.tv_title_21)
    TextView title21;
    @BindView(R.id.tv_title_22)
    TextView title22;
    @BindView(R.id.tv_title_23)
    TextView title23;
    @BindView(R.id.tv_title_31)
    TextView title31;
    @BindView(R.id.tv_title_32)
    TextView title32;
    @BindView(R.id.tv_title_33)
    TextView title33;

    @BindView(R.id.tv_content_11)
    TextView content11;
    @BindView(R.id.tv_content_12)
    TextView content12;
    @BindView(R.id.tv_content_13)
    TextView content13;
    @BindView(R.id.tv_content_21)
    TextView content21;
    @BindView(R.id.tv_content_22)
    TextView content22;
    @BindView(R.id.tv_content_23)
    TextView content23;
    @BindView(R.id.tv_content_31)
    TextView content31;
    @BindView(R.id.tv_content_32)
    TextView content32;
    @BindView(R.id.tv_content_33)
    TextView content33;

    private MediaPlayer mediaPlayer;
    private Integer errStr = null;//异常人数
    private String cCountStr = null;//智工数变化
    private String bCountStr = null;//商家数变化
    private String cFinishStr = null;//完成工作数变化
    private String money = null;//流水变化

    @Override
    protected int getLayoutId() {
        return R.layout.activity_dashbord_2;
    }


    private void setKeepScreenOnFlag() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void initialize() {
//        adapter = new DashBordAdapter(R.layout.item_dashbord);
//        recyclerView.setLayoutManager(new FullyGridLayoutManager(this,3));
//        recyclerView.setAdapter(adapter);
//        ToastUtil.l(title11==null?"null":"no");
        setOrientationPortrait(false);
        setKeepScreenOnFlag();

        getData();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        getData();
                    }
                });

            }
        }, 10000, 10000);
    }

    private void playAudio(String audioName) {
        try {
            //播放 assets/a2.mp3 音乐文件
            AssetFileDescriptor fd = getAssets().openFd(audioName);
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(fd.getFileDescriptor(), fd.getStartOffset(), fd.getLength());
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getData() {
        RetrofitClient.getCrmApi()
                .getData().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RxCallback<DashBordBean>() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onSuccess(@Nullable DashBordBean data) {
//                        adapter.setNewData(data.data);
                        if (!data.code.equals("0"))
                            return;
                        for (int i = 0; i < data.data.size(); i++) {
                            DashBordBean.DataBean bean = data.data.get(i);
                            switch (i) {
                                case 0:
                                    title11 = findViewById(R.id.tv_title_11);
                                    content11 = findViewById(R.id.tv_content_11);
                                    title11.setText(bean.title);
                                    content11.setText(bean.data);
                                    if (null != cCountStr && !cCountStr.equals(bean.data)) {
                                        playAudio("cUp.mp3");
                                    }
                                    cCountStr = bean.data;
                                    break;
                                case 1:
                                    title12 = findViewById(R.id.tv_title_12);
                                    content12 = findViewById(R.id.tv_content_12);
                                    title12.setText(bean.title);
                                    content12.setText(bean.data);
                                    if (null != bCountStr && !bCountStr.equals(bean.data)) {
                                        playAudio("cUp.mp3");
                                    }
                                    bCountStr = bean.data;
                                    break;
                                case 2:
                                    title13 = findViewById(R.id.tv_title_13);
                                    content13 = findViewById(R.id.tv_content_13);
                                    title13.setText(bean.title);
                                    content13.setText(bean.data);
                                    if (null != money && !money.equals(bean.data)) {
                                        playAudio("charge.mp3");
                                    }
                                    money = bean.data;
                                    break;
                                case 3:
                                    title21 = findViewById(R.id.tv_title_21);
                                    content21 = findViewById(R.id.tv_content_21);
                                    title21.setText(bean.title);
                                    content21.setText(bean.data);
                                    break;
                                case 4:
                                    title22 = findViewById(R.id.tv_title_22);
                                    content22 = findViewById(R.id.tv_content_22);
                                    title22.setText(bean.title);
                                    content22.setText(bean.data);
                                    if (bean.data.contains("人")) {
                                        int count = Integer.parseInt(bean.data.split("人")[0]);
                                        if (null != errStr && errStr < count) {
                                            //如果原来的小于查询到的  说明异常增加了
                                            playAudio("err.mp3");
                                        } else if (null != errStr && errStr > count) {
                                            //异常减小了
                                            playAudio("errOut.mp3");
                                        }
                                        errStr = count;
                                    }


                                    break;
                                case 5:
                                    title23 = findViewById(R.id.tv_title_23);
                                    content23 = findViewById(R.id.tv_content_23);
                                    title23.setText(bean.title);
                                    content23.setText(bean.data);
                                    if (null != cFinishStr && !cFinishStr.equals(bean.data)) {
                                        playAudio("finish.mp3");
                                    }
                                    cFinishStr = bean.data;
                                    break;
                                case 6:
                                    title31 = findViewById(R.id.tv_title_31);
                                    content31 = findViewById(R.id.tv_content_31);
                                    title31.setText(bean.title);
                                    content31.setText(bean.data);
                                    break;
                                case 7:
                                    title32 = findViewById(R.id.tv_title_32);
                                    content32 = findViewById(R.id.tv_content_32);
                                    title32.setText(bean.title);
                                    content32.setText(bean.data);
                                    break;
                                case 8:
                                    title33 = findViewById(R.id.tv_title_33);
                                    content33 = findViewById(R.id.tv_content_33);
                                    title33.setText(bean.title);
                                    content33.setText(bean.data);
                                    break;
                            }
                        }
                    }
                });

    }
}
