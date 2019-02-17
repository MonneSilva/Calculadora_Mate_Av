package com.example.montserratsilva.calculadora_mate_av;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class MainActivity extends AppCompatActivity {
LineGraphSeries<DataPoint> series;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        double x,y;
        x=0;
        GraphView grap = findViewById(R.id.grap1);

        series= new LineGraphSeries<DataPoint>();
        for (int i =0; i<500; i++)
        {
            x=8;
            y=2;
            series.appendData(new DataPoint(x,y),true,500);
        }
        grap.addSeries(series);
    }
}
