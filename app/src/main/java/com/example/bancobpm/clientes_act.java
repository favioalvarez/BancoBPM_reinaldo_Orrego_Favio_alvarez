package com.example.bancobpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Clases.AdminSQLiteOpenHelper;

public class clientes_act extends AppCompatActivity {

    private EditText ecodigo, enombre, esalario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_act);

        ecodigo=(EditText)findViewById(R.id.ed_codigo);
        enombre=(EditText)findViewById(R.id.ed_nombre);
        esalario=(EditText)findViewById(R.id.ed_salario);

    }

    public void AñadirCliente(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = ecodigo.getText().toString();

        if(!codigo.isEmpty())
        {
            ContentValues cont = new ContentValues();
            cont.put("codigo",ecodigo.getText().toString());
            cont.put("nombre",enombre.getText().toString());
            cont.put("salario",esalario.getText().toString());

            db.insert("clientes",null, cont);
            db.close();
            Toast.makeText(this,"¡ha Agregado un nuevo cliente!",Toast.LENGTH_LONG).show();

        }else
        {
            Toast.makeText(this,"debe ingresar un codigo",Toast.LENGTH_LONG).show();
        }
    }

    public void MostrarClientes(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"fichero", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = ecodigo.getText().toString();

        if(!codigo.isEmpty())
        {
            Cursor fila = db.rawQuery("SELECT nombre, salario FROM clientes WHERE codigo ="+codigo,null);
            if(fila.moveToFirst())
            {
                enombre.setText(fila.getString(0));
                esalario.setText(fila.getString(1));
                fila.close();
            }
        }else
        {
            Toast.makeText(this,"no hay cliente asosiado al codigo",Toast.LENGTH_LONG).show();
        }
    }

    public void EliminarCliente(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"fichero", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = ecodigo.getText().toString();

        db.delete("clientes","codigo="+codigo,null);
        db.close();

        Toast.makeText(this,"¡Haz eliminado al cliente ",Toast.LENGTH_LONG).show();
        ecodigo.setText("");
        enombre.setText("");
        esalario.setText("");

    }

    public void ActualizarClientes(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"fichero", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = ecodigo.getText().toString();

        ContentValues cont = new ContentValues();

        cont.put("codigo", ecodigo.getText().toString());
        cont.put("nombre", enombre.getText().toString());
        cont.put("salario", esalario.getText().toString());

        if(!codigo.isEmpty())
        {
            db.update("clientes", cont,"codigo="+ codigo,null);
            db.close();
            Toast.makeText(this,"¡Haz actualizado al cliente",Toast.LENGTH_LONG).show();
        }
    }
}