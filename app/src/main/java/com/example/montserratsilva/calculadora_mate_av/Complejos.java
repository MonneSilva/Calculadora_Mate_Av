package com.example.montserratsilva.calculadora_mate_av;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Complejos extends AppCompatActivity {
    Button btnRaiz, btnGra, btnSh, btnPa1, btnPa2, btnC, btnCE, btnCero, btnUno, btnDos, btnTres, btnCuatro, btnCinco, btnSeis, btnSiete,
            btnOcho, btnNueve, btnSuma, btnResta, btnMultiplica, btnDivide, btnPunto, btnIgual;
    TextView Resultado, Resultados;
    int indice, cont, n, ope, Raizn, type = 0;
    double z, Res2;
    Complejo Res, c2, Raiz;
    Complejo[] ResR;
    Complejo[] Auxs;
    String texto, pantalla = "";
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    String[] simbolos = {"(", ")", ",", "+", "-", "x", "/", "°", "c", "e", "i", "^", "π", "√", "'", "|"};
    Complejo Aux;


    public String setPantalla(String string) {
        return Resultado.getText().toString() + string;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complejos);

        spinner = (Spinner) findViewById(R.id.Type);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        ope = 0;
        Res = new Complejo(0, 0);
        Raiz = new Complejo(0, 0);
        btnGra = (Button) findViewById(R.id.Graph);
        btnGra.setEnabled(false);
        btnSh = (Button) findViewById(R.id.Sh);
        btnC = (Button) findViewById(R.id.C);
        btnCE = (Button) findViewById(R.id.CE);
        btnCero = (Button) findViewById(R.id.Cero);
        btnUno = (Button) findViewById(R.id.Uno);
        btnDos = (Button) findViewById(R.id.Dos);
        btnTres = (Button) findViewById(R.id.Tres);
        btnCuatro = (Button) findViewById(R.id.Cuatro);
        btnCinco = (Button) findViewById(R.id.Cinco);
        btnSeis = (Button) findViewById(R.id.Seis);
        btnSiete = (Button) findViewById(R.id.Siete);
        btnOcho = (Button) findViewById(R.id.Ocho);
        btnNueve = (Button) findViewById(R.id.Nueve);
        btnSuma = (Button) findViewById(R.id.Mas);
        btnResta = (Button) findViewById(R.id.Menos);
        btnMultiplica = (Button) findViewById(R.id.Por);
        btnDivide = (Button) findViewById(R.id.Entre);
        Resultado = (TextView) findViewById(R.id.Etiqueta);




        Resultados = (TextView) findViewById(R.id.Resultado);
        Resultados.setMovementMethod(new ScrollingMovementMethod());
        Resultado.setMovementMethod(new ScrollingMovementMethod());
        btnPunto = (Button) findViewById(R.id.Punto);

        btnIgual = (Button) findViewById(R.id.Igual);
        btnRaiz = (Button) findViewById(R.id.Raiz);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                              @Override
                                              public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                                                  texto = spinner.getSelectedItem().toString();

                                              }

                                              @Override
                                              public void onNothingSelected(AdapterView<?> parentView) {
                                                  // your code here
                                              }
                                          }
        );

        btnSh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (indice == 0) {
                    btnCero.setText("i");
                    btnUno.setText("^");
                    btnDos.setText("e");
                    btnTres.setText("z'");
                    btnCuatro.setText("(");
                    btnCinco.setText(")");
                    btnSeis.setText("|z|");
                    btnSiete.setText("sen");
                    btnOcho.setText("cos");
                    btnNueve.setText("°");

                    btnPunto.setText("Ans");
                    //btnPunto.setEnabled(false);
                    indice = 1;
                } else {
                    btnCero.setText("0");
                    btnUno.setText("1");
                    btnDos.setText("2");
                    btnTres.setText("3");
                    btnCuatro.setText("4");
                    btnCinco.setText("5");
                    btnSeis.setText("6");
                    btnSiete.setText("7");
                    btnOcho.setText("8");
                    btnNueve.setText("9");
                    //btnNueve.setEnabled(true);
                    btnPunto.setText(".");
                    indice = 0;
                }

            }
        });
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resultado.setText("");
                cont = 0;
                Resultados.setText("");
                btnGra.setEnabled(false);
                //btnPunto.setEnabled(false);
                Res = new Complejo(0, 0);


            }
        });

        btnCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Resultado.setText(removeLastCharRegex(Resultado.getText().toString()));
                Resultados.setText("");
                btnGra.setEnabled(false);
                //btnPunto.setEnabled(false);
                Res = new Complejo(0, 0);


            }
        });

        btnCero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (indice == 1) {
                    Resultado.setText(setPantalla("i"));
                } else {
                    Resultado.setText(setPantalla("0"));
                }

            }
        });

        btnUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (indice == 1) {
                    Resultado.setText(setPantalla("^"));
                } else {
                    Resultado.setText(setPantalla("1"));
                }

            }
        });

        btnDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (indice == 1) {
                    Resultado.setText(setPantalla("e"));
                } else {
                    Resultado.setText(setPantalla("2"));
                }


            }
        });

        btnTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (indice == 1) {
                    Resultado.setText(setPantalla("'"));
                } else {

                    Resultado.setText(setPantalla("3"));
                }
            }
        });

        btnCuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (indice == 1) {
                    Resultado.setText(setPantalla("("));
                } else {
                    Resultado.setText(setPantalla("4"));
                }
            }
        });

        btnCinco.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (indice == 1) {
                    Resultado.setText(setPantalla(")"));
                } else {
                    Resultado.setText(setPantalla("5"));
                }
            }
        });

        btnSeis.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (indice == 1) {
                    Resultado.setText("|" + setPantalla("|"));

                } else {
                    Resultado.setText(setPantalla("6"));
                }
            }
        });
        btnSiete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (indice == 1) {
                    Resultado.setText(setPantalla("sen("));
                } else {
                    Resultado.setText(setPantalla("7"));
                }
            }
        });

        btnOcho.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (indice == 1) {
                    Resultado.setText(setPantalla("cos("));
                } else {
                    Resultado.setText(setPantalla("8"));
                }
            }
        });

        btnNueve.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (indice == 1) {
                    Resultado.setText(setPantalla("°"));
                } else {
                    Resultado.setText(setPantalla("9"));
                }
            }
        });

        btnSuma.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Resultado.setText(setPantalla("+"));
            }
        });

        btnResta.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Resultado.setText(setPantalla("-"));
            }
        });

        btnMultiplica.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Resultado.setText(setPantalla("x"));
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Resultado.setText(setPantalla("/"));
            }
        });

        btnPunto.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (indice == 1) {
                    Resultado.setText("ANS");

                   Aux=Res;
                   Auxs=ResR;
                  //btnPunto.setEnabled(false);
                } else {
                    Resultado.setText(setPantalla("."));

                }
            }
        });
        btnRaiz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Resultado.setText(setPantalla("√"));

            }
        });

        btnIgual.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pantalla = Resultado.getText().toString() + " ";
                String Res1 = "";
                if(Resultado.getText().toString().equals("ANS"))
                {
                    Res=Aux;
                    if ((adapter.getItem(0).toString().equals(texto))) {
                        type = 1;}
                        else if ((adapter.getItem(1).toString().equals(texto))) {
                    type = 2;
                } else if ((adapter.getItem(2).toString().equals(texto))) {
                    type = 3;
                }
                    Resultados.setText(Res.imprimir(type));
                }
                else if (comprobar() == true) {

                    if (ope == 1) {
                        for (int i = 0; i < ResR.length; i++) {
                            Res1 += "w" + i + "=" + ResR[i].imprimir(type) + '\n';
                        }
                        Resultados.setText(Res1);


                    } else if (ope == 2) {
                        btnGra.setEnabled(false);

                        Resultados.setText(Math.round(Res2)+ "");
                    } else {
                        Resultados.setText(Res.imprimir(type));

                    }


                    btnGra.setEnabled(true);
                   // btnPunto.setEnabled(true);
                } else {

                    Resultados.setText("Syntax Error");
                    btnGra.setEnabled(false);
                  //  btnPunto.setEnabled(false);
                }
                cont = 0;
            }

        });

        btnGra.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Complejos.this, MainActivity.class);
                intent.putExtra("x", "" + Res.getX());
                intent.putExtra("y", "" + Res.getY());
                intent.putExtra("ope", "" + ope);
                intent.putExtra("raizX", "" + Raiz.getX());
                intent.putExtra("raizY", "" + Raiz.getY());
                intent.putExtra("raizn", "" + Raizn);
                startActivity(intent);
            }
        });

    }


    public boolean comprobar() {
        //el tipo de entrada y si es valida
        String ope;
        char dato = leerDato(); //comenzar a leer lo que hay en pantalla
        String aux = "";
        //if (adapter.getItem(0).toString().equals(texto)) {
        //type = 1;//tipo de entrada
        //--------------------------------------

        Complejo a = getComplejo(dato);
        if (a != null) {
            Res = a;
            aux = leerDato() + "";
            if (aux.equals(simbolos[3]) || aux.equals(simbolos[4]) || aux.equals(simbolos[5]) || aux.equals(simbolos[6]))// + - x /
            {
                ope = aux;
                dato = leerDato();
                Complejo b = getComplejo(dato);
                if (b != null) {

                    //cumplen las forma y mandar a operacion
                    //Res=a.Resta(a,b);
                    operacion(ope, a, b, 0);

                    return true;
                }


            } else if (aux.equals(simbolos[11])) {
                ope = aux;
                String auxi = leerDato() + "";
                if (auxi.equals(simbolos[0])) //(
                {
                    dato = leerDato();//pedimos otro caracter

                    if (dato >= 49 && dato <= 57 || dato == 45) //[1-9] ó -
                    {
                        aux = "" + dato;
                        dato = leerDato();
                        while (dato >= 48 && dato <= 57)//[0-9]+
                        {
                            aux += dato;
                            dato = leerDato();
                            //)?

                        }
                        int n = Integer.parseInt(aux);
                        auxi = dato + "";
                        if (auxi.equals(simbolos[1])) //)
                        {
                            operacion(ope, a, null, n);

                            return true;

                        }
                    }
                }
            } else if (aux.equals(simbolos[14]))//'
            {

                operacion(aux, a, null, 0);
                return true;
            }
            else{
                Res=a;
                operacion("0", a, null, 0);
                return true;
            }


        } else {
            cont = 0;
            String auxi = leerDato() + "";
            if (auxi.equals(simbolos[0])) //(
            {
                dato = leerDato();//pedimos otro caracter

                //-----------Comprobamos si es un numero
                aux = "";
                int result = 0;


                if (dato >= 49 && dato <= 57 || dato == 45) //[1-9] ó -
                {
                    aux = "" + dato;
                    dato = leerDato();
                    while (dato >= 48 && dato <= 57)//[0-9]+
                    {
                        aux += dato;
                        dato = leerDato();
                        //)?

                    }
                    result = Integer.parseInt(aux);
                    cont--;
                    auxi = leerDato() + "";
                    if (auxi.equals(simbolos[1])) //)
                    {
                        auxi = leerDato() + "";

                        if (auxi.equals(simbolos[13])) //raiz
                        {
                            ope = auxi;
                            Raiz = getComplejo(leerDato());
                            if (Raiz != null) {
                                operacion(ope, Raiz, null, result);
                                Raizn = result;
                                return true;
                            }

                        }
                    }
                }

            } else if (auxi.equals(simbolos[15])) {
                Complejo d = getComplejo(leerDato());
                if (d != null) {
                    auxi = leerDato() + "";
                    if (auxi.equals(simbolos[15])) {
                        operacion("|", d, null, 0);
                        return true;

                    }
                }

            }
        }
        return false;


    }

    //------------------------------------------
    public Complejo getComplejo(char dato) {
        Complejo a = new Complejo();
        String auxi = dato + "";

        if ((adapter.getItem(0).toString().equals(texto))) {
            type = 1;

            if (auxi.equals(simbolos[0])) //(
            {
                dato = leerDato();//pedimos otro caracter

                //-----------Comprobamos si es x es un numero
                String aux = "";
                double result = 0;


                if (dato >= 48 && dato <= 57 || dato == 45) //[0-9] ó -
                {
                    aux = "" + dato;
                    dato = leerDato();
                    while (dato >= 48 && dato <= 57)//[0-9]+
                    {
                        aux += dato;
                        dato = leerDato();
                        //)?

                    }
                    if (dato == 46) //(\.
                    {
                        String auxs = "";
                        dato = leerDato();
                        if (dato >= 48 && dato <= 57) {//es numero
                            auxs += dato;
                            dato = leerDato();
                            while (dato >= 48 && dato <= 57)//[0-9]+
                            {
                                auxs += dato;
                                dato = leerDato();
                            }
                            aux += "." + auxs;
                        }
                    }

                    result = Double.parseDouble(aux);
                    cont--;
                    //a= new Complejo();

                }

                dato = leerDato();//pedimos otro caracter
                auxi = dato + "";
                if (auxi.equals(simbolos[3]) || auxi.equals(simbolos[4])) {
                    a.setX(result);
                    if (auxi.equals(simbolos[4])) {
                        cont--;
                    }
                    dato = leerDato();//pedimos otro caracter

                    //-----------Comprobamos si es y es un numero

                    if (dato >= 48 && dato <= 57 || dato == 45) //[0-9]
                    {
                        String aux2 = "" + dato;
                        dato = leerDato();
                        while (dato >= 48 && dato <= 57)//[0-9]+
                        {
                            aux2 += dato;
                            dato = leerDato();
                            //)?

                        }
                        if (dato == 46) //(\.
                        {
                            String auxs = "";
                            dato = leerDato();
                            if (dato >= 48 && dato <= 57) {//es numero
                                auxs += dato;
                                dato = leerDato();
                                while (dato >= 48 && dato <= 57)//[0-9]+
                                {
                                    auxs += dato;
                                    dato = leerDato();
                                }
                                aux2 += "." + auxs;
                            }
                        }

                        result = Double.parseDouble(aux2);
                        cont--;
                        a.setY(result);
                        dato = leerDato();
                        auxi = dato + "";
                        if (auxi.equals(simbolos[10])) //i
                        {
                            dato = leerDato();
                            auxi = dato + "";
                            if (auxi.equals(simbolos[1])) //)
                            {
                                return a;// cumple con la forma (x+-yi)
                            }

                        }

                    }
                }
            }
        } else if ((adapter.getItem(1).toString().equals(texto))) {
            type = 2;
            //(r(cos(#)+isen(#))
            if (auxi.equals(simbolos[0])) //(
            {
                dato = leerDato();//pedimos otro caracter

                //-----------Comprobamos si es r es un numero
                String aux = "";
                double result = 0;


                if (dato >= 48 && dato <= 57 || dato == 45) //[0-9] ó -
                {
                    aux = "" + dato;
                    dato = leerDato();
                    while (dato >= 48 && dato <= 57)//[0-9]+
                    {
                        aux += dato;
                        dato = leerDato();
                        //)?

                    }
                    if (dato == 46) //(\.
                    {
                        String auxs = "";
                        dato = leerDato();
                        if (dato >= 48 && dato <= 57) {//es numero
                            auxs += dato;
                            dato = leerDato();
                            while (dato >= 48 && dato <= 57)//[0-9]+
                            {
                                auxs += dato;
                                dato = leerDato();
                            }
                            aux += "." + auxs;
                        }
                    }

                    result = Double.parseDouble(aux);
                    cont--;
                    //a= new Complejo();

                }

                dato = leerDato();//pedimos otro caracter
                auxi = dato + "";
                if (auxi.equals(simbolos[0]))//(r(
                {
                    //a.setR(result);
                    a.setR(result);
                    auxi = leerDato() + leerDato() + leerDato() + leerDato() + "";//pedimos otro caracter
//Resultado.setText(auxi);
                    if (auxi.equals("365")) //cos(
                    {
                        dato = leerDato();

                        //-----------Comprobamos si es teta es un numero

                        if (dato >= 48 && dato <= 57 || dato == 45) //[0-9]
                        {
                            String aux2 = "" + dato;
                            dato = leerDato();
                            while (dato >= 48 && dato <= 57)//[0-9]+
                            {
                                aux2 += dato;
                                dato = leerDato();
                                //)?

                            }
                            if (dato == 46) //(\.
                            {
                                String auxs = "";
                                dato = leerDato();
                                if (dato >= 48 && dato <= 57) {//es numero
                                    auxs += dato;
                                    dato = leerDato();
                                    while (dato >= 48 && dato <= 57)//[0-9]+
                                    {
                                        auxs += dato;
                                        dato = leerDato();
                                    }
                                    aux2 += "." + auxs;
                                }
                            }

                            double teta1 = Double.parseDouble(aux2);
                            cont--;
                            auxi=leerDato()+"";
                            boolean grados=false;
                            if(auxi.equals(simbolos[7]))//esta en grados
                            {
                               grados=true;
                            }else
                            {
                                cont--;
                                grados=false;
                            }
                            auxi = leerDato() + leerDato() + leerDato() + leerDato() + leerDato() + leerDato() + leerDato()+"";

                            if (auxi.equals("555")) //|)+isen(
                            {
                                dato = leerDato();

                                //-----------Comprobamos si es teta es un numero

                                if (dato >= 48 && dato <= 57 || dato == 45) //[0-9]
                                {
                                    aux2 = "" + dato;
                                    dato = leerDato();
                                    while (dato >= 48 && dato <= 57)//[0-9]+
                                    {
                                        aux2 += dato;
                                        dato = leerDato();
                                        //)?

                                    }
                                    if (dato == 46) //(\.
                                    {
                                        String auxs = "";
                                        dato = leerDato();
                                        if (dato >= 48 && dato <= 57) {//es numero
                                            auxs += dato;
                                            dato = leerDato();
                                            while (dato >= 48 && dato <= 57)//[0-9]+
                                            {
                                                auxs += dato;
                                                dato = leerDato();
                                            }
                                            aux2 += "." + auxs;
                                        }
                                    }

                                    double teta2 = Double.parseDouble(aux2);
                                    cont--;
                                    auxi=leerDato()+"";
                                    if(auxi.equals(simbolos[7]) && grados==true )
                                    {
                                        grados=true;

                                    }
                                    else
                                    {
                                        grados=false;
                                        cont--;
                                    }
                                        if (teta1==teta2)//angulos fueron iguales
                                    {
                                        auxi = leerDato() + leerDato() +leerDato()+ "";
                                        if (auxi.equals("123"))//))
                                        {
                                            if(grados==true)
                                            {
                                            a.setO(teta1);
                                            }
                                            else {
                                                a.setO(teta1*57.2958);
                                            }
                                            return a;// cumple con la forma (r(cos(#)+isen(#)))


                                        }


                                    }
                                }
                            }


                        }
                    }
                }

            }
        }else if ((adapter.getItem(2).toString().equals(texto))) {
            type = 3;
            //e^(#)i
           // String[] simbolos = {"(", ")", ",", "+", "-", "x", "/", "°", "c", "e", "i", "^", "π", "√", "'", "|"};
            cont=0;
            dato=leerDato();

            if (dato >= 48 && dato <= 57 || dato == 45) //[0-9] ó -
            {
                String aux = "" + dato;
                dato = leerDato();
                while (dato >= 48 && dato <= 57)//[0-9]+
                {
                    aux += dato;
                    dato = leerDato();
                    //)?

                }
                if (dato == 46) //(\.
                {
                    String auxs = "";
                    dato = leerDato();
                    if (dato >= 48 && dato <= 57) {//es numero
                        auxs += dato;
                        dato = leerDato();
                        while (dato >= 48 && dato <= 57)//[0-9]+
                        {
                            auxs += dato;
                            dato = leerDato();
                        }
                        aux += "." + auxs;
                    }
                }

                double r = Double.parseDouble(aux);
                cont--;
                auxi=leerDato()+"";

            if (auxi.equals(simbolos[9])) //e
            {
                a.setR(r);

                auxi=leerDato()+"";

                if (auxi.equals(simbolos[11])) //^
                {
                    auxi=leerDato()+"";

                    if (auxi.equals(simbolos[0])) //(
                    {

                dato = leerDato();//pedimos otro caracter

                //-----------Comprobamos si es r es un numero

               if (dato >= 48 && dato <= 57 || dato == 45) //[0-9] ó -
                {
                    aux = "" + dato;
                    dato = leerDato();
                    while (dato >= 48 && dato <= 57)//[0-9]+
                    {
                        aux += dato;
                        dato = leerDato();
                        //)?

                    }
                    if (dato == 46) //(\.
                    {
                        String auxs = "";
                        dato = leerDato();
                        if (dato >= 48 && dato <= 57) {//es numero
                            auxs += dato;
                            dato = leerDato();
                            while (dato >= 48 && dato <= 57)//[0-9]+
                            {
                                auxs += dato;
                                dato = leerDato();
                            }
                            aux += "." + auxs;
                        }
                    }

                    double teta1 = Double.parseDouble(aux);
                    cont--;

                auxi=leerDato()+"";
                        boolean grados=false;
                        if(auxi.equals(simbolos[7]))//esta en grados
                        {
                            grados=true;
                        }else
                        {
                            cont--;
                            grados=false;
                        }

                dato = leerDato();//pedimos otro caracter
                auxi = dato + "";

                if (auxi.equals(simbolos[1]))//)
                {
                    auxi = leerDato() + "";
                    if (auxi.equals(simbolos[10]))//i
                    {
                        if (grados == true) {
                            a.setO(Math.toRadians(teta1));
                        } else {
                            a.setO(teta1);
                        }
                        return a;
                    }
                }}}}}}}

      return null;

        }

    public static String removeLastCharRegex(String s) {
        return (s == null) ? null : s.replaceAll(".$", "");
    }

    public void operacion(String ope,Complejo a,Complejo b,int n) {
        if (type == 1 ) {
           if(a!=null) a.toTrigo();
            if (b!=null)b.toTrigo();
        } else {
            if(a!=null)a.toalgebraica();
            if (b!=null)b.toalgebraica();
        }

/*if(b!=null)
{
    b.toTrigo();
}*/
if(ope.equals(simbolos[3]))
{
    Res=a.Suma(a,b);
    this.ope=0;

}else if(ope.equals(simbolos[4]))
{
    Res=a.Resta(a,b);
    this.ope=0;

}else if(ope.equals(simbolos[5]))
{
    Res=a.Multiplicacion(Res,b);
    this.ope=0;

}
else if(ope.equals(simbolos[6]))
{
    Res=a.Division(a,b,type);
    this.ope=0;

}
else if(ope.equals(simbolos[13]))
{
    ResR=a.Raiz(a,n);
    this.ope=1;

}
else if(ope.equals(simbolos[11]))
{
    Res=a.Elevado(a,n);
    this.ope=0;

}
else if(ope.equals(simbolos[14]))
{
    Res=a.Conjugado(a);
    this.ope=0;

}
else if(ope.equals(simbolos[15]))
{
    Res2=a.Modulo(a);
    this.ope=2;

}
    }

public char leerDato() {
    cont++;
    return this.pantalla.charAt(cont - 1);

}
    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }



}
