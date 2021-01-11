package com.mirkowu.baselibrarysample.api;

import com.mirkowu.baselibrarysample.bean.ImageBean;
import com.mirkowu.baselibrarysample.ui.bean.DashBordBean;
import com.mirkowu.baselibrarysample.ui.bean.JmLogBean;
import com.mirkowu.baselibrarysample.ui.bean.OperationBordBean;
import com.softgarden.baselibrary.network.BaseBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.POST;

public interface BaoCrmApi {
    //接口有参数时 要写上该注解
    // @FormUrlEncoded
    @POST(HostUrl.DASH_BORD)
    Observable<DashBordBean> getData(/*@Field("is_new") int is_new*/);

    @POST(HostUrl.OPERA_DASH_BORD)
    Observable<OperationBordBean> getOpera(/*@Field("is_new") int is_new*/);

    @POST(HostUrl.getWorkingB)
    Observable<String> getJmLogList(/*@Field("is_new") int is_new*/);
}
