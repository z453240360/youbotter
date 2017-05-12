package com.dev.youboter.youbemine.model;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by zhengdongdong on 2017/5/9.
 *
 * 网络请求访问返回类
 *
 */

public interface IService {


    @FormUrlEncoded
    @POST(IConstast.TULING_BODY)
    Call<ResponseBody> getData(@Field("info")String info, @Field("key")String key, @Field("userid")String userid);



}
