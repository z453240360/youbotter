package com.dev.youboter.youbemine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.dev.youboter.youbemine.activity.Act_KeDa;
import com.dev.youboter.youbemine.activity.Activtity_tuLing;
import com.dev.youboter.youbemine.activity.ForTest;
import com.dev.youboter.youbemine.activity.KeDa_benDi;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;

public class MainActivity extends AppCompatActivity {

    private Button mbtnMain;
    private Button mbtnKeda,mbtn_bendi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        //初始化科大讯飞SDK
        SpeechUtility.createUtility(this, SpeechConstant.APPID+"=58fbf195");

        mbtnKeda = (Button) findViewById(R.id.mbtn_keda);

        mbtnMain = (Button) findViewById(R.id.mbtn_main);

        mbtn_bendi= (Button) findViewById(R.id.mbtn_kedaforbendi);


    }

    /**
     * 点击事件，主界面向其它页面跳转
     * @param view
     */
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mbtn_main:
                Intent intent= new Intent(MainActivity.this, Activtity_tuLing.class);
                startActivity(intent);
                break;
            case R.id.mbtn_keda:

                Intent intent1= new Intent(MainActivity.this, Act_KeDa.class);

                startActivity(intent1);

                break;

            case R.id.mbtn_kedaforbendi:

                Intent intent2= new Intent(MainActivity.this, KeDa_benDi.class);

                startActivity(intent2);

                break;
            case R.id.mbtn_music:

                Intent intent3= new Intent(MainActivity.this, ForTest.class);

                startActivity(intent3);

                break;


        }
    }
}
