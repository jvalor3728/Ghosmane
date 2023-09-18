package com.example;

public class Planeta {
    private String nombre;
    private int cantidadSatelites;
    private double masaKilogramos;
    private double volumenKilometrosCubicos;
    private int diametroKilometros;
    private int distanciaMediaAlSolMillonesKilometros;
    private TipoPlaneta tipo;
    private boolean observableASimpleVista;
    enum TipoPlaneta {GASEOSO, TERRESTRE, ENANO}

    public Planeta(String nombre, int cantidadSatelites, double masaKilogramos,double volumenKilometrosCubicos, int diametroKilometros,int distanciaMediaAlSolMillonesKilometros, TipoPlaneta tipo,boolean observableASimpleVista) {
        this.nombre = nombre;
        this.cantidadSatelites = cantidadSatelites;
        this.masaKilogramos = masaKilogramos;
        this.volumenKilometrosCubicos = volumenKilometrosCubicos;
        this.diametroKilometros = diametroKilometros;
        this.distanciaMediaAlSolMillonesKilometros = distanciaMediaAlSolMillonesKilometros;
        this.tipo = tipo;
        this.observableASimpleVista = observableASimpleVista;
    }

    public void imprimirInfoPlaneta() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Cantidad de satélites: " + cantidadSatelites);
        System.out.println("Masa en kilogramos: " + masaKilogramos);
        System.out.println("Volumen en kilómetros cúbicos: " + volumenKilometrosCubicos);
        System.out.println("Diámetro en kilómetros: " + diametroKilometros);
        System.out.println("Distancia media al Sol en millones de kilómetros: " + distanciaMediaAlSolMillonesKilometros);
        System.out.println("Tipo de planeta: " + tipo);
        System.out.println("Observable a simple vista: " + observableASimpleVista);
    }

    public double calcularDensidad() {
        return masaKilogramos / volumenKilometrosCubicos;
    }

    public boolean esExterior() {
        double distanciaEnKilometros = distanciaMediaAlSolMillonesKilometros * 1_000_000;
        return distanciaEnKilometros > 3.4 * 149_597_870 || distanciaEnKilometros < 2.1 * 149_597_870;
    }
    public static void main(String[] args) {
        Planeta planeta1 = new Planeta("Tierra", 1, 5.972e24, 1.08321e12, 12742, 149_600_000,
                TipoPlaneta.TERRESTRE, true);

        Planeta planeta2 = new Planeta("Júpiter", 79, 1.898e27, 1.43128e15, 139822, 778_300_000,
                TipoPlaneta.GASEOSO, false);

        planeta1.imprimirInfoPlaneta();
        System.out.println("Densidad del planeta 1: " + planeta1.calcularDensidad());
        System.out.println("¿El planeta 1 es exterior? " + planeta1.esExterior());

        System.out.println("\n");

        planeta2.imprimirInfoPlaneta();
        System.out.println("Densidad del planeta 2: " + planeta2.calcularDensidad());
        System.out.println("¿El planeta 2 es exterior? " + planeta2.esExterior());
    }
}

