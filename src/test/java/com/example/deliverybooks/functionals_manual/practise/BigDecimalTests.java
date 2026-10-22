package com.example.deliverybooks.functionals_manual.practise;
import java.math.BigDecimal;
import java.math.RoundingMode;
public class BigDecimalTests {
    public static void main(String[] args){
    BigDecimal value = BigDecimal.TEN;
    System.out.println(value);


    value = new BigDecimal ("256.123456789");
    System.out.println(value);
    BigDecimal mult = new BigDecimal("3");
    BigDecimal result = value.multiply(mult);
    System.out.println(result.toPlainString());


    BigDecimal value2 = new BigDecimal ("256.123456789");
    BigDecimal mult2 = new BigDecimal("3");
    BigDecimal result2 = value.multiply(mult2);
    System.out.println(result2);
    System.out.println(result2.toPlainString());
    BigDecimal div = new BigDecimal ("22");
    BigDecimal result3 = value.divide(div, 12, RoundingMode.HALF_UP);


    System.out.println(result3);
    if(result3.compareTo(value2) == 1){
        System.out.println("Result3 es mayor:" + result3 + ">" + value2);
    }
    if(result3.compareTo(value2) == -1){
        System.out.println("Value2 es igual o menor:" + value2 + "<" + result3);
    }
    BigDecimal same = new BigDecimal("65243.7634523542");
    if(result3.compareTo(same) == 0){
        System.out.println("Result 3 es igual a same:" + result3 + "==" + same);
    }
}
}