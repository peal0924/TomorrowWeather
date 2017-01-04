package com.zp.tomorrowweather.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

import static com.baidu.location.h.j.O;
import static com.baidu.location.h.j.c;
import static com.baidu.location.h.j.p;

/**
 * Created by Administrator on 2017-01-03.
 */

public class HttpUtil {


    public static void sendOkHttpRequest(String address,okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }

}
