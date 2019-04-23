package com.example.hp.muxi_workbench_android.net;

import com.example.hp.muxi_workbench_android.net.bean.FeedList;
import com.example.hp.muxi_workbench_android.net.bean.ScheduleList;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface RetrofitService {
    @GET("feed/list/{page}")
    Observable<FeedList> getFeedList(@Path("page")int page);

    @GET("/status/list/{page}")
    Observable<ScheduleList> getScheduelList(@Header("token")String token, @Path("page")int page);
}
