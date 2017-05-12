package com.dev.youboter.youbemine.model;

/**
 * Created by zhengdongdong on 2017/5/9.
 *
 * 网络请求访问返回类
 * 用于回调网络请求返回成功或者失败的值
 */

public interface CallBack {

    //网络请求成功返回值为 字符串
    void successed(String s);

    //网络请求加载失败
    void failed();
}
