package com.example.bankapp2.dataAccess.models;

public class User {

    private int id_sistema;
    private String nombre;
    private String contraseña;

    public User() {
        this.nombre = nombre;
        this.contraseña = contraseña;
    }

    public User(int id_sistema, String nombre, String contraseña) {
        this.id_sistema = id_sistema;
        this.nombre = nombre;
        this.contraseña = contraseña;
    }


    public int getId_sistema() {
        return id_sistema;
    }

    public void setId_sistema(int id_sistema) {
        this.id_sistema = id_sistema;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }


}
