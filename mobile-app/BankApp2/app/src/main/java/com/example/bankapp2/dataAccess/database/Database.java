package com.example.bankapp2.dataAccess.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.bankapp2.dataAccess.models.User;

public class Database {

        //General
        public static final String DB_NAME = "Database";
        public static final int DB_VERSION = 1;


        //Tabla Usuario
        public static final String TABLA_USUARIOS = "user";

        public static final Integer id_sistema = Integer.valueOf("id_sistema");
        public static final String nombre = "nombre";
        public static final String contraseña = "contraseña";

        public static final String TABLA_USUARIOS_SQL =
                "CREATE TABLE  " + TABLA_USUARIOS + "(" +
                        id_sistema + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        nombre + " TEXT NOT NULL," +
                        contraseña + " TEXT NOT NULL);";

        //Tabla Cuentas

        public static final String TABLA_CUENTAS = "user";

        public static final Integer id_cuenta = Integer.valueOf("id_sistema");
        public static final Double saldo = Double.valueOf("saldo");
        public static final String contraseña_c = "contraseña";

        public static final String TABLA_CUENTAS_SQL =
                "CREATE TABLE  " + TABLA_CUENTAS + "(" +
                        id_sistema + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        saldo + " TEXT NOT NULL," +
                        contraseña + " TEXT NOT NULL);";
    }





    /*

    public String[] estructura(){
        String[] datos = new String[4];
        datos[0]= "CREATE TABLE Usuarios(nombre TEXT, usuario INTEGER, password INTEGER)";
        datos[1]= "INSERT INTO Usuarios (nombre,usuario,password) VALUES('Liseth',1091666701,123456)";
        datos[2]= "INSERT INTO Usuarios (nombre,usuario,password) VALUES('Diana',1233692748,123456)";
        datos[3]= "INSERT INTO Usuarios (nombre,usuario,password) VALUES('Valeria',1030661820,123456)";
        return datos;
    }

    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
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
    }*/
