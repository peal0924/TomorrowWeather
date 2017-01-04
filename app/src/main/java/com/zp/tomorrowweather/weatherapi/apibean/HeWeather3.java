package com.zp.tomorrowweather.weatherapi.apibean;

import com.zp.tomorrowweather.weatherapi.bean.BasicBean;
import com.zp.tomorrowweather.weatherapi.bean.CondBean;
import com.zp.tomorrowweather.weatherapi.bean.WindBean;

import java.util.List;

/**
 * Created by Administrator on 2017-01-03.
 *  每小时预报
 */

public class HeWeather3 {


    private List<HeWeather3Bean> HeWeather5;

    public List<HeWeather3Bean> getHeWeather5() {
        return HeWeather5;
    }

    public void setHeWeather5(List<HeWeather3Bean> HeWeather5) {
        this.HeWeather5 = HeWeather5;
    }

    public static class HeWeather3Bean {
        /**
         * basic : {"city":"北京","cnty":"中国","id":"CN101010100","lat":"39.904000","lon":"116.391000","prov":"北京","update":{"loc":"2016-08-31 11:52","utc":"2016-08-31 03:52"}}
         * hourly_forecast : [{"cond":{"code":"100","txt":"晴"},"date":"2016-08-31 12:00","hum":"21","pop":"0","pres":"998","tmp":"33","wind":{"deg":"40","dir":"东北风","sc":"4-5","spd":"24"}}]
         * status : ok
         */

        private BasicBean basic;
        private String status;
        private List<HourlyForecastBean> hourly_forecast;

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

        public List<HourlyForecastBean> getHourly_forecast() {
            return hourly_forecast;
        }

        public void setHourly_forecast(List<HourlyForecastBean> hourly_forecast) {
            this.hourly_forecast = hourly_forecast;
        }

        public static class HourlyForecastBean {
            /**
             * cond : {"code":"100","txt":"晴"}
             * date : 2016-08-31 12:00
             * hum : 21
             * pop : 0
             * pres : 998
             * tmp : 33
             * wind : {"deg":"40","dir":"东北风","sc":"4-5","spd":"24"}
             */

            private CondBean cond;
            private String date;
            private String hum;
            private String pop;
            private String pres;
            private String tmp;
            private WindBean wind;

            public CondBean getCond() {
                return cond;
            }

            public void setCond(CondBean cond) {
                this.cond = cond;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPop() {
                return pop;
            }

            public void setPop(String pop) {
                this.pop = pop;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getTmp() {
                return tmp;
            }

            public void setTmp(String tmp) {
                this.tmp = tmp;
            }

            public WindBean getWind() {
                return wind;
            }

            public void setWind(WindBean wind) {
                this.wind = wind;
            }
        }
    }
}
