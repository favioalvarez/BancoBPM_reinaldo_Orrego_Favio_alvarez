package com.example.bancobpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class home_act extends AppCompatActivity {
    private ViewFlipper vf;
    private int[]images={R.drawable.a, R.drawable.b, R.drawable.c};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_act);

        vf=(ViewFlipper)findViewById(R.id.slider);

        for(int i=0;i <images.length; i++)
        {
            Flip_image(images[i]);
        }

    }
    public void Flip_image(int i)
    {
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);

        vf.addView(view);
        vf.setAutoStart(true);
        vf.setFlipInterval(2500);

        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this,android.R.anim.slide_out_right);
    }

    public void Clientes(View v)
    {
        Intent i = new Intent(this, clientes_act.class);
        startActivity(i);
    }

    public void Info(View v)
    {
        Intent i = new Intent(this, info_act.class);
        startActivity(i);
    }

    public void Calculo(View v)
    {
        ArrayList<String> clientes = new ArrayList<String>();
        ArrayList<String> credito = new ArrayList<String>();

        clientes.add("ELIGE UNA OPCION");
        clientes.add("Axel");
        clientes.add("Roxana");

        credito.add("ELIGE UNA OPCION");
        credito.add("Credito Hipotecario");
        credito.add("Credito Automotriz");

        Intent i = new Intent(this, prestamos_act.class);
        i.putExtra("listaClientes",clientes);
        i.putExtra("listaCreditos",credito);
        startActivity(i);
    }

    public void Seguridad(View v)
    {
        Intent i = new Intent(this,seguridad_act.class);
        startActivity(i);
    }
}