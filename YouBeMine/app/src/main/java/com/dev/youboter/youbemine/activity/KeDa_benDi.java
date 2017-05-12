package com.dev.youboter.youbemine.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.dev.youboter.youbemine.R;
import com.iflytek.cloud.ErrorCode;
import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.RecognizerListener;
import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechRecognizer;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.SynthesizerListener;

public class KeDa_benDi extends AppCompatActivity {

    private SpeechRecognizer sp;
    private EditText ed;

    private InitListener nl= new InitListener() {
        @Override
        public void onInit(int i) {
            if (i== ErrorCode.SUCCESS){
                Toast.makeText(KeDa_benDi.this,"11111",Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ke_da_ben_di);

        ed = (EditText) findViewById(R.id.txt_endi);
        sp = SpeechRecognizer.createRecognizer(this,nl);



    }

    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btn_bendi:

                Toast.makeText(this,"请安装讯飞语记",Toast.LENGTH_SHORT).show();
                sp.setParameter(SpeechConstant.ENGINE_TYPE,SpeechConstant.TYPE_LOCAL);

                sp.setParameter(SpeechConstant.LOCAL_GRAMMAR, "call");

                sp.setParameter(SpeechConstant.ASR_THRESHOLD, "30");

                sp.startListening(new RecognizerListener() {
                    @Override
                    public void onVolumeChanged(int i, byte[] bytes) {

                    }

                    @Override
                    public void onBeginOfSpeech() {

                    }

                    @Override
                    public void onEndOfSpeech() {

                    }

                    @Override
                    public void onResult(RecognizerResult recognizerResult, boolean b) {

                        String resultString = recognizerResult.getResultString();

                        Toast.makeText(KeDa_benDi.this,""+resultString,Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onError(SpeechError speechError) {

                    }

                    @Override
                    public void onEvent(int i, int i1, int i2, Bundle bundle) {

                    }
                });

                break;

            case R.id.btn_bendihecheng:

                SpeechSynthesizer my= SpeechSynthesizer.createSynthesizer(this,nl);

                my.setParameter(SpeechConstant.ENGINE_TYPE,SpeechConstant.TYPE_LOCAL);

                SpeechUtility.getUtility().openEngineSettings(SpeechConstant.ENG_TTS);

                my.startSpeaking(ed.getText()+"本地", new SynthesizerListener() {
                    @Override
                    public void onSpeakBegin() {

                    }

                    @Override
                    public void onBufferProgress(int i, int i1, int i2, String s) {

                    }

                    @Override
                    public void onSpeakPaused() {

                    }

                    @Override
                    public void onSpeakResumed() {

                    }

                    @Override
                    public void onSpeakProgress(int i, int i1, int i2) {

                    }

                    @Override
                    public void onCompleted(SpeechError speechError) {

                    }

                    @Override
                    public void onEvent(int i, int i1, int i2, Bundle bundle) {

                    }
                });

                break;
        }



    }
}
