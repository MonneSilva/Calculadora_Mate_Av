package com.example.montserratsilva.calculadora_mate_av;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {
    Button btnComplejos,btnIntegrales,btnRK4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnComplejos=(Button) findViewById(R.id.btnComplej);
        btnIntegrales=(Button) findViewById(R.id.btnInteg);
        btnRK4=(Button) findViewById(R.id.btnRK4);
        btnComplejos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Complejos.class);
                startActivity(intent);

            }
        });
        btnIntegrales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Integrales.class);
                startActivity(intent);

            }
        });
        btnRK4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, RK4.class);
                startActivity(intent);

            }
        });

    }
}
