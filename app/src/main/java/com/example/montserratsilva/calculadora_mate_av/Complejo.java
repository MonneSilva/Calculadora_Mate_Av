package com.example.montserratsilva.calculadora_mate_av;

public class Complejo {
    private double x;//Parte Real
    private double y;//Parte Imganianria

    public Complejo()
    {
        this.x=0;
        this.y=0;
    }
    public Complejo(float x,float y,int tipo) {
        if(tipo==0)  //Forma algébraica
        {
            this.x = x;
            this.y = y;
        }
        if(tipo==1)  //Forma trigonometrica
        {
            this.x = x;// r
            this.y = y;// teta
        }


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

    public Complejo(float teta) {//forma de euler



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
}
