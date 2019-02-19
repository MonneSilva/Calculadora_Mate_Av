package com.example.montserratsilva.calculadora_mate_av;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

public class MainActivity extends AppCompatActivity {
    LineGraphSeries<DataPoint> series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        double x, y;
        x = 0;

        GraphView graph = (GraphView) findViewById(R.id.grap1);
        graph.getViewport().setScalable(true);//zoom y scroll
        graph.getViewport().setScalableY(true);

        Complejo a= new Complejo(4,1);
        a.Suma(a,new Complejo(-3,5)).Graficar(graph);

    }
}

