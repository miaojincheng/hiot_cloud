package com.example.hiot_cloud;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hiot_cloud.ui.main.MainActivity;

import java.util.Timer;
import java.util.TimerTask;

public class splashActivity extends AppCompatActivity {

    private static final int HANDLER_MSG_OPEN_NEW = 1;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            boolean hasLogin = false;
            if (msg.what == HANDLER_MSG_OPEN_NEW){

                Intent intent=new Intent(splashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //设置定时器
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(HANDLER_MSG_OPEN_NEW);
            }
        },3000);
    }

}
