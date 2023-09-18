package com.example;

class CuentaBancaria {
    private String nombresTitular;
    private String apellidosTitular;
    private String numeroCuenta;
    private String tipoCuenta;
    private double saldo;
    private double tasaInteresMensual;

    public CuentaBancaria(String nombresTitular, String apellidosTitular, String numeroCuenta, String tipoCuenta) {
        this.nombresTitular = nombresTitular;
        this.apellidosTitular = apellidosTitular;
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldo = 0;
        this.tasaInteresMensual = 0;
    }

    public void imprimirInfoCuenta() {
        System.out.println("Titular: " + nombresTitular + " " + apellidosTitular);
        System.out.println("Número de cuenta: " + numeroCuenta);
        System.out.println("Tipo de cuenta: " + tipoCuenta);
        System.out.println("Saldo: " + saldo);
    }

    public double consultarSaldo() {
        return saldo;
    }

    public void consignar(double valor) {
        saldo += valor;
        System.out.println("Se ha consignado " + valor + " en la cuenta.");
    }

    public void retirar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Se ha retirado " + valor + " de la cuenta.");
        } else {
            System.out.println("Saldo insuficiente para el retiro.");
        }
    }

    public void setTasaInteresMensual(double tasaInteresMensual) {
        this.tasaInteresMensual = tasaInteresMensual;
    }

    public void calcularNuevoSaldoConInteres() {
        saldo += saldo * (tasaInteresMensual / 100);
        System.out.println("Nuevo saldo después de aplicar interés: " + saldo);
    }

    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria("Juan", "Valor", "123456789", "Ahorros");
        cuenta.imprimirInfoCuenta();
        cuenta.consignar(475.000);
        cuenta.imprimirInfoCuenta();
        cuenta.retirar(120.000);
        cuenta.imprimirInfoCuenta();

        cuenta.setTasaInteresMensual(2.5);
        cuenta.calcularNuevoSaldoConInteres();
    }
}
