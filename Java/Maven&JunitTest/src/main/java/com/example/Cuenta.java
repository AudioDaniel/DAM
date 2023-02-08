package com.example;

public class Cuenta {
    int ncuenta;
    double saldo;

    public Cuenta(int ncuenta, double saldo) throws IllegalArgumentException {
        if (ncuenta <= 0) {
            throw new IllegalArgumentException("El número de cuenta no puede ser menor o igual a 0");
        }
        this.ncuenta = ncuenta;
        this.saldo = saldo;

    }

    public double ingresarDinero(double valor) {
        saldo = saldo + valor;

        return saldo;
    }

    public double extraerDinero(double valor) {
        saldo = saldo - valor;
        return saldo;
    }

    public String mostrarCuenta() {
        String mensaje = "Nº de cuenta" + ncuenta + "\n" + "Su saldo" + "\n" + saldo;
        System.out.println(mensaje);
        return mensaje;
    }
}
