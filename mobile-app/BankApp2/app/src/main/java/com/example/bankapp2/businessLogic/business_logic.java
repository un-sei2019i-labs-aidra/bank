package com.example.bankapp2.businessLogic;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.bankapp2.R;
import com.example.bankapp2.businessLogic.controllers.SendMoney;
import com.example.bankapp2.dataAccess.database.Database;
import com.example.bankapp2.presentation.DosActivity;

public class business_logic extends AppCompatActivity {


    // Se definen las vistas con sus tipos de variables
    private Button v_aceptar;
    private EditText v_usuario;
    private EditText v_password;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.presentation);

        //Vistas, hacen referencia a los elementos creados en la UI
        v_aceptar = (Button)findViewById(R.id.btn_entrar);
        v_usuario= (EditText)findViewById(R.id.txt_user);
        v_password= (EditText)findViewById(R.id.txt_password);

        //Conexión Base de datos
        //Database aplicacion = new Database(this,"aplicacion", null, 1);
        //db = aplicacion.getWritableDatabase();

        v_aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String query= "select id_sistema,contraseña from user where id_sistema = "+v_usuario.getText().toString()+" and password = "+v_password.getText().toString()+"";
                Toast.makeText(getApplicationContext(), "Si existe", Toast.LENGTH_SHORT).show();
                business_logic.this.startActivity(new Intent(getApplicationContext(),DosActivity.class));
                //Intent i = new Intent(business_logic.this, DosActivity.class);
                //Intent DosActivity = new Intent(getApplicationContext(), DosActivity.class);
                //startActivity(DosActivity);
            }
        });

    }
}












/*
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bankapp2.dataAccess.database.Database;

public class business_logic extends AppCompatActivity {


    // Se definen las vistas con sus tipos de variables
    private Button v_aceptar;
    private EditText v_usuario;
    private EditText v_password;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.presentation);

        //Vistas, hacen referencia a los elementos creados en la UI
        v_aceptar = (Button)findViewById(R.id.btn_entrar);
        v_usuario= (EditText)findViewById(R.id.txt_user);
        v_password= (EditText)findViewById(R.id.txt_password);

        //Conexión Base de datos
        Database aplicacion = new Database(this,"aplicacion", null, 2);
        db = aplicacion.getWritableDatabase();

        v_aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String query= "select usuario,password from Usuarios where usuario = "+v_usuario.getText().toString()+" and password = "+v_password.getText().toString()+"";

                //movernos en la base de datos: Cursor
                Cursor c = db.rawQuery(query, null);

                //Al hacer login se activa
                if (c.getCount() > 0){
                    Toast.makeText(getApplicationContext(), "Si existe", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(business_logic.this, DosActivity.class);
                    startActivity(i);

                }else{
                    Toast.makeText(getApplicationContext(), "No existe", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}*/