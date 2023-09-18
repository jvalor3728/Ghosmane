package com.example;

public class FigurasGeometricas{

        double area() {
            return 0;
        }
    
        double perimetro() {
            return 0;
        }
    }
    
    class Circulo extends FigurasGeometricas {
        double radio;
    
        Circulo(double radio) {
            this.radio = radio;
        }
    
        double area() {
            return Math.PI * radio * radio;
        }
    
        double perimetro() {
            return 2 * Math.PI * radio;
        }
    }
    
        class Rectangulo extends FigurasGeometricas {
        double base;
        double altura;
    
        Rectangulo(double base, double altura) {
            this.base = base;
            this.altura = altura;
        }
    
        double area() {
            return base * altura;
        }
    
        double perimetro() {
            return 2 * (base + altura);
        }
    }
    
    class Cuadrado extends Rectangulo {
        Cuadrado(double lado) {
            super(lado, lado);
        }
    }
    
    class TrianguloRectangulo extends FigurasGeometricas {
        double base;
        double altura;
    
        TrianguloRectangulo(double base, double altura) {
            this.base = base;
            this.altura = altura;
        }
    
        double area() {
            return 0.5 * base * altura;
        }
    
        double perimetro() {
            double hipotenusa = calcularHipotenusa();
            return base + altura + hipotenusa;
        }
    
        double calcularHipotenusa() {
            return Math.sqrt(base * base + altura * altura);
        }
    
        String tipoTriangulo() {
            double[] lados = {base, altura, calcularHipotenusa()};
            java.util.Arrays.sort(lados);
    
            if (lados[0] == lados[1] && lados[1] == lados[2]) {
                return "Equilátero";
            } else if (lados[0] == lados[1] || lados[1] == lados[2]) {
                return "Isósceles";
            } else {
                return "Escaleno";
            }
        }
    }
    
    class Rombo extends FigurasGeometricas {
        double diagonalMayor;
        double diagonalMenor;
    
        Rombo(double diagonalMayor, double diagonalMenor) {
            this.diagonalMayor = diagonalMayor;
            this.diagonalMenor = diagonalMenor;
        }
    
        double area() {
            return (diagonalMayor * diagonalMenor) / 2;
        }
    
        double perimetro() {
            return 4 * Math.sqrt(0.25 * diagonalMayor * diagonalMayor + 0.25 * diagonalMenor * diagonalMenor);
        }
    }
    
    class Trapecio extends FigurasGeometricas {
        double baseMayor;
        double baseMenor;
        double altura;
    
        Trapecio(double baseMayor, double baseMenor, double altura) {
            this.baseMayor = baseMayor;
            this.baseMenor = baseMenor;
            this.altura = altura;
        }
    
        double area() {
            return 0.5 * (baseMayor + baseMenor) * altura;
        }
    
        double perimetro() {
            double ladoA = (baseMayor - baseMenor) / 2;
            double ladoB = Math.sqrt(altura * altura + ladoA * ladoA);
            return baseMayor + baseMenor + 2 * ladoB;
        }
    
        public static void main(String[] args) {
            Circulo circulo = new Circulo(5);
            System.out.println("Área del círculo: " + circulo.area());
            System.out.println("Perímetro del círculo: " + circulo.perimetro());
    
            Rectangulo rectangulo = new Rectangulo(6, 8);
            System.out.println("Área del rectángulo: " + rectangulo.area());
            System.out.println("Perímetro del rectángulo: " + rectangulo.perimetro());
    
            Cuadrado cuadrado = new Cuadrado(4);
            System.out.println("Área del cuadrado: " + cuadrado.area());
            System.out.println("Perímetro del cuadrado: " + cuadrado.perimetro());
    
            TrianguloRectangulo triangulo = new TrianguloRectangulo(5, 12);
            System.out.println("Área del triángulo: " + triangulo.area());
            System.out.println("Perímetro del triángulo: " + triangulo.perimetro());
            System.out.println("Tipo de triángulo: " + triangulo.tipoTriangulo());
    
            Rombo rombo = new Rombo(8, 6);
            System.out.println("Área del rombo: " + rombo.area());
            System.out.println("Perímetro del rombo: " + rombo.perimetro());
    
            Trapecio trapecio = new Trapecio(10, 6, 4);
            System.out.println("Área del trapecio: " + trapecio.area());
            System.out.println("Perímetro del trapecio: " + trapecio.perimetro());
        }
    
    
}