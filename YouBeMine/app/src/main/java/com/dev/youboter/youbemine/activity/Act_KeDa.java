package com.dev.youboter.youbemine.activity;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.dev.youboter.youbemine.R;
import com.dev.youboter.youbemine.adapter.ListviewAdapter;
import com.dev.youboter.youbemine.bean.Bean_KeDa;
import com.dev.youboter.youbemine.bean.Bean_KeDaYuYi;
import com.dev.youboter.youbemine.bean.MsgInfo;
import com.dev.youboter.youbemine.presenter.MyPresnenter;
import com.dev.youboter.youbemine.view.IView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.text1;
import static com.iflytek.sunflower.config.b.r;

public class Act_KeDa extends AppCompatActivity implements IView{

    private Button mbtn_change, btn_send, mbtn_change2, btn_send2, btn_say;
    private RelativeLayout rl_one,rl_two;
    private EditText editText;
    private ArrayList<String> dataList;
    private ListviewAdapter adapter;
    private ListView listView;
    private MediaRecorder mediaRecorder;
    private MyPresnenter mPresenter;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_act__ke_da);
        mediaPlayer.create(this,R.raw.nobody);
        init();
    }

    /**
     * 初始化控件
     */
    private void init() {
        adapter=new ListviewAdapter(this);
        editText = (EditText) findViewById(R.id.edit_query);
        mbtn_change = (Button) findViewById(R.id.mbtn_change);
        mbtn_change2 = (Button) findViewById(R.id.mbtn_change2);
        btn_send = (Button) findViewById(R.id.btn_send);
        btn_send2 = (Button) findViewById(R.id.btn_send2);
        btn_say = (Button) findViewById(R.id.btn_say);
        rl_one= (RelativeLayout) findViewById(R.id.rl_one);
        rl_two = (RelativeLayout) findViewById(R.id.rl_two);
        listView = (ListView) findViewById(R.id.list_item);
        mediaRecorder=new MediaRecorder();
        mPresenter=new MyPresnenter(this);
        dataList=new ArrayList<>();
    }

    /**
     * 传入文字对话信息，获取科大讯飞的应答Json字符串，然后解析
     * @param s
     */
    @Override
    public void getDatas(String s) {
        String result = getResult(s);
        mPresenter.TextToVoice(this,result);
        adapter.addDataToAdapter(new MsgInfo(null,result));
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    /**
     *  获得声音回调对象
     */
    @Override
    public void getAnswer(String s) {

        //将获取的声音转换过后的文字 添加到左边的对话框中
        adapter.addDataToAdapter(new MsgInfo(s,null));
        //使用科大讯飞语义模块，返回应答信息
        mPresenter.getAnswers(this,s);

    }

    /**
     * 解析科大讯飞返回的字符串
     * @param s
     * @return
     */
    public String getResult(String s){
        //当使用编辑框方法获取，返回值为Json字符串，要得到结果可以解析此字符串
        Bean_KeDaYuYi bean_keDaYuYi = new Gson().fromJson(s, Bean_KeDaYuYi.class);
        //获取回答的返回类
        Bean_KeDaYuYi.AnswerBean answer = bean_keDaYuYi.getAnswer();
        Log.i("11",""+s);

        //获取服务的项目
        String service = bean_keDaYuYi.getService();

        String text1="";
        if (null==answer)
        {
            Bean_KeDa bean_keDa = new Gson().fromJson(s, Bean_KeDa.class);
            String service1 = bean_keDa.getService();

            Bean_KeDa.DataBean data = bean_keDa.getData();

            List<Bean_KeDa.DataBean.ResultBean> result = data.getResult();

//            String downloadUrl = result.get(1).getDownloadUrl();

            if (service1.equals("music"))
            {
                mediaPlayer.start();
            }

            text1="已经为您找到"+service+"服务";
        }
        else {
            text1 = answer.getText();
        }
        return text1;
    }


    /**
     * 按钮的点击事件
     * @param view
     */
    public void onClick(View view) {
        switch (view.getId())
        {
            //点击切换底部布局
            case R.id.mbtn_change:
                rl_one.setVisibility(View.INVISIBLE);
                rl_two.setVisibility(View.VISIBLE);
                break;
            //点击切回编辑模式的布局
            case R.id.mbtn_change2:
                rl_one.setVisibility(View.VISIBLE);
                rl_two.setVisibility(View.INVISIBLE);
                break;
            //点击发送
            case R.id.btn_send:
                //获取编辑框里面的内容
                String say = editText.getText().toString();
                //将获取的内容添加到左边的对话框显示
                adapter.addDataToAdapter(new MsgInfo(say,null));
                //添加适配器
                listView.setAdapter(adapter);
                //刷新列表
                adapter.notifyDataSetChanged();
                //将声音转换为文字
                mPresenter.getAnswers(this,say);
                //发送完成，清空编辑框
                editText.setText("");
                break;

            //点击开始说话，将声音转换为文字的回调
            case R.id.btn_say:
                mPresenter.VoiceToText(this);
                break;

            case R.id.btn_send2:
                Toast.makeText(this,"暂时没有扩展其它功能",Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
