package com.dev.youboter.youbemine.model;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by zhengdongdong on 2017/5/9.
 *
 * 网络请求，使用retrofit请求网络
 */

public class MyModel {

    private Retrofit retrofit;

    public void getModelString(String info, String userid, final CallBack callback)
    {
        retrofit = new Retrofit.Builder()
                .baseUrl(IConstast.TULING_BASEURL)
                .build();

        IService iService = retrofit.create(IService.class);

        Call<ResponseBody> data = iService.getData(info, IConstast.TULING_KEY, userid);

        data.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String string = response.body().string();

                    callback.successed(string);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                    callback.failed();
            }
        });
    }
}
