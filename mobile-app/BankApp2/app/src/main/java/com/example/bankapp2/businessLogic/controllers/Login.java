package com.example.bankapp2.businessLogic.controllers;

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
import com.example.bankapp2.dataAccess.database.Database;
import com.example.bankapp2.dataAccess.repositories.UserRepository;
import com.example.bankapp2.presentation.DosActivity;

public class Login extends AppCompatActivity {

    // Se definen las vistas con sus tipos de variables
    private Button v_aceptar;
    private EditText v_usuario;
    private EditText v_password;

    private SQLiteDatabase db;
    private UserRepository db2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.presentation);
        //Vistas, hacen referencia a los elementos creados en la UI
        v_aceptar = (Button)findViewById(R.id.btn_entrar);
        v_usuario= (EditText)findViewById(R.id.txt_user);
        v_password= (EditText)findViewById(R.id.txt_password);

        //Conexión Base de datos
        Database aplicacion = new Database(getApplicationContext());
        db = aplicacion.getWritableDatabase();

        v_aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String query= "select id_sistema,contraseña from user where id_sistema = "+v_usuario.getText().toString()+" and contraseña = "+v_password.getText().toString()+"";

                //movernos en la base de datos: Cursor
                Cursor c = db.rawQuery(query, null);

                //Al hacer login se activa
                if (c.getCount() > 0){
                    Toast.makeText(getApplicationContext(), "Si existe", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(Login.this, DosActivity.class);
                    startActivity(i);

                }else{
                    Toast.makeText(getApplicationContext(), "No existe", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
