package com.example.yuto.chartdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Realm.init(this);
        setContentView(R.layout.activity_main);
//        operateRealm();
//        operateRealm();
        makeBarChart();
        makeLineChart();


    }

    private void makeBarChart() {
        List<Float> thisWeek = new ArrayList<Float>(Arrays.asList(10f, 6f, 7f, 5f, 8f, 5f, 5.5f));
        BarChart bar = (BarChart) findViewById(R.id.bar);
        ArrayList<BarEntry> myData = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            myData.add(new BarEntry(i, thisWeek.get(i)));
        }
        BarDataSet dataSet = new BarDataSet(myData, "Label");
        BarData barData = new BarData(dataSet);
        bar.setData(barData);
        bar.invalidate();
    }

    private void makeLineChart(){
        List<Float> weekAverage = new ArrayList<Float>(Arrays.asList(10f, 9.8f, 7.3f, 5.2f, 5.5f, 7.4f, 9.2f));
        LineChart line = (LineChart) findViewById(R.id.chart);
        ArrayList<Entry> myData = new ArrayList<>();
        for (int i = 0; i < weekAverage.size(); i++){
            myData.add(new Entry(i, weekAverage.get(i)));
        }
        LineDataSet dataSet = new LineDataSet(myData, "weekly average");
        System.out.println(myData.size());
        LineData lineData = new LineData(dataSet);
        line.setData(lineData);
        line.invalidate();
    }

    private void operateRealm(){
        SittingTimeDB day = new SittingTimeDB();
        day.setDate("20170503");
        day.setSittingTimeLog(2);
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        SittingTimeDB today = realm.copyToRealm(day);
        realm.commitTransaction();


    }
}
