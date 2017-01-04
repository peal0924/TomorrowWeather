package com.zp.tomorrowweather;

import com.facebook.stetho.Stetho;

/**
 * Created by Administrator on 2017-01-03.
 */

public class MyApplication extends org.litepal.LitePalApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        Stetho.initializeWithDefaults(this);
    }
}
