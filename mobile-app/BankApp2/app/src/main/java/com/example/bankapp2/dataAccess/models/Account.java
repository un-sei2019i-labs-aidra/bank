package com.example.bankapp2.dataAccess.models;

public class Account {

    private int id_cuenta;
    private double saldo;
    private String contraseña;

    public Account() {
        this.id_cuenta = id_cuenta;
        this.saldo = saldo;
        this.contraseña = contraseña;
    }

    public Account(double saldo, String contraseña) {
        this.saldo = saldo;
        this.contraseña = contraseña;
    }


    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }


}
