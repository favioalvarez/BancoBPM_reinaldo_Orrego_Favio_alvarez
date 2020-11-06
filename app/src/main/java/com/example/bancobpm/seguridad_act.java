package com.example.bancobpm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class seguridad_act extends AppCompatActivity {

    private EditText econtraseña;
    private TextView tv_encriptado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seguridad_act);

        econtraseña = (EditText)findViewById(R.id.et_contraseña1);
        tv_encriptado= (TextView)findViewById(R.id.tv_encriptacion);

    }

    private SecretKeySpec GenerarLlave(String password)throws Exception{

        MessageDigest sh = MessageDigest.getInstance("SHA-256");
        byte[] llave =password.getBytes("UTF-8");
        llave = sh.digest(llave);

        SecretKeySpec llaveSecreta = new SecretKeySpec(llave,"AES");

        return llaveSecreta;

    }

    public String Encriptar(String datos, String password)throws Exception{

        if (!econtraseña.getText().toString().isEmpty())
        {
            SecretKeySpec secretKey = GenerarLlave(password);
            Cipher cifher = Cipher.getInstance("AES");
            cifher.init(Cipher.ENCRYPT_MODE, secretKey );

            byte[] datosEncriptadosByte = cifher.doFinal(datos.getBytes());
            String datosEncriptadosString = Base64.encodeToString(datosEncriptadosByte, Base64.DEFAULT);

            return datosEncriptadosString;

        }else
        {
            Toast.makeText(this, "Debe ingresar una contraseña", Toast.LENGTH_SHORT).show();
            return null;
        }
    }
    public void Encriptar(View v)
    {
        try {
            String mensaje = Encriptar(econtraseña.getText().toString(), tv_encriptado.getText().toString());
            tv_encriptado.setText(mensaje);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}