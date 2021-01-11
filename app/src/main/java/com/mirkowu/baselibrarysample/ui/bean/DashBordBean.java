package com.mirkowu.baselibrarysample.ui.bean;

import java.util.List;

public class DashBordBean {

    /**
     * code : 0
     * msg : 请求成功
     * data : [{"data":"1033人","title":"总智工"},{"data":"275家","title":"总商家"},{"data":"171295.95元","title":"总流水"},{"data":"14人","title":"今日智工"},{"data":"0人次","title":"今日异常"},{"data":"0人次","title":"今日完成"},{"data":"4人","title":"正在工作"},{"data":"1243人次","title":"总完成"},{"data":"4651.68小时","title":"总工时"}]
     */

    public String code;
    public String msg;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * data : 1033人
         * title : 总智工
         */

        public String data;
        public String title;
    }
}
