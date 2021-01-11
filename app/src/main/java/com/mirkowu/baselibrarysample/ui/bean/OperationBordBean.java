package com.mirkowu.baselibrarysample.ui.bean;

import java.util.List;


public class OperationBordBean {

    /**
     * code : 0
     * msg : 请求成功
     * data : {"bord2":{"allNeed":"0人","list":[{"sysUserName":"胡观平","toArrange":"43人","allArrange":"20人","id":4,"todayArrange":"10人"},{"sysUserName":"胡少卿","toArrange":"60人","allArrange":"4人","id":5,"todayArrange":"3人"},{"sysUserName":"测试","toArrange":"0人","allArrange":"0人","id":9,"todayArrange":"0人"}]},"bord1":[{"countAll":"61人","sysUserName":"杨涛","id":1,"countToday":"0人"},{"countAll":"41人","sysUserName":"张惜桐","id":2,"countToday":"0人"},{"countAll":"25人","sysUserName":"韩慧玉","id":3,"countToday":"0人"},{"countAll":"0人","sysUserName":"董杨","id":6,"countToday":"0人"},{"countAll":"0人","sysUserName":"陈亚军","id":7,"countToday":"0人"},{"countAll":"0人","sysUserName":"刘嘉奇","id":8,"countToday":"0人"},{"countAll":"0人","sysUserName":"测试","id":9,"countToday":"0人"}]}
     */

    public String code;
    public String msg;
    public DataBean data;


    public static class DataBean {
        /**
         * bord2 : {"allNeed":"0人","list":[{"sysUserName":"胡观平","toArrange":"43人","allArrange":"20人","id":4,"todayArrange":"10人"},{"sysUserName":"胡少卿","toArrange":"60人","allArrange":"4人","id":5,"todayArrange":"3人"},{"sysUserName":"测试","toArrange":"0人","allArrange":"0人","id":9,"todayArrange":"0人"}]}
         * bord1 : [{"countAll":"61人","sysUserName":"杨涛","id":1,"countToday":"0人"},{"countAll":"41人","sysUserName":"张惜桐","id":2,"countToday":"0人"},{"countAll":"25人","sysUserName":"韩慧玉","id":3,"countToday":"0人"},{"countAll":"0人","sysUserName":"董杨","id":6,"countToday":"0人"},{"countAll":"0人","sysUserName":"陈亚军","id":7,"countToday":"0人"},{"countAll":"0人","sysUserName":"刘嘉奇","id":8,"countToday":"0人"},{"countAll":"0人","sysUserName":"测试","id":9,"countToday":"0人"}]
         */

        public Bord2Bean bord2;
        public List<Bord1Bean> bord1;

        public static class Bord2Bean {
            /**
             * allNeed : 0人
             * list : [{"sysUserName":"胡观平","toArrange":"43人","allArrange":"20人","id":4,"todayArrange":"10人"},{"sysUserName":"胡少卿","toArrange":"60人","allArrange":"4人","id":5,"todayArrange":"3人"},{"sysUserName":"测试","toArrange":"0人","allArrange":"0人","id":9,"todayArrange":"0人"}]
             */

            public String allNeed;
            public List<ListBean> list;

            public static class ListBean {
                /**
                 * sysUserName : 胡观平
                 * toArrange : 43人
                 * allArrange : 20人
                 * id : 4
                 * todayArrange : 10人
                 */

                public String sysUserName;
                public String toArrange;
                public String allArrange;
                public Integer id;
                public String todayArrange;
            }
        }

        public static class Bord1Bean {
            /**
             * countAll : 61人
             * sysUserName : 杨涛
             * id : 1
             * countToday : 0人
             */

            public String countAll;
            public String sysUserName;
            public Integer id;
            public String countToday;
        }
    }
}
