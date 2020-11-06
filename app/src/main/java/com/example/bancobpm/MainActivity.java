package com.example.bancobpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progress;
    private EditText usuario;
    private EditText pass;
    private Button btnlog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progress = (ProgressBar)findViewById(R.id.progressBar);
        usuario = (EditText)findViewById(R.id.et_usuario);
        pass = (EditText)findViewById(R.id.ed_pass);
        progress.setVisibility(View.INVISIBLE);
        btnlog=(Button)findViewById(R.id.btn_log);

        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usu = usuario.getText().toString();
                String con = pass.getText().toString();
                if(!usu.equalsIgnoreCase("android") || !con.equalsIgnoreCase("123"))
                {

                    usuario.setText("usuario o contraseña invalida ");


                }else
                {
                    new Task().execute();
                }
            }
        });

    }



    class Task extends AsyncTask<String, Void ,String>{

        @Override
        protected void onPreExecute() {
            progress.setVisibility(View.VISIBLE);
        }


        @Override
        protected String doInBackground(String... string) {

            for (int i = 1; i <=10; i++) {
                try {
                    Thread.sleep(1000);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }



        @Override
        protected void onPostExecute(String s) {
            progress.setVisibility(View.INVISIBLE);
            Intent i = new Intent(getBaseContext(), home_act.class);
            startActivity(i);
        }
    }


}