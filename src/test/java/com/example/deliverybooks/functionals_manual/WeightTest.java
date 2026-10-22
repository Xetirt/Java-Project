package com.example.deliverybooks.functionals_manual;

import java.math.BigDecimal;

import com.example.deliverybooks.domain.shared.valueobjects.mesurament.Weight;
import com.example.deliverybooks.domain.shared.valueobjects.mesurament.WeightUnit;

public class WeightTest {
    public static void main(String[] args) {
        // Creamos un objeto de 2 Libras
        Weight packageWeight = new Weight(new BigDecimal("2"), WeightUnit.POUNDS);

        // Representación interna (se convierte y almacena internamente en gramos)
        System.out.println("Valor interno: " + packageWeight.value() + " " + packageWeight.unit()); 
        // Salida: 907.18474 GRAMS

        // Consultamos el peso expresado en distintas unidades
        System.out.println("En Libras: " + packageWeight.getValueIn(WeightUnit.POUNDS));      // 2.000000
        System.out.println("En Kilogramos: " + packageWeight.getValueIn(WeightUnit.KILOGRAMS)); // 0.907185
        System.out.println("En Toneladas: " + packageWeight.getValueIn(WeightUnit.TONNES));    // 0.000907
        System.out.println("En Onzas: " + packageWeight.getValueIn(WeightUnit.OUNCES));       // 32.000000
    }
}
