package com.example.deliverybooks.functionals_manual;

import java.text.Collator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

public class SetCollectionsTest {
    public static void main(String[] args) {
        System.out.println("HashSet");

        System.out.println("1. CARGA");
        Set<String> generos = new HashSet<>();
        System.out.println("add(\"Novela\") -> " + generos.add("Novela")); // true: se añade
        generos.add("Poesía");
        generos.add("Teatro");
        generos.add("Ensayo");
        System.out.println("add(\"Novela\") otra vez  -> " + generos.add("Novela")); // false: ya estaba
        System.out.println("Conjunto: " + generos + "  (el orden NO es el de inserción)");
        System.out.println("Tamaño: " + generos.size());

        // Uso muy típico: quitar los repetidos de una lista
        List<String> conRepetidos = List.of("Novela", "Cómic", "Novela", "Poesía", "Cómic");
        Set<String> sinRepetidos = new HashSet<>(conRepetidos);
        System.out.println("Quitar repetidos: " + conRepetidos + " -> " + sinRepetidos);

        System.out.println("2. RECORRIDO");
        // No existe get(i): un Set no tiene posiciones. Se recorre con for-each o
        // forEach.
        for (String genero : generos) {
            System.out.println("  - " + genero);
        }
        System.out.println("¿Contiene 'Teatro'? " + generos.contains("Teatro"));
        System.out.println("¿Contiene 'teatro'? " + generos.contains("teatro") + "  (distingue mayúsculas)");

        System.out.println("3. ACTUALIZACIÓN");
        // Un Set no tiene set(). Para "cambiar" un elemento: se elimina el viejo y se
        // añade el nuevo.
        if (generos.remove("Ensayo")) {
            generos.add("Ensayo histórico");
        }
        System.out.println("Ensayo -> Ensayo histórico: " + generos);

        System.out.println("4. MODIFICACIÓN");
        generos.remove("Teatro");
        System.out.println("Tras remove(): " + generos);
        generos.removeIf(genero -> genero.startsWith("P"));
        System.out.println("Tras removeIf(): " + generos);

        // Operaciones de conjuntos, como en matemáticas.
        // Se hacen sobre una copia porque addAll/retainAll/removeAll cambian el
        // conjunto original.
        Set<String> tiendaA = Set.of("Novela", "Poesía", "Cómic");
        Set<String> tiendaB = Set.of("Novela", "Teatro", "Cómic", "Ensayo");

        Set<String> union = new HashSet<>(tiendaA);
        union.addAll(tiendaB);
        Set<String> interseccion = new HashSet<>(tiendaA);
        interseccion.retainAll(tiendaB);
        Set<String> diferencia = new HashSet<>(tiendaA);
        diferencia.removeAll(tiendaB);

        System.out.println("Tienda A: " + tiendaA + "  Tienda B: " + tiendaB);
        System.out.println("Unión (A o B):            " + union);
        System.out.println("Intersección (A y B):     " + interseccion);
        System.out.println("Diferencia (A pero no B): " + diferencia);

        generos.clear();
        System.out.println("Tras clear(): " + generos + " ¿vacío? " + generos.isEmpty());

        // =========================================================================================
        // SET: HashSet vs LinkedHashSet vs TreeSet
        // Los tres eliminan repetidos. La diferencia es el ORDEN en que devuelven los
        // elementos.
        // =========================================================================================

        System.out.println("HashSet vs LinkedHashSet vs TreeSet");
        List<String> entrada = List.of("Teatro", "Novela", "Poesía", "Ensayo", "Cómic", "Novela");

        Set<String> hashSet = new HashSet<>(entrada);
        Set<String> linkedHashSet = new LinkedHashSet<>(entrada);
        TreeSet<String> treeSet = new TreeSet<>(entrada);

        System.out.println("Entrada:       " + entrada);
        System.out.println("HashSet:       " + hashSet + "  -> sin orden garantizado");
        System.out.println("LinkedHashSet: " + linkedHashSet + "  -> orden de inserción");
        System.out.println("TreeSet:       " + treeSet + "  -> orden alfabético");

        // Al estar ordenado, TreeSet tiene métodos extra
        System.out.println("TreeSet first():      " + treeSet.first());
        System.out.println("TreeSet last():       " + treeSet.last());
        System.out.println("TreeSet headSet(\"O\"): " + treeSet.headSet("O") + "  (los anteriores a \"O\")");

        // CUIDADO: el orden "natural" de String compara códigos Unicode:
        // las mayúsculas van antes que las minúsculas y las letras con tilde, al final.
        List<String> palabras = List.of("zarzuela", "Ópera", "Ballet", "acuarela");
        Set<String> ordenNatural = new TreeSet<>(palabras);
        Set<String> ordenEspanol = new TreeSet<>(Collator.getInstance(Locale.of("es", "ES")));
        ordenEspanol.addAll(palabras);
        System.out.println("TreeSet orden natural: " + ordenNatural);
        System.out.println("TreeSet con Collator:  " + ordenEspanol + "  (orden del diccionario)");
    }

}