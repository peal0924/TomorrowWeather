package com.zp.tomorrowweather.weatherapi;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Administrator on 2017-01-03.
 */

public class HttpUtils {

    private OkHttpClient singleClient;

    /**
     * 由于heWeather的所有api都是使用的是get方法进行的请求的；所以需要在url上进行拼接
     */
    private String BASEURL = "https://free-api.heweather.com/v5/";

    public enum REQUEST_TYPE{
        DAILY_FORECAST, //7-10天的天气预报
        NOW,    //实况天气
        HOURLY_FORECAST,    //每小时的天气
        SUGGESTION,     //生活指数
        ALARMS,     //灾害预警
        WEATHER,    //天气预报集合接口
        SCENIC         //景点天气
    }


    public String getURL(REQUEST_TYPE type,String city,String key){

        String url = null;
        switch (type){
            case DAILY_FORECAST:
                url = BASEURL+"forecast?city="+city+"&key="+key;
                break;
            case NOW:
                url = BASEURL+"now?city="+city+"&key="+key;
                break;
            case HOURLY_FORECAST:
                url = BASEURL+"hourly?city="+city+"&key="+key;
                break;
            case SUGGESTION:
                url = BASEURL+"suggestion?city="+city+"&key="+key;
                break;
            case ALARMS:
                url = BASEURL+"alarm?city="+city+"&key="+key;
                break;
            case WEATHER:
                url = BASEURL+"weather?city="+city+"&key="+key;
                break;
            case SCENIC:
                url = BASEURL+"scenic?city="+city+"&key="+key;
                break;
            default:
                break;
        }
        return url;
    }

    public OkHttpClient getSingleClient(){
        if(singleClient == null){
            singleClient = new OkHttpClient.Builder()
                                .addInterceptor(new StethoInterceptor())
                                .build();
            //增加调试用的断点
            return  singleClient;
        }
        return singleClient;
    }

    public void WeatherRequest(REQUEST_TYPE type,String city,String key,Callback callback){

        singleClient = getSingleClient();
        Request request = new Request.Builder().url(getURL(type,city,key)).build();

        singleClient.newCall(request).enqueue(callback);

    }

}
