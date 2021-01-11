package com.mirkowu.baselibrarysample.ui.main;

import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.WindowManager;
import android.widget.TextView;

import com.mirkowu.baselibrarysample.R;
import com.mirkowu.baselibrarysample.api.RetrofitClient;
import com.mirkowu.baselibrarysample.ui.bean.DashBordBean;
import com.mirkowu.baselibrarysample.ui.bean.OperationBordBean;
import com.softgarden.baselibrary.base.BaseActivity;
import com.softgarden.baselibrary.network.RxCallback;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class OperationActivity extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_operation;
    }

    private void setKeepScreenOnFlag() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    @Override
    protected void initialize() {
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

    private TextView name11;
    private TextView name12;
    private TextView name13;
    private TextView name21;
    private TextView name22;

    private TextView count12;
    private TextView count13;
    private TextView count22;
    private TextView count23;
    private TextView count32;
    private TextView count33;

    private TextView countrenling;
    private TextView count212;
    private TextView count213;
    private TextView count214;
    private TextView count222;
    private TextView count223;
    private TextView count224;


    private void getData() {
        RetrofitClient.getCrmApi()
                .getOpera().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RxCallback<OperationBordBean>() {
                    @Override
                    public void onSuccess(@Nullable OperationBordBean data) {
//                        adapter.setNewData(data.data);
                        if (!data.code.equals("0"))
                            return;
                        //获取左边
                        List<OperationBordBean.DataBean.Bord1Bean> bord1 = data.data.bord1;
                        for (OperationBordBean.DataBean.Bord1Bean bord1Bean : bord1) {
                            Integer id = bord1Bean.id;
                            String sysUserName = bord1Bean.sysUserName;
                            String countToday = bord1Bean.countToday;
                            String countAll = bord1Bean.countAll;

                            name11 = findViewById(R.id.name11);
                            name12 = findViewById(R.id.name12);
                            name13 = findViewById(R.id.name13);

                            count12 = findViewById(R.id.count12);
                            count13 = findViewById(R.id.count13);
                            count22 = findViewById(R.id.count22);
                            count23 = findViewById(R.id.count23);
                            count32 = findViewById(R.id.count32);
                            count33 = findViewById(R.id.count33);
                            if (id == 1) {
                                name11.setText(sysUserName);
                                count12.setText(countToday);
                                count13.setText(countAll);
                            }
                            if (id == 2) {
                                name12.setText(sysUserName);
                                count22.setText(countToday);
                                count23.setText(countAll);
                            }
                            if (id == 3) {
                                name13.setText(sysUserName);
                                count32.setText(countToday);
                                count33.setText(countAll);
                            }
                        }

//                        获取右边
                        OperationBordBean.DataBean.Bord2Bean bord2 = data.data.bord2;
                        String allNeed = bord2.allNeed;
                        countrenling = findViewById(R.id.countrenling);
                        countrenling.setText(allNeed);
                        for (OperationBordBean.DataBean.Bord2Bean.ListBean listBean : bord2.list) {
                            Integer id = listBean.id;
                            String sysUserName = listBean.sysUserName;
                            String toArrange = listBean.toArrange;
                            String todayArrange = listBean.todayArrange;
                            String allArrange = listBean.allArrange;

                            name21 = findViewById(R.id.name21);
                            name22 = findViewById(R.id.name22);
                            count212 = findViewById(R.id.count212);
                            count213 = findViewById(R.id.count213);
                            count214 = findViewById(R.id.count214);
                            count222 = findViewById(R.id.count222);
                            count223 = findViewById(R.id.count223);
                            count224 = findViewById(R.id.count224);
                            if (id == 4) {
                                name21.setText(sysUserName);
                                count212.setText(toArrange);
                                count213.setText(todayArrange);
                                count214.setText(allArrange);
                            }
                            if (id == 5) {
                                name22.setText(sysUserName);
                                count222.setText(toArrange);
                                count223.setText(todayArrange);
                                count224.setText(allArrange);
                            }
                        }
                    }
                });

    }
}
