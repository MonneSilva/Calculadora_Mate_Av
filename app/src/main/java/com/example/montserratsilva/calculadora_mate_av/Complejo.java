package com.example.montserratsilva.calculadora_mate_av;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

import java.util.ArrayList;

public class Complejo {
    private double x;//Parte Real
    private double y;//Parte Imganianria
    private double r;//
    private double O;//teta
//Pedientes Encuanto se cree el numero se calcule el real y complejo
    public Complejo(float x,float y) {

            this.x = x;
            this.y = y;
    }
    public Complejo() {
            this.x = 0;
            this.y = 0;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void Euler() {




    }
    public void Trigo() {
        this.r= this.Modulo(this);
        this.O=Math


    }
    public void algebraica() {



    }
    public Complejo Suma(Complejo A, Complejo B)
    {
        Complejo Res= new Complejo();
        Res.setX(A.getX()+B.getX());
        Res.setY(A.getY()+B.getY());
        return Res;
    }
    public Complejo Resta(Complejo A, Complejo B)
    {
        Complejo Res= new Complejo();
        Res.setX(A.getX()-B.getX());
        Res.setY(A.getY()-B.getY());
        return Res;
    }
    public Complejo Multiplicacion(Complejo A, Complejo B)
    {
        Complejo Res= new Complejo();
        Res.setX((A.getX()*B.getX())-(A.getY()*B.getY()));
        Res.setY((A.getX()*B.getY())+(B.getX()*A.getY()));
        return Res;
    }
    public Complejo Division(Complejo A, Complejo B)
    {
        Complejo Res= new Complejo();
        double div=(Math.pow(2,A.getX())+Math.pow(2,B.getY()));
        Res.setX(((A.getX()*B.getX())+(A.getY()*B.getY()))/div);
        Res.setY((A.getX()*B.getY())/div);
        return Res;
    }
    public ArrayList<Complejo> Raiz(Complejo A, int n)
    {
        ArrayList<Complejo> Res= new ArrayList();
        for (int i=0;i<n;i++)
        {

        }

        return Res;
    }
    public Complejo Conjugado(Complejo A)
    {
        Complejo Res= new Complejo();
        Res.setX(A.getX());
        Res.setY(-1*(A.getY()));
        return Res;
    }
    public double  Modulo(Complejo A)
    {
       double Res=Math.sqrt(Math.pow(2,A.getX())+Math.pow(2,A.getY()));
        return Res;
    }
    public void Graficar(GraphView graph)
    {
        PointsGraphSeries<DataPoint> point = new PointsGraphSeries<>(new DataPoint[] {
                new DataPoint(this.getX(), this.getY())
        });
        point.setShape(PointsGraphSeries.Shape.POINT);
        LineGraphSeries<DataPoint> vector = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 0),
                new DataPoint(this.getX(), this.getY())
        });
        graph.addSeries(point);
        graph.addSeries(vector);
    }
}
