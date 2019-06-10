package com.example.bankapp2.dataAccess.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;
public class Database extends SQLiteOpenHelper {

        //General
        public static final String DATABASE_NAME = "Database";
        public static final int DATABASE_VERSION = 1;


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

        public static final String TABLA_CUENTAS = "account";

        public static final Integer id_cuenta = Integer.valueOf("id_sistema");
        public static final Integer id_usuario = Integer.valueOf("id_usuario");
        public static final Double saldo = Double.valueOf("saldo");
        public static final String contraseña_c = "contraseña";

        public static final String TABLA_CUENTAS_SQL =
                "CREATE TABLE  " + TABLA_CUENTAS + "(" +
                        id_sistema + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        id_usuario + " TEXT NOT NULL," +
                        saldo + " TEXT NOT NULL," +
                        contraseña + " TEXT NOT NULL);";

        //Tabla Transaction
        public static  final String TABLA_TRANS = "transactions";
        public static  final Integer cuenta_destino = Integer.valueOf("cuenta_destino");
        public static final  Integer cuenta_origen = Integer.valueOf("cuenta_origen");
        public static final  Date fecha = new Date();
        public static final  Integer monto = Integer.valueOf("monto");
        public static final  String status = "status";

        public static final String TABLA_TRANS_SQL =
                "CREATE TABLE  " + TABLA_TRANS + "(" +
                        id_sistema + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        cuenta_origen + " INTEGER NOT NULL," +
                        cuenta_destino + " INTEGER NOT NULL," +
                        fecha + " DATE," +
                        monto + " DOUBLE NOT NULL,"+
                        status + " TEXT NOT NULL);";

        public void onCreate(SQLiteDatabase db) {
                db.execSQL(TABLA_USUARIOS);

                db.execSQL("INSERT into TABLA_USUARIOS(id_sistema,nombre,contraseña)VALUES(1091666701,'Liseth Arévalo','123456')");
                db.execSQL("INSERT into TABLA_USUARIOS(id_sistema,nombre,contraseña)VALUES(1075681008,'Érika Cárdenas','654321')");

                db.execSQL(TABLA_CUENTAS);

                db.execSQL("INSERT INTO TABLA_CUENTAS(id_sistema,id_usuario,saldo,contraseña)VALUES(123,1091666701,500000,'123456')");
                db.execSQL("INSERT INTO TABLA_CUENTAS(id_sistema,id_usuario,saldo,contraseña)VALUES(122,1075681008,30000,'123456')");

        }
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

        }

        public Database(Context context) {
                super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }


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
