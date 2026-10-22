package com.example.deliverybooks.functionals_manual.books;

import java.math.BigDecimal;

import com.example.deliverybooks.domain.shared.valueobjects.mesurament.Distance;
import com.example.deliverybooks.domain.shared.valueobjects.mesurament.DistanceUnit;

public class DistanceManualTestRunner {

    public static void main(String[] args) {

        try {
            // Se crea una distancia inicial de 5.5 Kilómetros
            Distance routeDistance = new Distance(new BigDecimal("5.5"), DistanceUnit.KILOMETERS);

            // Mostrar los datos de la distancia y sus conversiones
            System.out.println("===== DATOS DE DISTANCIA Y CONVERSIONES =====");
            
            // Valor almacenado internamente en la unidad más pequeña (milímetros)
            System.out.println("Internal Base Value : " + routeDistance.value() + " " + routeDistance.unit());
            
            // Conversiones en sistema métrico
            System.out.println("Distance in Millimeters : " + routeDistance.getValueIn(DistanceUnit.MILLIMETERS) + " mm");
            System.out.println("Distance in Centimeters : " + routeDistance.getValueIn(DistanceUnit.CENTIMETERS) + " cm");
            System.out.println("Distance in Meters      : " + routeDistance.getValueIn(DistanceUnit.METERS) + " m");
            System.out.println("Distance in Kilometers  : " + routeDistance.getValueIn(DistanceUnit.KILOMETERS) + " km");
            
            // Conversiones en sistema imperial
            System.out.println("--- SISTEMA IMPERIAL ---");
            System.out.println("Distance in Inches      : " + routeDistance.getValueIn(DistanceUnit.INCHES) + " in");
            System.out.println("Distance in Feet        : " + routeDistance.getValueIn(DistanceUnit.FEET) + " ft");
            System.out.println("Distance in Yards       : " + routeDistance.getValueIn(DistanceUnit.YARDS) + " yd");
            System.out.println("Distance in Miles       : " + routeDistance.getValueIn(DistanceUnit.MILES) + " mi");

            // Validación de integridad
            if (routeDistance.value() == null || routeDistance.unit() == null) {
                throw new IllegalStateException("La distancia no contiene datos válidos");
            }

            System.out.println("=============================================");
            System.out.println("[VERDE] Distance creado y verificado correctamente");

        } catch (Exception e) {
            System.err.println("[ROJO] Error al procesar la distancia: " + e.getMessage());
            throw new IllegalStateException("Test de distancia fallido", e);
        }
    }
}