package com.example.montserratsilva.calculadora_mate_av;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.singularsys.jep.JepException;

import com.singularsys.jep.Jep;
import java.math.RoundingMode;
import java.text.DecimalFormat;



public class Integrales extends AppCompatActivity {
TextView Text;
EditText fx,a,b,n;
Button btnCalcu;
Spinner spinner;
String type;
ArrayAdapter<CharSequence> adapter;
CheckBox cB;
 Jep jep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_integrales);
        fx=(EditText)findViewById(R.id.fx);
        a=(EditText)findViewById(R.id.a);
        b=(EditText)findViewById(R.id.b);
        n=(EditText)findViewById(R.id.n);
        Text=(TextView)findViewById(R.id.Text);
        spinner = (Spinner) findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.Itype, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        cB=(CheckBox)findViewById(R.id.checkBox);


        btnCalcu=(Button) findViewById(R.id.btnCalcu);

        btnCalcu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if(cB.isChecked()==true)//sera compuesto
                    {
                        double N=Double.parseDouble(n.getText().toString());
                        if(N<0)
                        {
                            N*=-1;
                        }

                        if (type.equals("Trapecio")) {
                            trapecioCompuesto(N);

                        } else if (type.equals("Simpson 1/3")) {
                            simpsonUnTreC((int)N);
                        } else {
                            simpsonTresOch((int)N);
                        }
                    }else
                    {
                        if (type.equals("Trapecio")) {
                        trapecio();
                    } else if (type.equals("Simpson 1/3")) {
                        simpsonUnTer();
                    } else {
                        simpsonTresOch();
                    }
                    }
                //

            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                              @Override
                                              public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                                                  type = spinner.getSelectedItem().toString();

                                              }

                                              @Override
                                              public void onNothingSelected(AdapterView<?> parentView) {
                                                  // your code here
                                              }
                                          }
        );

    }
    public void imprimir(double input)
    {
        DecimalFormat df = new DecimalFormat("0.0000");

        Text.setText( df.format(input));
    }

    public double evaluar(double x,String funtion)
    {

        try {
            jep.addVariable("x",x);
            jep.parse(fx.getText().toString());
            Object result = jep.evaluate();
            return Double.parseDouble(result.toString());
        } catch (JepException e) {
            Text.setText("An error occurred: " + e.getMessage());
            return 0;

        }
    }
    public void trapecioCompuesto(double n)
    {
        jep = new Jep();
        try {
            jep.parse(this.a.getText().toString());
            Object result = jep.evaluate();
          double a= Double.parseDouble(result.toString());
            jep.parse(this.b.getText().toString());
            result = jep.evaluate();
           double b= Double.parseDouble(result.toString());

            double deltax = ((b-a)/n);
            String function=fx.getText().toString();
            double funInA=evaluar(a,function);
            double funInB=evaluar(b,function);
            double sumatoria=0;
            for(int k=1;k<=n-1;k++)
            {
                double aux= a+(k*(deltax));
                sumatoria+=(evaluar(aux,function));
            }
            double resultado=deltax*(((funInA+funInB)/2)+sumatoria);

           imprimir(resultado);


        } catch (JepException e) {
            Text.setText("An error occurred: " + e.getMessage());


        }
    }
    public void trapecio()
    {
        jep = new Jep();
        try {
            jep.parse(this.a.getText().toString());
            Object result = jep.evaluate();
            double a= Double.parseDouble(result.toString());
            jep.parse(this.b.getText().toString());
            result = jep.evaluate();
            double b= Double.parseDouble(result.toString());


            double deltax = (b-a);
            String function=fx.getText().toString();
            double funInA=evaluar(a,function);
            double funInB=evaluar(b,function);

            double resultado=deltax*((funInA+funInB)/2);

            imprimir(resultado);


        } catch (JepException e) {
            Text.setText("An error occurred: " + e.getMessage());


        }
    }

    public void simpsonUnTer()
    {
        jep = new Jep();
        try {
            jep.parse(this.a.getText().toString());
            Object result = jep.evaluate();
            double x0= Double.parseDouble(result.toString());
            jep.parse(this.b.getText().toString());
            result = jep.evaluate();
            double x2= Double.parseDouble(result.toString());

            double deltax = (x2-x0)/6;
            String function=fx.getText().toString();
            double funInX0=evaluar(x0,function);
            double funInx2=evaluar(x2,function);
            double funInx1=evaluar((x0+x2)/2,function);
            double sumatoria=0;

            double resultado=deltax*((funInX0+(4*funInx1)+funInx2));

            imprimir(resultado);


        } catch (JepException e) {
            Text.setText("An error occurred: " + e.getMessage());


        }
    }

    public void simpsonUnTreC(int n)
    {
        jep = new Jep();
        try {
            jep.parse(this.a.getText().toString());
            Object result = jep.evaluate();
            double a= Double.parseDouble(result.toString());
            jep.parse(this.b.getText().toString());
            result = jep.evaluate();
            double b= Double.parseDouble(result.toString());
///-------------------------------------------------------------------------------
            double h = ((b-a)/n);
            String function=fx.getText().toString();
            double funInX0=evaluar(a,function);
            double funInXn=evaluar(b,function);
            double funInX[]=new double[n+1];

            funInX[0]=evaluar(a,function);

            for(int k=1;k<=n;k++)
            {
                funInX[k]=evaluar(a+(h*k),function);
            }

            double aux1=0;
            for(int j=1;j<=(n-2)/2;j++)
            {
                aux1+=funInX[2*j];


            }
            double aux2=0;
            for(int j=0;j<=(n-2)/2;j++)
            {
                aux2+=funInX[(2*j)+1];
            }


            double resultado=(h/3)*(funInX0+funInXn+(2*aux1)+(4*aux2));

            imprimir(resultado);


        } catch (JepException e) {
            Text.setText("An error occurred: " + e.getMessage());


        }
    }

    public void simpsonTresOch()
    {
        jep = new Jep();
        try {
            jep.parse(this.a.getText().toString());
            Object result = jep.evaluate();
            double x0= Double.parseDouble(result.toString());
            jep.parse(this.b.getText().toString());
            result = jep.evaluate();
            double x3= Double.parseDouble(result.toString());

            double deltax = (x3-x0)/3;
            String function=fx.getText().toString();
            double funInX[]=new double[4];

            funInX[0]=evaluar(x0,function);
            funInX[1]=evaluar(((2*x0)+x3)/3,function);
            funInX[2]=evaluar((x0+(2*x3))/3,function);
            funInX[3]=evaluar(x3,function);



            double resultado=((3*deltax)/8)*(funInX[0]+(3*funInX[1])+(3*funInX[2])+funInX[3]);

            imprimir(resultado);


        } catch (JepException e) {
            Text.setText("An error occurred: " + e.getMessage());


        }
    }
    public void simpsonTresOch(int n)
    {
        jep = new Jep();
        try {
            jep.parse(this.a.getText().toString());
            Object result = jep.evaluate();
            double x0= Double.parseDouble(result.toString());
            jep.parse(this.b.getText().toString());
            result = jep.evaluate();
            double x3= Double.parseDouble(result.toString());

            double h = (x3-x0)/3;
            String function=fx.getText().toString();
            double funInX[]=new double[n+1];
            double funInXn=evaluar(x3,function);

            funInX[0]=evaluar(x0,function);

            for(int k=1;k<=n;k++)
            {
                funInX[k]=evaluar(x0+(h*k),function);
            }

            double aux1=0;
            for(int i=1;i<=n-2;i+=3)
            {
                aux1+=funInX[i];
            }
            double aux2=0;
            for(int i=2;i<=n-1;i+=3)
            {
                aux2+=funInX[i];
            }
            double aux3=0;
            for(int i=3;i<=n-3;i+=3)
            {
                aux3+=funInX[i];
            }
            double resultado=((3*h)/8)*(funInX[0]+(3*aux1)+(3*aux2)+(2*aux3)+funInXn);

            imprimir(resultado);


        } catch (JepException e) {
            Text.setText("An error occurred: " + e.getMessage());


        }
    }






}
