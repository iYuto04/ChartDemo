package com.example.yuto.chartdemo;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by yuto on 2017/05/04.
 */

public class SittingTime extends RealmObject {
    @PrimaryKey
    private Integer time;

    public Integer getTime(){return this.time;};
    public void setTime(Integer time){this.time = time;};

}
