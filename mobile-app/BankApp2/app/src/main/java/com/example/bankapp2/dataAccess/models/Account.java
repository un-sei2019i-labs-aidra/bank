package com.example.bankapp2.dataAccess.models;

public class Account {

    private int id_cuenta;
    private int id_usuario;
    private double saldo;
    private String contraseña;

    public Account() {
        this.id_cuenta = id_cuenta;
        this.id_cuenta = id_usuario;
        this.saldo = saldo;
        this.contraseña = contraseña;
    }

    public Account(double saldo, String contraseña, int id_usuario) {
        this.saldo = saldo;
        this.contraseña = contraseña;
        this.id_usuario = id_usuario;
    }


    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
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
