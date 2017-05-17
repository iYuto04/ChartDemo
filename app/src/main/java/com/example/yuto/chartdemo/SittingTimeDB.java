package com.example.yuto.chartdemo;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by yuto on 2017/04/23.
 */

public class SittingTimeDB extends RealmObject {

    @PrimaryKey
    private String date;
    private RealmList<SittingTime> sittingTimeLog;

    public String getDate(){return this.date;};
    public void setDate(String date){this.date = date;};
    public RealmList<SittingTime> getSittingTimeLog(){return this.sittingTimeLog;};
    public void setSittingTimeLog(Integer time){
        SittingTime sittingTime = new SittingTime();
        sittingTime.setTime(time);
        sittingTimeLog.add(sittingTime);
    }
}
