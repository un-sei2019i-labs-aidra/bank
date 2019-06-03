package com.example.bankapp2.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.bankapp2.R;

public class DosActivity extends AppCompatActivity {

    ImageView im_salir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bienvenido_ui);

        im_salir = (ImageView) findViewById(R.id.im_salir);
        im_salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
                //finishAffinity();
                System.exit(0);
            }
        });

    }

}
