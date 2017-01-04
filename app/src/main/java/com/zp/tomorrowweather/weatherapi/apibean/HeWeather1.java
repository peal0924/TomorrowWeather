package com.zp.tomorrowweather.weatherapi.apibean;

import com.zp.tomorrowweather.weatherapi.bean.BasicBean;
import com.zp.tomorrowweather.weatherapi.bean.CondBean;
import com.zp.tomorrowweather.weatherapi.bean.TmpBean;
import com.zp.tomorrowweather.weatherapi.bean.WindBean;

import java.util.List;

/**
 * Created by Administrator on 2017-01-03.
 *  7-10 天预报
 */

public class HeWeather1 {


    private List<HeWeather1Bean> HeWeather5;

    public List<HeWeather1Bean> getHeWeather5() {
        return HeWeather5;
    }

    public void setHeWeather5(List<HeWeather1Bean> HeWeather5) {
        this.HeWeather5 = HeWeather5;
    }

    public static class HeWeather1Bean {
        /**
         * basic : {"city":"北京","cnty":"中国","id":"CN101010100","lat":"39.904000","lon":"116.391000","prov":"北京","update":{"loc":"2016-08-31 11:52","utc":"2016-08-31 03:52"}}
         * daily_forecast : [{"astro":{"mr":"04:19","ms":"18:07","sr":"05:41","ss":"18:47"},"cond":{"code_d":"100","code_n":"104","txt_d":"晴","txt_n":"阴"},"date":"2016-08-31","hum":"17","pcpn":"0.0","pop":"1","pres":"997","tmp":{"max":"33","min":"19"},"vis":"10","wind":{"deg":"342","dir":"北风","sc":"3-4","spd":"10"}}]
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

        public static class DailyForecastBean {
            /**
             * astro : {"mr":"04:19","ms":"18:07","sr":"05:41","ss":"18:47"}
             * cond : {"code_d":"100","code_n":"104","txt_d":"晴","txt_n":"阴"}
             * date : 2016-08-31
             * hum : 17
             * pcpn : 0.0
             * pop : 1
             * pres : 997
             * tmp : {"max":"33","min":"19"}
             * vis : 10
             * wind : {"deg":"342","dir":"北风","sc":"3-4","spd":"10"}
             */

            private AstroBean astro;
            private CondBean cond;
            private String date;
            private String hum;
            private String pcpn;
            private String pop;
            private String pres;
            private TmpBean tmp;
            private String vis;
            private WindBean wind;

            public AstroBean getAstro() {
                return astro;
            }

            public void setAstro(AstroBean astro) {
                this.astro = astro;
            }

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

            public String getPcpn() {
                return pcpn;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
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

            public TmpBean getTmp() {
                return tmp;
            }

            public void setTmp(TmpBean tmp) {
                this.tmp = tmp;
            }

            public String getVis() {
                return vis;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public WindBean getWind() {
                return wind;
            }

            public void setWind(WindBean wind) {
                this.wind = wind;
            }

            public static class AstroBean {
                /**
                 * mr : 04:19
                 * ms : 18:07
                 * sr : 05:41
                 * ss : 18:47
                 */

                private String mr;
                private String ms;
                private String sr;
                private String ss;

                public String getMr() {
                    return mr;
                }

                public void setMr(String mr) {
                    this.mr = mr;
                }

                public String getMs() {
                    return ms;
                }

                public void setMs(String ms) {
                    this.ms = ms;
                }

                public String getSr() {
                    return sr;
                }

                public void setSr(String sr) {
                    this.sr = sr;
                }

                public String getSs() {
                    return ss;
                }

                public void setSs(String ss) {
                    this.ss = ss;
                }
            }

        }
    }
}
