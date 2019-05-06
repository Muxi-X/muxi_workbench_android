package com.example.hp.muxi_workbench_android.net;

import com.example.hp.muxi_workbench_android.net.bean.FeedList;
import com.example.hp.muxi_workbench_android.net.bean.Login;
import com.example.hp.muxi_workbench_android.net.bean.ScheduleInfo;
import com.example.hp.muxi_workbench_android.net.bean.ScheduleList;


import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitService {

    @POST("auth/login/")
    Observable<Login> login(@Body RequestBody body);

    @GET("feed/list/{page}")
    Observable<FeedList> getFeedList(@Header("token")String token, @Path("page")int page);

    @GET("status/list/{page}")
    Observable<ScheduleList> getScheduleList(@Header("token")String token, @Path("page")int page);

    @GET("status/{sid}")
    Observable<ScheduleInfo> getScheduleInfo(@Header("token")String token, @Path("sid")int sid);
}
