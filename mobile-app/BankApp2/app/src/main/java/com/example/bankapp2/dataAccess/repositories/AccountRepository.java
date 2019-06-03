package com.example.bankapp2.dataAccess.repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.bankapp2.business_logic;
import com.example.bankapp2.dataAccess.database.Database;
import com.example.bankapp2.dataAccess.models.Account;

import java.util.ArrayList;


public class AccountRepository {
    private SQLiteDatabase db;
    private DBHelper dbHelper;

    public AccountRepository(business_logic businesslogic) {
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
            db.execSQL(Database.TABLA_CUENTAS_SQL);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

    // Devuelve un objeto de tipo ContentValues que almacenará los valores de los atributos de un objeto Usuario
    private ContentValues clienteMapperContentValues(Account account) {
        ContentValues us = new ContentValues();
        us.put(String.valueOf(Database.id_sistema), account.getId_cuenta());
        us.put(String.valueOf(Database.saldo), account.getSaldo());
        us.put(Database.contraseña_c, account.getContraseña());
        return us;
    }


    //métodos para realizar las operaciones CRUD

    // CREAR CUENTA EN DB
    public long createAccount(Account account) {
        this.openWriteableDB();
        long rowID = db.insert(Database.TABLA_CUENTAS, null,
                clienteMapperContentValues(account));
        this.closeDB();
        return rowID;
    }

    // ACTUALIZAR CUENTA DE LA DB

    public void updateAccount(Account account) {
        this.openWriteableDB();
        String where = Database.id_sistema + "= ?";
        db.update(Database.TABLA_CUENTAS, clienteMapperContentValues(account), where,
                new String[]{String.valueOf(account.getId_cuenta())});
        db.close();
    }

    // BORRAR CUENTA DE LA DB
    public void deleteAccount(int id_sistema) {
        this.openWriteableDB();
        String where = Database.id_cuenta + "= ?";
        db.delete(Database.TABLA_CUENTAS, where,
                new String[]{String.valueOf(id_sistema)});
        this.closeDB();
    }

    // LEER CUENTA EN LA DB
    public ArrayList loadAccount() {

        ArrayList list = new ArrayList<>();

        this.openReadableDB();
        String[] campos2 = new String[]{String.valueOf(Database.id_cuenta),
                String.valueOf(Database.saldo), Database.contraseña_c};
        Cursor c = db.query(Database.TABLA_CUENTAS, campos2, null,
                null, null, null, null);

        try {
            while (c.moveToNext()) {
                Account account = new Account();
                account.setId_cuenta(c.getInt(0));
                account.setSaldo(c.getDouble(1));
                account.setContraseña(c.getString(2));
                list.add(account);
            }
        } finally {
            c.close();
        }
        this.closeDB();

        return list;
    }

    // BUSCAR CUENTA EN LA DB

    public Account getAccountById(int id_cuenta) {
        Account account = new Account();
        this.openReadableDB();
        String where = Database.TABLA_CUENTAS + "= ?";
        String[] whereArgs = {String.valueOf(id_cuenta)};
        Cursor c = db.query(Database.TABLA_CUENTAS, null,
                where, whereArgs, null, null, null);

        if( c != null || c.getCount() <=0) {
            c.moveToFirst();
            account.setId_cuenta(c.getInt(0));
            account.setSaldo(c.getDouble(1));
            account.setContraseña(c.getString(2));
            c.close();
        }
        this.closeDB();
        return account;
    }
}