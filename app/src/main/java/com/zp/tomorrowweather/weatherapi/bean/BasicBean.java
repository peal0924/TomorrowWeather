package com.zp.tomorrowweather.weatherapi.bean;

/**
 * Created by Administrator on 2017-01-03.
 *  城市的基本信息
 */

public class BasicBean {

    /**
     * city : 北京
     * cnty : 中国
     * id : CN101010100
     * lat : 39.904000
     * lon : 116.391000
     * prov : 北京
     * update : {"loc":"2016-08-31 11:52","utc":"2016-08-31 03:52"}
     */

    private String city;
    private String cnty;
    private String id;
    private String lat;
    private String lon;
    private String prov;
    private UpdateBean update;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCnty() {
        return cnty;
    }

    public void setCnty(String cnty) {
        this.cnty = cnty;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public UpdateBean getUpdate() {
        return update;
    }

    public void setUpdate(UpdateBean update) {
        this.update = update;
    }

    class UpdateBean {

        /**
         * "loc": "2016-08-31 11:52",  //当地时间
         * "utc": "2016-08-31 03:52"  //UTC时间
         */

        private String loc;
        private String utc;

        public String getLoc() {
            return loc;
        }

        public void setLoc(String loc) {
            this.loc = loc;
        }

        public String getUtc() {
            return utc;
        }

        public void setUtc(String utc) {
            this.utc = utc;
        }
    }
}
