package com.zp.tomorrowweather.db.bean;

import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2017-01-03.
 *
 * 县的实体类
 *
 */

public class County extends DataSupport{

    private int id;

    private String countyName;

    private String weatherId;

    private int citId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(String weatherId) {
        this.weatherId = weatherId;
    }

    public int getCitId() {
        return citId;
    }

    public void setCitId(int citId) {
        this.citId = citId;
    }
}
