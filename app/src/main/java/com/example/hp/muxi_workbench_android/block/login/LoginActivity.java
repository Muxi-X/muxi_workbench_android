package com.example.hp.muxi_workbench_android.block.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hp.muxi_workbench_android.R;
import com.example.hp.muxi_workbench_android.base.BaseActivity;

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

    }
}
