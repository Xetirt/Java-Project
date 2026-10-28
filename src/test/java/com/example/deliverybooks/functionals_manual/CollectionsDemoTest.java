package com.example.deliverybooks.functionals_manual;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsDemoTest {
    public static void main(String[] args) {

        // =========================================================================================
        // COLECCIONES INMUTABLES: List.of, Set.of, Map.of
        // Muy cómodas para datos fijos, pero NO se pueden cargar, actualizar ni
        // modificar después.
        // =========================================================================================

        System.out.println("\n *****  Colecciones inmutables  *****\n");

        List<String> diasReparto = List.of("Lunes", "Miércoles", "Viernes");
        System.out.println("List.of: " + diasReparto);
        try {
            diasReparto.add("Sábado");
        } catch (UnsupportedOperationException e) {
            System.out.println("add() sobre List.of -> " + e.getClass().getSimpleName() + ": " + e.getMessage());
        }
        try {
            diasReparto.set(0, "Martes");
        } catch (UnsupportedOperationException e) {
            System.out.println("set() sobre List.of -> " + e.getClass().getSimpleName() + ": " + e.getMessage());
        }

        // Si necesito cambiarla, hago una copia modificable
        List<String> diasModificables = new ArrayList<>(diasReparto);
        diasModificables.add("Sábado");
        System.out.println("Copia en un ArrayList, ya modificable: " + diasModificables);

        try {
            Set.of("Novela", "Novela");
        } catch (IllegalArgumentException e) {
            System.out.println("Set.of con repetidos -> " + e.getClass().getSimpleName() + ": " + e.getMessage());
        }

        Map<String, String> paises = Map.of("ES", "España", "FR", "Francia", "PT", "Portugal");
        System.out.println("Map.of: " + paises + "  get(\"FR\") -> " + paises.get("FR"));

        // =========================================================================================
        // ¿POR QUÉ IMPORTA ELEGIR BIEN?
        // Buscamos los mismos 2.000.000 de códigos en una ArrayList y en un HashSet.
        // ArrayList.contains() compara uno por uno (O(n)); HashSet.contains() va
        // directo (O(1)).
        // =========================================================================================

        System.out.println("\n***** Velocidad del método contains(): ArrayList vs HashSet *****\n");
        int total = 2_000_000;

        List<String> lista = new ArrayList<>();
        Set<String> conjunto = new HashSet<>();
        for (int i = 0; i < total; i++) {
            lista.add("LIBRO-" + i);
            conjunto.add("LIBRO-" + i);
        }

        long inicio = System.nanoTime();
        int encontradosLista = 0;
        for (int i = 0; i < total; i++) {
            if (lista.contains("LIBRO-1000000")) {
                System.out.println("Encontrado en la lista: " + lista.get(i));
                i = total; // salgo del bucle, ya lo he encontrado
            }
        }
        long msLista = (System.nanoTime() - inicio);

        inicio = System.nanoTime();
        int encontradosConjunto = 0;
        for (int i = 0; i < total; i++) {
            if (conjunto.contains("LIBRO-1000000")) {
                System.out.println("Encontrado en el conjunto: LIBRO-1000000");
                i = total; // salgo del bucle, ya lo he encontrado
            }
        }
        long msConjunto = (System.nanoTime() - inicio);

        System.out.println("ArrayList: " + encontradosLista + " encontrados en " + msLista + " ns");
        System.out.println("HashSet:   " + encontradosConjunto + " encontrados en " + msConjunto + " ns");
        System.out.println("(los tiempos cambian en cada ordenador, pero la diferencia siempre es enorme)");
    }
}