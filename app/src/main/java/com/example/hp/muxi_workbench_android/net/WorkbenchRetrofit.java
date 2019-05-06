package com.example.hp.muxi_workbench_android.net;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class WorkbenchRetrofit {
    private final RetrofitService mRetrofitService;
    public static final String BASE_URL = "http://work.muxixyz.com/api/v1.0/";

    public WorkbenchRetrofit() {
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(25,TimeUnit.SECONDS)
                .connectTimeout(25, TimeUnit.SECONDS)
                .writeTimeout(25,TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();
        mRetrofitService = retrofit.create(RetrofitService.class);

    }

    public RetrofitService getRetrofitService(){
        return mRetrofitService;
    }
}
