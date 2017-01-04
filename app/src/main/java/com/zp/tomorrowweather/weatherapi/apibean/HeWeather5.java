package com.zp.tomorrowweather.weatherapi.apibean;

import com.zp.tomorrowweather.weatherapi.bean.BasicBean;

import java.util.List;

/**
 * Created by Administrator on 2017-01-03.
 *
 *  灾害预警
 *
 */

public class HeWeather5 {


    private List<HeWeather5Bean> HeWeather5;

    public List<HeWeather5Bean> getHeWeather5() {
        return HeWeather5;
    }

    public void setHeWeather5(List<HeWeather5Bean> HeWeather5) {
        this.HeWeather5 = HeWeather5;
    }

    public static class HeWeather5Bean {
        /**
         * alarms : [{"level":"蓝色","stat":"预警中","title":"天津市气象台发布大风蓝色预警","txt":"预计今天后半夜到明天夜间我区将受大风影响，平均风力达到6级，阵风7级以上。请有关单位和人员作好防范准备","type":"大风"}]
         * basic : {"city":"天津","cnty":"中国","id":"CN101030100","lat":"39.117000","lon":"117.246000","prov":"天津","update":{"loc":"2016-08-31 11:52","utc":"2016-08-31 03:52"}}
         * status : ok
         */

        private BasicBean basic;
        private String status;
        private List<AlarmsBean> alarms;

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

        public List<AlarmsBean> getAlarms() {
            return alarms;
        }

        public void setAlarms(List<AlarmsBean> alarms) {
            this.alarms = alarms;
        }

        public static class AlarmsBean {
            /**
             * level : 蓝色
             * stat : 预警中
             * title : 天津市气象台发布大风蓝色预警
             * txt : 预计今天后半夜到明天夜间我区将受大风影响，平均风力达到6级，阵风7级以上。请有关单位和人员作好防范准备
             * type : 大风
             */

            private String level;
            private String stat;
            private String title;
            private String txt;
            private String type;

            public String getLevel() {
                return level;
            }

            public void setLevel(String level) {
                this.level = level;
            }

            public String getStat() {
                return stat;
            }

            public void setStat(String stat) {
                this.stat = stat;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }
}
