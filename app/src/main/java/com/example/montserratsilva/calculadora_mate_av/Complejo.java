package com.example.montserratsilva.calculadora_mate_av;

import android.graphics.Color;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import javax.xml.transform.Templates;


public final class Complejo implements Serializable {
    private double x;//Parte Real
    private double y;//Parte Imganianria
    private double r;//
    private double O;//teta
    //Pedientes Encuanto se cree el numero se calcule el real y complejo
    public Complejo(double x,double y) {
        this.x = x;
        this.y = y;
        toTrigo();
    }
    public Complejo(double r,double teta,int n) {
        this.r = r;
        this.O = teta;
        toalgebraica();
    }
    public Complejo() {
        this.x = 0;
        this.y = 0;
    }

    public double getX() {
        return round(x,2);
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return round(y,2);
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return round(2,2);
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getO() {
        return round(O,2);
    }

    public void setO(double o) {
        O = o;
    }

    public void toEuler() {




    }
    public void toTrigo() {
        this.r= this.Modulo(this);
        this.O=Math.toDegrees(Math.atan((this.y/this.r)/(this.x/this.r)));

    }
    public void toalgebraica() {

        this.x=(this.getR()*Math.cos(this.getO()));
        this.y=(this.getR()*Math.sin(this.getO()));

    }
    public Complejo Suma(Complejo A, Complejo B)
    {
        Complejo Res= new Complejo();
        Res.setX(A.getX()+B.getX());
        Res.setY(A.getY()+B.getY());
        Res.toTrigo();
        return Res;
    }
    public Complejo Resta(Complejo A, Complejo B)
    {
        Complejo Res= new Complejo();
        Res.setX(A.getX()-B.getX());
        Res.setY(A.getY()-B.getY());
        Res.toTrigo();
        return Res;
    }
    public Complejo Multiplicacion(Complejo A, Complejo B)
    {
        Complejo Res= new Complejo();
        Res.setX((A.getX()*B.getX())-(A.getY()*B.getY()));
        Res.setY((A.getX()*B.getY())+(B.getX()*A.getY()));
        Res.toTrigo();
        return Res;
    }
    public Complejo Division(Complejo A, Complejo B)
    {
        Complejo Res= new Complejo();
        double div=(Math.pow(2,A.getX())+Math.pow(2,B.getY()));
        Res.setX(((A.getX()*B.getX())+(A.getY()*B.getY()))/div);
        Res.setY((A.getX()*B.getY())/div);
        Res.toTrigo();
        return Res;
    }
    public Complejo[] Raiz(Complejo A, int n)
    {
       Complejo[] Res = new Complejo[n];

        for (int k=0;k<n;k++)
        {
            Complejo Temp= new Complejo();
            Temp.setR(Math.pow(this.getR(),1.0/n));
            Temp.setO(((this.getO()+(2*k*Math.PI))/n));
            Temp.toalgebraica();
            Res[k]=Temp;
            Temp.toTrigo();
        }
        return Res;
    }
    public Complejo Conjugado(Complejo A)
    {
        Complejo Res= new Complejo();
        Res.setX(A.getX());
        Res.setY(-1*(A.getY()));
        Res.toTrigo();
        return Res;
    }
    public Complejo Elevado(Complejo A,int n)
    {
        Complejo Res= new Complejo();
        Res.setX(A.getR()*Math.cos(A.getO()));
        Res.setY(A.getR()*Math.sin(A.getO()));
        Res.toTrigo();
        return Res;
    }
    public double  Modulo(Complejo A)
    {
        double Res=Math.sqrt(Math.pow(A.getX(),2)+Math.pow(A.getY(),2));
        return Res;
    }

    public LineGraphSeries<DataPoint> Puntos()
    {
        LineGraphSeries<DataPoint>  vector= new LineGraphSeries();
        if(this.x>=0)
        {
            vector.appendData( new DataPoint(0,0),true,2);
            vector.appendData( new DataPoint(x,y),true,2);

        }else if (this.x<0)
        {
            vector.appendData( new DataPoint(x,y),true,2);
            vector.appendData( new DataPoint(0,0),true,2);
        }
        //vector.setColor(Color.GREEN);
            return vector;
    }
    public PointsGraphSeries<DataPoint> punto() {
        PointsGraphSeries<DataPoint> punto = new PointsGraphSeries<>(new DataPoint[]{
                new DataPoint(x, y)
        });
        return punto;

    }
    public String imprimir(int type) {
        String Result="";
        if (type==1) {

            Result = this.getX() + " ";
            if (this.getY() > 0) {
                Result += " +" + this.getY() + "i";
            } else if (this.getY() < 0) {
                Result += this.getY() + "i";
            }
        }else if(type==2) {

            if (this.getR() == 1) {
                Result = "( cos(" + this.getO() + ")+ i sen(" + this.getO() + ")";
            } else {
                Result = this.getR() + "( cos(" + this.getO() + "°)+ i sen(" + this.getO() + "° )";
            }
        }
        else if(type==3) {
             if(this.getR()==1)
                 {
                     Result= "e^("+this.getO()+")i";
                 }else {
                     Result = this.getR() + "e^("+this.getO()+"°)i";
                 }
        }

return Result;

    }
    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}

