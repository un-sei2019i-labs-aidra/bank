package com.example.bankapp2.dataAccess.models;

import java.util.Date;

public class Transaction {

    private int id_transaccion;
    private int id_cuenta_destino;
    private int id_cuenta_origen;
    private double valor;
    private Date fecha_transaccion;

    public Transaction(int id_cuenta_destino, int id_cuenta_origen, double valor, Date fecha_transaccion, String estado) {
        this.id_cuenta_destino = id_cuenta_destino;
        this.id_cuenta_origen = id_cuenta_origen;
        this.valor = valor;
        this.fecha_transaccion = fecha_transaccion;
        this.estado = estado;
    }



    public Transaction(int id_transaccion, int id_cuenta_destino, int id_cuenta_origen, double valor, Date fecha_transaccion, String estado) {
        this.id_transaccion = id_transaccion;
        this.id_cuenta_destino = id_cuenta_destino;
        this.id_cuenta_origen = id_cuenta_origen;
        this.valor = valor;
        this.fecha_transaccion = fecha_transaccion;
        this.estado = estado;
    }



    public int getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(int id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    public int getId_cuenta_destino() {
        return id_cuenta_destino;
    }

    public void setId_cuenta_destino(int id_cuenta_destino) {
        this.id_cuenta_destino = id_cuenta_destino;
    }

    public int getId_cuenta_origen() {
        return id_cuenta_origen;
    }

    public void setId_cuenta_origen(int id_cuenta_origen) {
        this.id_cuenta_origen = id_cuenta_origen;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getFecha_transaccion() {
        return fecha_transaccion;
    }

    public void setFecha_transaccion(Date fecha_transaccion) {
        this.fecha_transaccion = fecha_transaccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    private String estado;
}
