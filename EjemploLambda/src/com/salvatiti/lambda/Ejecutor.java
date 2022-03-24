package com.salvatiti.lambda;

import java.text.DecimalFormat;

public class Ejecutor {

  public static void main(String args[]) {

    // referencia a la Interfaz
    // Expression lambda
    // Nombre nombre = (n)-> System.out.println("Bienvenido " + n); //implementar metodo a traves de expresi�n lambda
    // nombre.Mensaje("salva");
    DecimalFormat format = new DecimalFormat("0.#");
    ICalculadora calculadoraSuma = (a, b) -> {
      double resultado = a + b;
      System.out
          .println("La suma de " + format.format(a) + " + " + format.format(b) + " es " + format.format(resultado));
    };
    calculadoraSuma.operacion(5, 10);

    ICalculadora calculadoraResta = (a, b) -> {
      double resultado = a - b;
      System.out
          .println("La resta de " + format.format(a) + " - " + format.format(b) + " es " + format.format(resultado));
    };
    calculadoraResta.operacion(5, 2);

    ICalculadora calculadoraMul = (a, b) -> {
      double resultado = a * b;
      System.out.println(
          "La multiplicacion de " + format.format(a) + " * " + format.format(b) + " es " + format.format(resultado));
    };
    calculadoraMul.operacion(5, 2);

    ICalculadora calculadoraDiv = (a, b) -> {
      double resultado = a / b;
      System.out
          .println("La division de " + format.format(a) + " / " + format.format(b) + " es " + format.format(resultado));
    };
    calculadoraDiv.operacion(5, 2);

  }

}
