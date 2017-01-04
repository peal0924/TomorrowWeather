package com.zp.tomorrowweather.weatherapi.apibean;

import com.zp.tomorrowweather.weatherapi.bean.BasicBean;
import com.zp.tomorrowweather.weatherapi.bean.NowBean;

import java.util.List;

/**
 * Created by Administrator on 2017-01-03.
 *
 *  实况天气
 *
 */

public class HeWeather2 {

    private List<HeWeather2Bean> HeWeather5;

    public List<HeWeather2Bean> getHeWeather5() {
        return HeWeather5;
    }

    public void setHeWeather5(List<HeWeather2Bean> HeWeather5) {
        this.HeWeather5 = HeWeather5;
    }

    public static class HeWeather2Bean {
        /**
         * basic : {"city":"北京","cnty":"中国","id":"CN101010100","lat":"39.904000","lon":"116.391000","prov":"北京","update":{"loc":"2016-08-31 11:52","utc":"2016-08-31 03:52"}}
         * now : {"cond":{"code":"104","txt":"阴"},"fl":"11","hum":"31","pcpn":"0","pres":"1025","tmp":"13","vis":"10","wind":{"deg":"40","dir":"东北风","sc":"4-5","spd":"24"}}
         * status : ok
         */

        private BasicBean basic;
        private NowBean now;
        private String status;

        public BasicBean getBasic() {
            return basic;
        }

        public void setBasic(BasicBean basic) {
            this.basic = basic;
        }

        public NowBean getNow() {
            return now;
        }

        public void setNow(NowBean now) {
            this.now = now;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

    }
}
