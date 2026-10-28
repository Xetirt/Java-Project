package com.example.deliverybooks.functionals_manual;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayCollectionsTest {
    public static void main(String[] args) {
        System.out.println("ArrayList");

        System.out.println("1. CARGA");
        List<String> libros = new ArrayList<>();
        libros.add("El Quijote");
        libros.add("La Celestina");
        libros.add("Cien años de soledad");
        libros.add("El Quijote");                        // se admiten repetidos
        libros.addAll(List.of("Rayuela", "Ficciones"));    // añadir varios de golpe
        System.out.println("Lista: " + libros);
        System.out.println("Tamaño: " + libros.size());

        System.out.println("2. RECORRIDO");
        System.out.println("for clásico (cuando necesito la posición):");
        for (int i = 0; i < libros.size(); i++) {
            System.out.println("  [" + i + "] " + libros.get(i));
        }

        System.out.println("for-each (cuando sólo necesito el valor):");
        for (String libro : libros) {
            System.out.println("  - " + libro);
        }

        System.out.println("forEach con lambda:");
        libros.forEach(libro -> System.out.println("  * " + libro));

        System.out.println("Primero: " + libros.get(0));
        System.out.println("Último: " + libros.get(libros.size() - 1));
        System.out.println("¿Contiene 'Rayuela'? " + libros.contains("Rayuela"));
        System.out.println("Primera posición de 'El Quijote': " + libros.indexOf("El Quijote"));
        System.out.println("Última posición de 'El Quijote': " + libros.lastIndexOf("El Quijote"));
        System.out.println("Posición de un libro que no está: " + libros.indexOf("Platero y yo"));

        System.out.println("3. ACTUALIZACIÓN");
        libros.set(1, "La Celestina (edición revisada)");    // por posición fija (el 1)

        int posicion = libros.indexOf("Rayuela");     // por posicion desconocida: primero busco su posición
        if (posicion != -1) {
            libros.set(posicion, "Rayuela - Cortázar");
        }
        System.out.println("Tras set(): " + libros);

        libros.replaceAll(libro -> libro.toUpperCase());     // actualizar todos a la vez
        System.out.println("Tras replaceAll(): " + libros);

        System.out.println("4. MODIFICACIÓN");
        libros.add(0, "DON JUAN TENORIO");     // insertar en una posición: desplaza el resto
        System.out.println("Tras add(0, valor): " + libros);

        libros.remove("EL QUIJOTE");           // por valor: elimina sólo la PRIMERA aparición
        System.out.println("Tras remove(valor): " + libros);

        libros.remove(0);                      // por posición
        System.out.println("Tras remove(posición): " + libros);

        libros.removeIf(libro -> libro.startsWith("F"));   // elimina todos los que cumplan la condición
        System.out.println("Tras removeIf(): " + libros);

        Collections.sort(libros);
        System.out.println("Tras Collections.sort(): " + libros);

        libros.clear();
        System.out.println("Tras clear(): " + libros + " ¿vacía? " + libros.isEmpty());
    }


    
}