package com.example.bankapp2.dataAccess.repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.bankapp2.MainActivity;
import com.example.bankapp2.dataAccess.database.Database;
import com.example.bankapp2.dataAccess.models.Transaction;
import java.util.ArrayList;
import java.util.Date;


public class TransactionRepository {
    private SQLiteDatabase db;
    private DBHelper dbHelper;

    public TransactionRepository(MainActivity mainActivity) {
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

    // Devuelve un objeto de tipo ContentValues que almacenará los valores de los atributos de un objeto Transaccion
    private ContentValues clienteMapperContentValues(Transaction transaction) {
        ContentValues us = new ContentValues();
        us.put(String.valueOf(Database.id_sistema), transaction.getId_transaccion());
        us.put(Database.cuenta_destino, transaction.getId_cuenta_destino());
        us.put(Database.cuenta_origen, transaction.getId_cuenta_origen());
        return us;
    }


    //métodos para realizar las operaciones CRUD

    // INSERTAR TRANSACCION EN LA DB
    public long createUser(Transaction transaction) {
        this.openWriteableDB();
        long rowID = db.insert(Database.TABLA_USUARIOS, null, clienteMapperContentValues(transaction));
        this.closeDB();
        return rowID;
    }

    // ACTUALIZAR TRANSACCION DE LA DB

    public void updateUser(Transaction transaction) {
        this.openWriteableDB();
        String where = Database.id_sistema + "= ?";
        db.update(Database.TABLA_TRANS, clienteMapperContentValues(transaction),
                where, new String[]{String.valueOf(transaction.getId_transaccion())});
        db.close();
    }

    // BORRAR TRANSACCION DE LA DB
    public void deleteUser(int id_trans) {
        this.openWriteableDB();
        String where = Database.id_sistema + "= ?";
        db.delete(Database.TABLA_TRANS, where, new String[]{String.valueOf(id_trans)});
        this.closeDB();
    }

    // Cargar TRANSACCION de la DB
    public ArrayList loadTransactions() {

        ArrayList list = new ArrayList<>();

        this.openReadableDB();
        String[] campos = new String[]{String.valueOf(Database.id_sistema), String.valueOf(Database.cuenta_origen),
                String.valueOf(Database.cuenta_destino),String.valueOf(Database.fecha),String.valueOf(Database.monto),Database.status};
        Cursor c = db.query(Database.TABLA_TRANS, campos, null, null,
                null, null, null);

        try {
            while (c.moveToNext()) {
                Transaction transaction = new Transaction();
                transaction.setId_transaccion(c.getInt(0));
                transaction.setId_cuenta_origen(c.getInt(1));
                transaction.setId_cuenta_destino(c.getInt(2));
                transaction.setFecha_transaccion(Date.parse(c.getString(3)));
                transaction.setValor(c.getDouble(4));
                transaction.setEstado(c.getString(5));
                list.add(transaction);
            }
        } finally {
            c.close();
        }
        this.closeDB();

        return list;
    }


    // BUSCAR TRANSACCION EN LA DB

    public Transaction getTransById(Integer id_sistema) {
        Transaction transaction = new Transaction();
        this.openReadableDB();
        String where = Database.TABLA_TRANS + "= ?";
        String[] whereArgs = {String.valueOf(id_sistema)};
        Cursor c = db.query(Database.TABLA_TRANS, null, where,
                whereArgs, null, null, null);

        if( c != null || c.getCount() <=0) {
            c.moveToFirst();
            transaction.setId_transaccion(c.getInt(0));
            transaction.setId_cuenta_origen(c.getInt(1));
            transaction.setId_cuenta_destino(c.getInt(2));
            transaction.setFecha_transaccion(c.getString(3));
            transaction.setValor(c.getDouble(4));
            transaction.setEstado(c.getString(5));
            c.close();
        }
        this.closeDB();
        return transaction;
    }






}
