package com.example.hp.muxi_workbench_android;

import android.app.Application;

public class App extends Application {
    private static App instance;
    private static String token;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static App getInstance(){
        return instance;
    }

    public static String getToken(){
        return token;
    }

    public static void setToken(String to){
        token = to;
    }
}