package com.example.bancobpm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import Clases.Cliente;
import Clases.Creditos;

public class prestamos_act extends AppCompatActivity {
    private Spinner sp_cliente, sp_credito;
    private TextView txt_total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestamos_act);
    sp_cliente = (Spinner)findViewById(R.id.sp_cli);
    sp_credito = (Spinner)findViewById(R.id.sp_cre);
    txt_total = (TextView)findViewById(R.id.tvpago);

        ArrayList<String> listaClientes =(ArrayList<String>)getIntent().getSerializableExtra("listaClientes");
        ArrayList<String> listaCreditos =(ArrayList<String>)getIntent().getSerializableExtra("listaCreditos");

        ArrayAdapter<String> adap = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listaClientes);
        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaCreditos);

        sp_cliente.setAdapter(adap);
        sp_credito.setAdapter(adapt);
    }
    public  void CalcularPrestamo(View v)
    {
        Cliente c = new Cliente();
        Creditos cred = new Creditos();

        String opcionCliente = sp_cliente.getSelectedItem().toString();
        String opcionCredito = sp_credito.getSelectedItem().toString();

        int resultado;
        if(opcionCliente.equals("ELIGE UNA OPCION")|| opcionCredito.equals("ELIGE UNA OPCION") )
        {
            Toast.makeText(this,"ingrse una opcion" , Toast.LENGTH_LONG).show();
        }else {
            if (opcionCliente.equals("Axel") && opcionCredito.equals("Credito Hipotecario")) {
                resultado = cred.getCreditoHipotecario() + c.getAxel();

                txt_total.setText("su saldo es de: " + resultado);
            }
            if (opcionCliente.equals("Axel") && opcionCredito.equals("Credito Automotriz")) {
                resultado = c.getAxel() + cred.getCreditoAutomotriz();
                txt_total.setText("su saldo es de: " + resultado);
            }
            if(opcionCliente.equals("Roxana")&&opcionCredito.equals("Credito Hipotecario"))
            {
                resultado = cred.getCreditoHipotecario() + c.getRoxana();

                txt_total.setText("su saldo es de: " + resultado);
            }
            if(opcionCliente.equals("Roxana")&&opcionCredito.equals("Credito Automotriz"))
            {
                resultado = c.getRoxana() + cred.getCreditoAutomotriz();
                txt_total.setText("su saldo es de: " + resultado);
            }
        }
    }

    public void CalcularDeudas(View v)
    {
        Cliente c = new Cliente();
        Creditos cred = new Creditos();

        String opcionCliente = sp_cliente.getSelectedItem().toString();
        String opcionCredito = sp_credito.getSelectedItem().toString();
        int resultado;

        if(opcionCliente.equals("ELIGE UNA OPCION")|| opcionCredito.equals("ELIGE UNA OPCION") )
        {
            Toast.makeText(this,"ingrse una opcion" , Toast.LENGTH_LONG).show();
        }else
         {
             if(opcionCliente.equals("Axel") && opcionCredito.equals("Credito Hipotecario"))
             {
                 resultado =(cred.getCreditoHipotecario() + c.getAxel()) / 12;
                 txt_total.setText("usted debe pagar 12 cuotas de: " + resultado);
             }
             if(opcionCliente.equals("Axel") && opcionCredito.equals("Credito Automotriz"))
             {
                 resultado=( c.getAxel()+ cred.getCreditoAutomotriz() ) / 8;
                 txt_total.setText("usted debe pagar 8 cuotas de: " + resultado);
             }
             //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::.
             if(opcionCliente.equals("Roxana") && opcionCredito.equals("Credito Hipotecario"))
             {
                 resultado =(cred.getCreditoHipotecario() + c.getRoxana()) / 12;
                 txt_total.setText("usted debe pagar 12 cuotas de: " + resultado);
             }
             if(opcionCliente.equals("Roxana") && opcionCredito.equals("Credito Automotriz"))
             {
                 resultado=( c.getRoxana() + cred.getCreditoAutomotriz() ) / 8;
                 txt_total.setText("usted debe pagar 8 cuotas de: " + resultado);
             }

         }
    }
}