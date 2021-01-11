package com.mirkowu.baselibrarysample.ui.adapter;

import android.view.View;
import android.widget.TextView;

import com.mirkowu.baselibrarysample.R;
import com.mirkowu.baselibrarysample.ui.bean.DashBordBean;
import com.softgarden.baselibrary.base.BaseRVAdapter;
import com.softgarden.baselibrary.base.BaseRVHolder;

public class DashBordAdapter extends BaseRVAdapter<DashBordBean.DataBean> {
    public DashBordAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    public void onBindVH(BaseRVHolder holder, DashBordBean.DataBean data, int position) {
        holder.setText(R.id.tv_title, data.title);
        holder.setText(R.id.tv_content, data.data);
    }
}
