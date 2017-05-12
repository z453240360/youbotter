package com.dev.youboter.youbemine.activity;

import android.media.MediaRecorder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.dev.youboter.youbemine.R;
import com.dev.youboter.youbemine.adapter.ListviewAdapter;
import com.dev.youboter.youbemine.bean.MsgInfo;
import com.dev.youboter.youbemine.bean.beanTuLing;
import com.dev.youboter.youbemine.presenter.MyPresnenter;
import com.dev.youboter.youbemine.view.IView;
import com.google.gson.Gson;

import java.util.ArrayList;

public class Activtity_tuLing extends AppCompatActivity implements IView {

    private Button mbtn_change, btn_send, mbtn_change2, btn_send2, btn_say;
    private RelativeLayout rl_one, rl_two;
    private EditText editText;
    private ArrayList<String> dataList;
    private ListviewAdapter adapter;
    private ListView listView;
    private MediaRecorder mediaRecorder;
    private MyPresnenter mPresenter;
    private String answer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_activtity_tu_ling);

        init();
    }

    /**
     * 传入说话内容，返回图灵的数据
     * @param s
     */
    @Override
    public void getDatas(String s) {
        beanTuLing beanTuLing = new Gson().fromJson(s, beanTuLing.class);
        answer = beanTuLing.getText();
        mPresenter.TextToVoice(this,answer);

        adapter.addDataToAdapter(new MsgInfo(null, answer));
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


    /**
     * 传入语音或者文字，通过图灵数据接口，获得返回的应答，并将对应的文字，添加到列表中显示
     * @param s
     */
    @Override
    public void getAnswer(String s) {
        if (null!=s) {
            adapter.addDataToAdapter(new MsgInfo(s, null));
            mPresenter.getModel(s,"z453240360");
            listView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
        else {
            Toast.makeText(this,"没有听到哦",Toast.LENGTH_SHORT).show();

        }
    }

    /**
     * 点击事件
     * @param view
     */
    public void onClick(View view) {
        switch (view.getId()) {
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


            //图灵点击发送
            case R.id.btn_send:
                final String say = editText.getText().toString();
                if (null == say) {
                    Toast.makeText(this, "请输入内容", Toast.LENGTH_SHORT).show();
                } else {
                    adapter.addDataToAdapter(new MsgInfo(say, null));
                    mPresenter.getModel(say, "z453240360");
                    listView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                    listView.setSelection(listView.getBottom());
                }
                editText.setText("");
                break;

            case R.id.btn_send2:
                Toast.makeText(this, "暂时没有扩展其它功能", Toast.LENGTH_SHORT).show();
                break;

            //点击通过语音的方式说话
            case R.id.btn_say:

                mPresenter.VoiceToText(this);

                break;
        }
    }

    /**
     * 初始化控件
     */
    private void init() {
        adapter = new ListviewAdapter(this);
        editText = (EditText) findViewById(R.id.edit_query);
        mbtn_change = (Button) findViewById(R.id.mbtn_change);
        mbtn_change2 = (Button) findViewById(R.id.mbtn_change2);
        btn_send = (Button) findViewById(R.id.btn_send);
        btn_send2 = (Button) findViewById(R.id.btn_send2);
        btn_say = (Button) findViewById(R.id.btn_say);
        rl_one = (RelativeLayout) findViewById(R.id.rl_one);
        rl_two = (RelativeLayout) findViewById(R.id.rl_two);
        listView = (ListView) findViewById(R.id.list_item);
        mediaRecorder = new MediaRecorder();
        mPresenter = new MyPresnenter(this);
        dataList = new ArrayList<>();
    }


}
