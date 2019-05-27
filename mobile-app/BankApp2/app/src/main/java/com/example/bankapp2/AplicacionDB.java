package com.example.bankapp2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AplicacionDB extends SQLiteOpenHelper {

    public String[] estructura(){
        String[] datos = new String[2];
        datos[0]= "CREATE TABLE Usuarios(nombre TEXT, usuario INTEGER, password INTEGER)";
        datos[1]= "INSERT INTO Usuarios (nombre,usuario,password) VALUES('admin',1234,123456)";
        return datos;
    }

    public AplicacionDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    //Nos permite crear la BD
    public void onCreate(SQLiteDatabase db) {
        for (int i=0; i< estructura().length; i++){
            db.execSQL(estructura()[i]);
        }
    }

    @Override
    //Permite actualizar la BD
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS Usuarios");
        for (int i=0; i< estructura().length; i++){
            db.execSQL(estructura()[i]);
        }
    }
}
