package com.example.montserratsilva.calculadora_mate_av;

import android.os.Parcelable;
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
        double x, y;
        int ope;

        x = Double.parseDouble(getIntent().getStringExtra("x"));
        y = Double.parseDouble(getIntent().getStringExtra("y"));
        ope = Integer.parseInt(getIntent().getStringExtra("ope"));
        GraphView graph = (GraphView) findViewById(R.id.grap1);

        graph.getViewport().setScrollable(true); // enables horizontal scrolling
        graph.getViewport().setScrollableY(true); // enables vertical scrolling
        graph.getViewport().setScalable(true); // enables horizontal zooming and scrolling
        graph.getViewport().setScalableY(true); // enables vertical zooming and scrolling

       Complejo a= new Complejo(x,y);


        if(ope==1)
        {
            double rx = Double.parseDouble(getIntent().getStringExtra("raizX"));
            double ry = Double.parseDouble(getIntent().getStringExtra("raizY"));
            int n= Integer.parseInt(getIntent().getStringExtra("raizn"));
            a= new Complejo(rx,ry);
            if(n==1)
            {
                graph.addSeries(a.Puntos());
                graph.addSeries(a.punto());
            }else
            {

                Complejo[] raiz = a.Raiz(a,n);

                for(int i=0;i<raiz.length;i++)
                {
                    graph.addSeries(raiz[i].Puntos());
                    graph.addSeries(raiz[i].punto());
                }
            }


     }else
        {
            graph.addSeries(a.Puntos());
            graph.addSeries(a.punto());
        }












    }
}

