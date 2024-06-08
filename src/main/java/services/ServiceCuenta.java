package services;

import models.Cuenta;


public class ServiceCuenta {

    public static Cuenta depositar(Cuenta cuenta, double monto) {
        if (monto > 0) {
            cuenta.setSaldo(cuenta.getSaldo() + monto);
            return cuenta;
        } else {
            return cuenta;
        }
    }

    public static Cuenta retirar(Cuenta cuenta, double monto) {
        if (cuenta.getSaldo() >= monto) {
            cuenta.setSaldo(cuenta.getSaldo() - monto);
            return cuenta;
        } else {
            System.out.println("Fondos insuficientes.");
            return cuenta;
        }
    }
}