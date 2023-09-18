package com.example;

public class Automovil {
    
    enum Tipomarca {BMW, AUDI, ROLL_ROYCE,Bugatti, Ferrari, MASERATI, PORCHE};
    Tipomarca marca;
    int modelo;
    double motor;
    enum Tipotransmision {automatica, manual};
    Tipotransmision transmision;
    enum tipoCom {GASOLINA, BIOETANOL, DIESEL, BIODISESEL,GAS_NATURAL}
    tipoCom tipoCombustible;
    enum tipoA {CIUDAD, SUBCOMPACTO, COMPACTO, FAMILIAR,EJECUTIVO, SUV}
    tipoA tipoAutomovil;
    int numeroPuertas;
    int cantidadAsientos;
    int velocidadMáxima;
    enum tipoColor {BLANCO, NEGRO, ROJO, NARANJA,AMARILLO, VERDE, AZUL, VIOLETA}
    tipoColor color;
    int velocidadActual = 0;
    int multas = 0;
    int velocidadMaxima;
    

    public Automovil(Automovil.Tipomarca marca, int modelo, double motor, Automovil.Tipotransmision transmision, Automovil.tipoCom tipoCombustible,Automovil.tipoA tipoAutomóvil, int numeroPuertas, int cantidadAsientos, int velocidadMáxima,Automovil.tipoColor color, int velocidadActual) {

    this.marca = marca;
    this.modelo = modelo;
    this.motor = motor;
    this.transmision = transmision;
    this.tipoCombustible = tipoCombustible;
    this.tipoAutomovil = tipoAutomóvil;
    this.numeroPuertas = numeroPuertas;
    this.cantidadAsientos = cantidadAsientos;
    this.velocidadMáxima = velocidadMáxima;
    this.color = color;
    this.velocidadActual = velocidadActual;
    this.multas = 0;
    this.velocidadMaxima = velocidadMáxima;
}

    public Automovil(Automovil.Tipomarca bugatti, int i, double d, Automovil.Tipotransmision automatica,
            Automovil.tipoCom bioetanol, Automovil.tipoA ciudad, int j, int k, int l, Automovil.tipoColor negro) {
    }

    public Automovil.Tipomarca getMarca() {
        return marca;
    }


    public void setMarca(Automovil.Tipomarca marca) {
        this.marca = marca;
    }


    public int getModelo() {
        return modelo;
    }


    public void setModelo(int modelo) {
        this.modelo = modelo;
    }


    public double getMotor() {
        return motor;
    }


    public void setMotor(int motor) {
        this.motor = motor;
    }


    public Automovil.Tipotransmision getTransmision() {
        return transmision;
    }


    public void setTransmision(Automovil.Tipotransmision transmision) {
        this.transmision = transmision;
    }


    public tipoCom getTipoCombustible() {
        return tipoCombustible;
    }


    public void setTipoCombustible(tipoCom tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }


    public tipoA getTipoAutomóvil() {
        return tipoAutomovil;
    }


    public void setTipoAutomóvil(tipoA tipoAutomovil) {
        this.tipoAutomovil = tipoAutomovil;
    }


    public int getNúmeroPuertas() {
        return numeroPuertas;
    }


    public void setNúmeroPuertas(int númeroPuertas) {
        this.numeroPuertas = númeroPuertas;
    }


    public int getCantidadAsientos() {
        return cantidadAsientos;
    }


    public void setCantidadAsientos(int cantidadAsientos) {
        this.cantidadAsientos = cantidadAsientos;
    }


    public int getVelocidadMáxima() {
        return velocidadMáxima;
    }


    public void setVelocidadMáxima(int velocidadMáxima) {
        this.velocidadMáxima = velocidadMáxima;
    }


    public tipoColor getColor() {
        return color;
    }


    public void setColor(tipoColor color) {
        this.color = color;
    }


    public int getVelocidadActual() {
        return velocidadActual;
    }

    void setVelocidadActual(int nuevaVelocidad) {
        if (nuevaVelocidad >= 0 && nuevaVelocidad <= velocidadMaxima) {
            velocidadActual = nuevaVelocidad;
        } else if (nuevaVelocidad > velocidadMaxima) {
            generarMulta();
            System.out.println("Se ha generado una multa por exceso de velocidad.");
        } else {
            System.out.println("La velocidad no puede ser negativa.");
        }
    }

    boolean tieneMultas() {
        return multas > 0;
    }

    int valorTotalMultas() {
        return multas * 50;
    }

    private void generarMulta() {
        multas++;
    }

    
    void acelerar(int incrementoVelocidad) {
        if (velocidadActual + incrementoVelocidad < velocidadMáxima) {
        velocidadActual = velocidadActual + incrementoVelocidad;
    } else { 
            System.out.println("No se puede incrementar a una velocidad superior a la máxima del automóvil.");
            generarMulta();
            System.out.println("Se ha generado una multa por exceso de velocidad.");
        }
    }

    void desacelerar(int decrementoVelocidad) {
    if ((velocidadActual - decrementoVelocidad) > 0) {
        velocidadActual = velocidadActual - decrementoVelocidad;
    } else { 
        System.out.println("No se puede decrementar a una velocidad negativa.");
        }
    }
    
    void frenar() {
        velocidadActual = 0;
    }
    
    double calcularTiempoLlegada(int distancia) {
        return distancia/velocidadActual;
    }
    
    void imprimir() {
        System.out.println("Marca = " + marca);
        System.out.println("Modelo = " + modelo);
        System.out.println("Motor = " + motor);
        System.out.println("Tipo transmision = " + transmision);
        System.out.println("Tipo de combustible = " + tipoCombustible);
        System.out.println("Tipo de automóvil = " + tipoAutomovil);
        System.out.println("Número de puertas = " + numeroPuertas);
        System.out.println("Cantidad de asientos = " + cantidadAsientos);
        System.out.println("Velocida máxima = " + velocidadMáxima);
        System.out.println("Color = " + color);
    }

    public static void main(String args[]) {
        
    Automovil auto1 = new Automovil(Tipomarca.Ferrari, 2021, 6.5, Tipotransmision.automatica,tipoCom.BIOETANOL, tipoA.CIUDAD, 2, 2, 100, tipoColor.BLANCO, 150);

    auto1.imprimir();
    auto1.setVelocidadActual(120);
    System.out.println(" La velocidad actual es " + auto1.velocidadActual);
    auto1.acelerar(40);
    System.out.println(" La velocidad actual es " + auto1.velocidadActual);
    auto1.desacelerar(60);
    System.out.println(" La velocidad actual es " + auto1.velocidadActual);
    auto1.frenar();
    System.out.println("Tiene multas: " + auto1.tieneMultas());
    System.out.println("Valor total de multas: $" + auto1.valorTotalMultas());
    }
}