package com.dev.youboter.youbemine.presenter;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.dev.youboter.youbemine.model.CallBack;
import com.dev.youboter.youbemine.model.MyModel;
import com.dev.youboter.youbemine.bean.BeanResult;
import com.dev.youboter.youbemine.view.IView;
import com.google.gson.Gson;
import com.iflytek.cloud.RecognizerListener;
import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechRecognizer;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SynthesizerListener;
import com.iflytek.cloud.TextUnderstander;
import com.iflytek.cloud.TextUnderstanderListener;
import com.iflytek.cloud.UnderstanderResult;

import java.util.List;

/**
 * Created by zhengdongdong on 2017/5/9.
 */

public class MyPresnenter {

    private MyModel model;
    private IView mView;
    private TextUnderstander tu;
    private SpeechRecognizer sp;
    private SpeechSynthesizer ss;

    public MyPresnenter(IView mView) {
        model = new MyModel();
        this.mView = mView;
    }

    /**
     * 获取图灵发起网络请求的语句
     *
     * @param info   传入要说的话
     * @param userid 用户账号
     */
    public void getModel(String info, String userid) {
        model.getModelString(info, userid, new CallBack() {
            @Override
            public void successed(String s) {
                mView.getDatas(s);
            }

            @Override
            public void failed() {

            }
        });
    }

    /**
     * 使用科大讯飞，用于语音识别系统
     * <p>
     * 调用answer 方法获得语音结果类的回掉
     */
    public void VoiceToText(Context context) {

        sp = SpeechRecognizer.createRecognizer(context, null);

        sp.setParameter(SpeechConstant.DOMAIN, "iat");

        sp.setParameter(SpeechConstant.LANGUAGE, "zh_cn");

        sp.setParameter(SpeechConstant.ACCENT, "mandarin");

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

                Log.i("11","2"+b);

                if (!b) {
                    String resultString = recognizerResult.getResultString();

                    Log.i("11", "3" + b);

                    BeanResult beanResult = new Gson().fromJson(resultString, BeanResult.class);

                    List<BeanResult.WsBean> ws = beanResult.getWs();

                    String w = "";

                    for (int i = 0; i < ws.size(); i++) {
                        List<BeanResult.WsBean.CwBean> cw = ws.get(i).getCw();
                        for (int j = 0; j < cw.size(); j++) {
                            w += cw.get(j).getW();
                        }
                    }

                    mView.getAnswer(w);
                }


            }

            @Override
            public void onError(SpeechError speechError) {

            }

            @Override
            public void onEvent(int i, int i1, int i2, Bundle bundle) {

            }
        });
    }


    /**
     * 使用科大讯飞，将文字转换为语音的方式
     */
    public void TextToVoice(Context context,String text) {
        ss=SpeechSynthesizer.createSynthesizer(context,null);

        ss.setParameter(SpeechConstant.VOICE_NAME,"xiaoyan");
        ss.setParameter(SpeechConstant.SPEED,"50");
        ss.setParameter(SpeechConstant.VOLUME,"80");
        ss.setParameter(SpeechConstant.ENGINE_TYPE,SpeechConstant.TYPE_CLOUD);
        ss.setParameter(SpeechConstant.TTS_AUDIO_PATH,"./sdcard/iflytek.pcm");

        ss.startSpeaking(text, new SynthesizerListener() {
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


    }

    /**
     * 使用科大讯飞，以文字形式，返回语义理解
     */
    public void getAnswers(Context context, String s) {
        tu = TextUnderstander.createTextUnderstander(context, null);
        tu.understandText(s, new TextUnderstanderListener() {

            @Override
            public void onResult(UnderstanderResult understanderResult) {
                String resultString = understanderResult.getResultString();
                mView.getDatas(resultString);
            }

            @Override
            public void onError(SpeechError speechError) {

            }
        });
    }
}
