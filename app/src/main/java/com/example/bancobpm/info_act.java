package com.example.bancobpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class info_act extends AppCompatActivity {
    private VideoView videoW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_act);

        videoW = (VideoView)findViewById(R.id.v_v);

        String ruta = "android.resource://"+ getPackageName()+ "/"+R.raw.video;
        Uri uri= Uri.parse(ruta);
        videoW.setVideoURI(uri);

        MediaController media = new MediaController(this);
        videoW.setMediaController(media);
    }

    public void Mapa(View v)
    {
        Intent i = new Intent(this,maps_act.class);
        startActivity(i);
    }
}