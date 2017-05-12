package com.dev.youboter.youbemine.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.net.URL;

/**
 * Created by zhengdongdong on 2017/5/12.
 */

public class ForMusicService extends Service {

    private MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        mediaPlayer = new MediaPlayer();
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    //开始播放音乐
    public void musicStart(){

        mediaPlayer.create(this, Uri.parse("http://file.kuyinyun.com/group1/M00/80/E7/rBBGdVQJA_2ATs3cAAvCN1C-Z7Q944.mp3"));
    }

    //停止播放音乐
    public void musicStop(){


    }



}
