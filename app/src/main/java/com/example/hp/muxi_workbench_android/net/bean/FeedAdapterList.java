package com.example.hp.muxi_workbench_android.net.bean;

import java.util.ArrayList;
import java.util.List;

public class FeedAdapterList {

    /*提供给Adapter使用的加工过的List
    当UserId = -1时，储存时间信息
    此时UserName储存time*/

    private List<FeedList.DataListBean.UserBean> userBeans = new ArrayList<>();
    private List<FeedList.DataListBean.SourceBean> sourceBeans = new ArrayList<>();

    public List<FeedList.DataListBean.UserBean> getUserBeans() {
        return userBeans;
    }

    public void setUserBeans(List<FeedList.DataListBean.UserBean> userBeans) {
        this.userBeans = userBeans;
    }

    public List<FeedList.DataListBean.SourceBean> getSourceBeans() {
        return sourceBeans;
    }

    public void setSourceBeans(List<FeedList.DataListBean.SourceBean> sourceBeans) {
        this.sourceBeans = sourceBeans;
    }
}
