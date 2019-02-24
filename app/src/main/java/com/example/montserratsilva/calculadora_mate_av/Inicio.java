package com.example.montserratsilva.calculadora_mate_av;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Inicio extends AppCompatActivity {
   Button btnGra,btnSh,btnPa1,btnPa2,btnC,btnCE, btnCero,btnUno,btnDos,btnTres,btnCuatro,btnCinco,btnSeis,btnSiete,
    btnOcho,btnNueve,btnSuma,btnResta,btnMultiplica,btnDivide,btnPunto,btnIgual;
   TextView Resultado;
    int indice=0;

   public String getPantalla(String string)
   {
       return Resultado.getText().toString()+string;
   }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        String mostrar;
        //Spinner
        Spinner spinner = (Spinner) findViewById(R.id.Type);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        //item seleccionado spinner.getSelectedItem()
        btnGra= (Button)findViewById(R.id.Graph);
        btnSh= (Button)findViewById(R.id.Sh);
        btnC= (Button)findViewById(R.id.C);
        btnCE= (Button)findViewById(R.id.CE);
        btnCero= (Button)findViewById(R.id.Cero);
        btnUno = (Button)findViewById(R.id.Uno);
        btnDos = (Button)findViewById(R.id.Dos);
        btnTres = (Button)findViewById(R.id.Tres);
        btnCuatro = (Button)findViewById(R.id.Cuatro);
        btnCinco = (Button)findViewById(R.id.Cinco);
        btnSeis = (Button)findViewById(R.id.Seis);
        btnSiete = (Button)findViewById(R.id.Siete);
        btnOcho = (Button)findViewById(R.id.Ocho);
        btnNueve = (Button)findViewById(R.id.Nueve);
        btnSuma = (Button)findViewById(R.id.Mas);
        btnResta = (Button)findViewById(R.id.Menos);
        btnMultiplica = (Button)findViewById(R.id.Por);
        btnDivide = (Button)findViewById(R.id.Entre);
        Resultado = (TextView)findViewById(R.id.Etiqueta);
        btnPunto = (Button)findViewById(R.id.Punto);
        btnIgual = (Button)findViewById(R.id.Igual);

        btnSh.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (indice==0)
                {
                    btnCero.setText("i");
                    btnUno.setText("^");
                    btnDos.setText("e");
                    btnTres.setText("z'");
                    btnCuatro.setText("(");
                    btnCinco.setText(")");
                    btnSeis.setText("|z|");
                    btnSiete.setText("sen()");
                    btnOcho.setText("cos()");
                    btnNueve.setText("π");
                    btnPunto.setText(",");
                    indice=1;
                }else
                {
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
                    btnPunto.setText(".");
                    indice=0;
                }

            }
        });
       btnC.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Resultado.setText("");
            }
        });

        btnCE.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Resultado.setText(getPantalla("CE"));
            }
        });

        btnCero.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (indice==1)
                {
                    Resultado.setText(getPantalla("i"));
                }else
                {
                    Resultado.setText(getPantalla("0"));
                }

            }
        });

        btnUno.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (indice==1)
                {
                    Resultado.setText(getPantalla("^"));
                }else
                {
                    Resultado.setText(getPantalla("1"));
                }

            }
        });

        btnDos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (indice==1)
                {
                    Resultado.setText(getPantalla("e"));
                }else
                {
                    Resultado.setText(getPantalla("2"));
                }


            }
        });

        btnTres.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (indice==1)
                {

                }else
                {
                    Resultado.setText(getPantalla("3"));
                }
            }
        });

        btnCuatro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (indice==1)
                {
                    Resultado.setText(getPantalla("("));
                }else
                {
                    Resultado.setText(getPantalla("4"));
                }
            }
        });

        btnCinco.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (indice==1)
                {
                    Resultado.setText(getPantalla(")"));
                }else
                {
                    Resultado.setText(getPantalla("5"));
                }
            }
        });

        btnSeis.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (indice==1)
                {

                }else
                {
                    Resultado.setText(getPantalla("6"));
                }
            }
        });
        btnSiete.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (indice==1)
                {
                    Resultado.setText(getPantalla("sen()"));
                }else
                {
                    Resultado.setText(getPantalla("7"));
                }
            }
        });

        btnOcho.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (indice==1)
                {
                    Resultado.setText(getPantalla("cos()"));
                }else
                {
                    Resultado.setText(getPantalla("8"));
                }
            }
        });

        btnNueve.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (indice==1)
                {
                    Resultado.setText(getPantalla("π"));
                }else
                {
                    Resultado.setText(getPantalla("9"));
                }
            }
        });

        btnSuma.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Resultado.setText(getPantalla("+"));
            }
        });

        btnResta.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Resultado.setText(getPantalla("-"));
            }
        });

        btnMultiplica.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Resultado.setText(getPantalla("x"));
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Resultado.setText(getPantalla("/"));
            }
        });

        btnPunto.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (indice==1)
                {
                    Resultado.setText(getPantalla(","));
                }else
                {
                    Resultado.setText(getPantalla("."));
                }
            }
        });

        btnIgual.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Resultado.setText(getPantalla("="));

            }
        });
        btnGra.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(Inicio.this, MainActivity.class);
                intent.putExtra("x","-3");
                intent.putExtra("y","-2");
                startActivity(intent);
            }
        });


    }
}
