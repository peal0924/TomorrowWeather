package com.zp.tomorrowweather.weatherapi.apibean;

import com.zp.tomorrowweather.weatherapi.apibean.HeWeather1.HeWeather1Bean.DailyForecastBean;
import com.zp.tomorrowweather.weatherapi.bean.BasicBean;

import java.util.List;

;
;

/**
 * Created by Administrator on 2017-01-04.
 */

public class HeWeather7 {


    private List<HeWeather7Bean> HeWeather5;

    public List<HeWeather7Bean> getHeWeather5() {
        return HeWeather5;
    }

    public void setHeWeather5(List<HeWeather7Bean> HeWeather5) {
        this.HeWeather5 = HeWeather5;
    }

    public static class HeWeather7Bean {
        /**
         * basic : {"city":"故宫博物院","cnty":"中国","id":"CN10101010018A","lat":"116.39","lon":"39.91","update":{"loc":"2015-07-02 08:10","utc":"2015-07-02 00:10"}}
         * daily_forecast : [{"date":"2015-10-10","astro":{"sr":"06:19","ss":"17:43"},"cond":{"code_d":"101","code_n":"101","txt_d":"多云","txt_n":"多云"},"tmp":{"max":"16","min":"10"},"wind":{"dir":"北风","sc":"3-4"}}]
         * status : ok
         */

        private BasicBean basic;
        private String status;
        private List<DailyForecastBean> daily_forecast;

        public BasicBean getBasic() {
            return basic;
        }

        public void setBasic(BasicBean basic) {
            this.basic = basic;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public List<DailyForecastBean> getDaily_forecast() {
            return daily_forecast;
        }

        public void setDaily_forecast(List<DailyForecastBean> daily_forecast) {
            this.daily_forecast = daily_forecast;
        }

    }
}
