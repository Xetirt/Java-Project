package com.example.deliverybooks.functionals_manual;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapCollectionsTest {
    // El código postal se guarda como String y no como int: con int, "08001" perdería el 0 inicial.
    private static void setZipCodes(Map<String, String> mapa) {
        mapa.put("28001", "Madrid");
        mapa.put("08001", "Barcelona");
        mapa.put("46001", "Valencia");
        mapa.put("17001", "Girona");
        mapa.put("41001", "Sevilla");
    }

    public static void main(String[] args) {
       System.out.println("******** HashMap  **************");

        System.out.println("1. CARGA DE LIBROS Y SUS AUTORES");
        Map<String, String> autores = new HashMap<>();     // clave: título, valor: autor
        autores.put("El Quijote", "Cervantes");
        autores.put("Cien años de soledad", "García Márquez");
        autores.put("Rayuela", "Cortázar");
        autores.put("Ficciones", "Borges");
        autores.put("La Celestina", "Fernando de Rojas");

        // putIfAbsent sólo añade si la clave NO existe; si existe, no cambia nada y devuelve el valor actual
        System.out.println("Ejemplo putIfAbsent() -> " + autores.putIfAbsent("Rayuela", "Otro"));
        System.out.println("Ejemplo putIfAbsent() -> " + autores.putIfAbsent("Pedro Páramo", "Rulfo"));
        System.out.println("Mapa: " + autores);
        System.out.println("Tamaño: " + autores.size());

        System.out.println("2. RECORRIDO");
        System.out.println("Por las claves del mapa a traves de keySet():");
        for (String titulo : autores.keySet()) {
            System.out.println("  - " + titulo);
        }

        System.out.println("Por los valores con values():");
        for (String autor : autores.values()) {
            System.out.println("  - " + autor);
        }

        System.out.println("Clave y valor con entrySet():");
        for (Map.Entry<String, String> entrada : autores.entrySet()) {
            System.out.println("  " + entrada.getKey() + " -> " + entrada.getValue());
        }

        System.out.println("Clave y valor con forEach y lambda:");
        autores.forEach((titulo, autor) -> System.out.println("  " + titulo + " --by-- " + autor));

        System.out.println("Autor de Rayuela -> " + autores.get("Rayuela"));
        System.out.println("Autor de Platero y yo) -> " + autores.get("Platero y yo") + "  (la clave no existe y retorna null)");
        System.out.println("Ejemplo getOrDefault() -> " + autores.getOrDefault("Platero y yo", "No tenemos esta obra"));
        System.out.println("Existe la obra? con containsKey() -> " + autores.containsKey("Ficciones"));
        System.out.println("Existe el valor con containsValue() -> " + autores.containsValue("Borges"));

        System.out.println("3. ACTUALIZACIÓN");
        // put sobre una clave que ya existe REEMPLAZA el valor y devuelve el anterior
        String anterior = autores.put("El Quijote", "Miguel de Cervantes");
        System.out.println("put sobre clave existente. Valor anterior: " + anterior);

        autores.replace("Rayuela", "Julio Cortázar");                 // sólo si la clave existe
        System.out.println("replace en clave inexistente -> " + autores.replace("Platero y yo", "Juan Ramón Jiménez")
                + "  (no añade nada)");

        autores.computeIfPresent("Ficciones", (titulo, autor) -> "Jorge Luis " + autor);   // nuevo valor a partir del actual
        System.out.println("Resultado de las modificaciones: " + autores);

        autores.replaceAll((titulo, autor) -> autor.toUpperCase());   // actualizar todos los valores
        System.out.println("Tras replaceAll(): " + autores);

        System.out.println("4. BORRADO");
        System.out.println("remove() de una clave -> " + autores.remove("Pedro Páramo"));
        System.out.println("remove() condicionado al valor-> " + autores.remove("La Celestina", "Otro")
                + "  (sólo borra si el valor coincide)");

        //removeIf solo elimina si el valor coincide con la condicion        
        autores.entrySet().removeIf(entrada -> entrada.getValue().startsWith("GARCÍA"));
        System.out.println("Resultadp tras los borrados: " + autores);

        autores.clear();
        System.out.println("Tras clear(): " + autores + " ¿vacío? " + autores.isEmpty());
    

    // =========================================================================================
    // MAP: HashMap vs LinkedHashMap vs TreeMap
    // Mismo razonamiento que con los Set, pero el orden se aplica a las CLAVES.
    // =========================================================================================
        System.out.println("\n*****  HashMap vs LinkedHashMap vs TreeMap  *****\n");

        Map<String, String> hashMap = new HashMap<>();
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        TreeMap<String, String> treeMap = new TreeMap<>();

        // El mismo método sirve para los tres tipos porque recibe una clase que implementa Map
        setZipCodes(hashMap);
        setZipCodes(linkedHashMap);
        setZipCodes(treeMap);

        System.out.println("HashMap:       " + hashMap + " -> sin orden garantizado");
        System.out.println("LinkedHashMap: " + linkedHashMap + " -> orden de inserción");
        System.out.println("TreeMap:       " + treeMap + " -> claves ordenadas");

        System.out.println("**** With TreeMap ****");
        System.out.println("* firstKey():      " + treeMap.firstKey());
        System.out.println("* lastKey():       " + treeMap.lastKey());
        System.out.println("* firstEntry():    " + treeMap.firstEntry());
        System.out.println("* lastEntry():     " + treeMap.lastEntry());
        System.out.println("* headMap(\"20000\"):" + treeMap.headMap("20000") + "  (claves anteriores a \"20000\")");
    }
}