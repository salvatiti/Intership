package com.salvatiti.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {

  public void ordenar() {

    List<String> lista = new ArrayList<>();
    lista.add("Hola");
    lista.add("Adios");
    lista.add("Buenas");

    /*
     * JDK 1.7 Collections.sort(lista, new Comparator<String>() {
     *
     * @Override public int compare(String o1, String o2) { return o1.compareTo(o2); } });
     */

    Collections.sort(lista, (String p1, String p2) -> p1.compareTo(p2));

    for (String elemento : lista) {
      System.out.println(elemento);
    }
  }

  public static void main(String[] args) {

    App app = new App();
    app.ordenar();

  }
}
