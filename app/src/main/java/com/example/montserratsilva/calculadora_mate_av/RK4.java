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
import android.widget.TableLayout;
import android.widget.TextView;

import com.singularsys.jep.Jep;
import com.singularsys.jep.JepException;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class RK4 extends AppCompatActivity {
    TextView Text;
    EditText fx, h, x0, y0,xn;
    Button btnCalcu;
    Spinner spinner;
    String type;
    ArrayAdapter<CharSequence> adapter;
    CheckBox cB;
    Jep jep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rk4);
        fx = (EditText) findViewById(R.id.fx);

        h = (EditText) findViewById(R.id.Paso);
        x0 = (EditText) findViewById(R.id.X0);
        y0 = (EditText) findViewById(R.id.V_ini);
        xn = (EditText) findViewById(R.id.Xn);

        Text = (TextView) findViewById(R.id.Text);


        btnCalcu = (Button) findViewById(R.id.btnCalcu);

        btnCalcu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rk4();


            }
        });


    }
    public void imprimir(int N,double t[],double y[])
    {
        DecimalFormat df = new DecimalFormat("0.00");

        Tabla tabla = new Tabla(this, (TableLayout)findViewById(R.id.tabla));
        tabla.agregarCabecera(R.array.cabecera_tabla);
        for(int i = 0; i < N; i++)
        {
            ArrayList<String> elementos = new ArrayList<String>();
            //elementos.add(Integer.toString(i));
            elementos.add(i+"");
            elementos.add(df.format(t[i]));
            elementos.add(y[i]+"");
            //elementos.add();
            tabla.agregarFilaTabla(elementos);
        }
    }
    public double evaluar(double x,double y,String funtion)
    {
        try {
            jep.addVariable("x",x);
            jep.addVariable("y",y);
            jep.parse(funtion);
            Object result = jep.evaluate();
            return Double.parseDouble(result.toString());
        } catch (JepException e) {
            Text.setText("An error occurred: " + e.getMessage());
            return 0;

        }
    }
    public void rk4()
    {
        jep = new Jep();
        try {
            jep.parse(this.h.getText().toString());
            Object result = jep.evaluate();
            double h= Double.parseDouble(result.toString());
            jep.parse(this.x0.getText().toString());
            result = jep.evaluate();
            double x0= Double.parseDouble(result.toString());
            jep.parse(this.y0.getText().toString());
            result = jep.evaluate();
            double y0= Double.parseDouble(result.toString());
            jep.parse(this.xn.getText().toString());
            result = jep.evaluate();
            double xn= Double.parseDouble(result.toString());
            int N=(int)((xn-x0)/h)+1;

            double t[]=new double[N];
            double k[]=new double[4];
            double y[]=new double[N];
            y[0]=y0;
            t[0]=x0;

            String function=fx.getText().toString();
            for(int i=0;i<N-1;i++)
            {
                t[i+1]=x0+((i+1)*h);
                k[0]=h*evaluar(t[i],y[i],function);
                k[1]=h*evaluar(t[i]+((0.5)*h),y[i]+((0.5)*k[0]),function);
                k[2]=h*evaluar(t[i]+((0.5)*h),y[i]+((0.5)*k[1]),function);
                k[3]=h*evaluar(t[i]+h,y[i]+k[2],function);
                double l=((k[0]+(2*k[1])+(2*k[2])+k[3]));
                double p=0.166666;
                y[i+1]=y[i]+(p*l);


            }
          imprimir(N,t,y);



        } catch (JepException e) {
            Text.setText("An error occurred: " + e.getMessage());


        }
    }
}

