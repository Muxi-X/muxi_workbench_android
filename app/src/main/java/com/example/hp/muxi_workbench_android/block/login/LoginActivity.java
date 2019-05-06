package com.example.hp.muxi_workbench_android.block.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hp.muxi_workbench_android.App;
import com.example.hp.muxi_workbench_android.R;
import com.example.hp.muxi_workbench_android.base.BaseActivity;
import com.example.hp.muxi_workbench_android.block.main.MainActivity;
import com.example.hp.muxi_workbench_android.net.RetrofitFactory;
import com.example.hp.muxi_workbench_android.net.bean.Login;
import com.google.gson.JsonObject;

import androidx.annotation.Nullable;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.Observable;

import okhttp3.MediaType;
import okhttp3.RequestBody;


public class LoginActivity extends BaseActivity {

    private Button mLoginBtn;
    private EditText mAcEt;
    private EditText mPasEt;

    public static void startLoginActivity(Context context){
        Intent intent = new Intent(context,LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        mAcEt = findViewById(R.id.user_ac_text);
        mPasEt = findViewById(R.id.user_pas_text);
        mLoginBtn = findViewById(R.id.login_btn);
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(mAcEt.getText().toString(),mPasEt.getText().toString());
            }
        });
    }

    private void login(String account, String password) {
        JSONObject json = new JSONObject();
        try {
            json.put("email",account);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), json.toString());
        Log.i("LOGIN:",json.toString());
        RetrofitFactory.getRetrofitService().login(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Login>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Login login) {
                        App.setToken(login.getToken());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                        LoginActivity.this.startActivity(intent);
                    }
                });
    }
}
