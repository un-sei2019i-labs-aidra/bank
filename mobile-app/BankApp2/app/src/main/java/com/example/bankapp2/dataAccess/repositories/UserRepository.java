package com.example.bankapp2.dataAccess.repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.bankapp2.MainActivity;
import com.example.bankapp2.dataAccess.database.Database;
import com.example.bankapp2.dataAccess.models.User;
import java.util.ArrayList;


public class UserRepository {
    private SQLiteDatabase db;
    private DBHelper dbHelper;

    public UserRepository(MainActivity mainActivity) {
    }

    private void openReadableDB() {
        db = dbHelper.getReadableDatabase();
    }

    private void openWriteableDB() {
        db = dbHelper.getWritableDatabase();
    }

    private void closeDB() {
        if(db!=null){
            db.close();
        }
    }

    // CRUD...

    // La clase interna DBHelper crea la base de datos en el caso de que no exista, llamando al método onCreate.
    // El método onUpgrade es utilizado para modificar la estructura de las tablas.

    private static class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(Database.TABLA_USUARIOS_SQL);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

    // Devuelve un objeto de tipo ContentValues que almacenará los valores de los atributos de un objeto Usuario
    private ContentValues clienteMapperContentValues(User user) {
        ContentValues us = new ContentValues();
        us.put(String.valueOf(Database.id_sistema), user.getId_sistema());
        us.put(Database.nombre, user.getNombre());
        us.put(Database.contraseña, user.getContraseña());
        return us;
    }


    //métodos para realizar las operaciones CRUD

    // INSERTAR USUARIO EN LA DB
    public long insertUser(User user) {
        this.openWriteableDB();
        long rowID = db.insert(Database.TABLA_USUARIOS, null, clienteMapperContentValues(user));
        this.closeDB();
        return rowID;
    }

    // ACTUALIZAR USUARIO DE LA DB

    public void updateUser(User user) {
        this.openWriteableDB();
        String where = Database.id_sistema + "= ?";
        db.update(Database.TABLA_USUARIOS, clienteMapperContentValues(user), where, new String[]{String.valueOf(user.getId_sistema())});
        db.close();
    }

    // BORRAR USUARIO DE LA DB
    public void deleteUser(int id_sistema) {
        this.openWriteableDB();
        String where = Database.id_sistema + "= ?";
        db.delete(Database.TABLA_USUARIOS, where, new String[]{String.valueOf(id_sistema)});
        this.closeDB();
    }

    // LEER UN USUARIO EN LA DB
    public ArrayList loadUser() {

        ArrayList list = new ArrayList<>();

        this.openReadableDB();
        String[] campos = new String[]{String.valueOf(Database.id_sistema), Database.nombre, Database.contraseña};
        Cursor c = db.query(Database.TABLA_USUARIOS, campos, null, null, null, null, null);

        try {
            while (c.moveToNext()) {
                User user = new User();
                user.setId_sistema(c.getInt(0));
                user.setNombre(c.getString(1));
                user.setContraseña(c.getString(2));
                list.add(user);
            }
        } finally {
            c.close();
        }
        this.closeDB();

        return list;
    }

    // BUSCAR USER EN LA DB

    public User buscarUser(String nombre) {
        User user= new User();
        this.openReadableDB();
        String where = Database.TABLA_USUARIOS + "= ?";
        String[] whereArgs = {nombre};
        Cursor c = db.query(Database.TABLA_USUARIOS, null, where, whereArgs, null, null, null);

        if( c != null || c.getCount() <=0) {
            c.moveToFirst();
            user.setId_sistema(c.getInt(0));
            user.setNombre(c.getString(1));
            user.setContraseña(c.getString(2));
            c.close();
        }
        this.closeDB();
        return user;
    }






}
