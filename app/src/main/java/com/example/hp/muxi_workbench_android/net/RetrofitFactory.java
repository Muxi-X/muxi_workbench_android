package com.example.hp.muxi_workbench_android.net;

public class RetrofitFactory {
    private volatile static RetrofitService sRetrofitService = null;

    public static RetrofitService getRetrofitService(){
        RetrofitService retrofitService = sRetrofitService;
        if (retrofitService == null){
            synchronized (WorkbenchRetrofit.class){
                retrofitService = sRetrofitService;
                if (retrofitService == null) {
                    sRetrofitService = new WorkbenchRetrofit().getRetrofitService();
                    retrofitService = sRetrofitService;
                }
            }
        }
        return retrofitService;
    }

}
