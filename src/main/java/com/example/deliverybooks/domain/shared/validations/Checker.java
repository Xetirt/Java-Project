package com.example.deliverybooks.domain.shared.validations;
public class Checker {
    public static void notNullString (String s){
        if(s == null){
            throw new IllegalArgumentException("Null String received");
        }
    }
    public static String notEmptyString(String s) {
        notNullString(s);
        String trimmed = s.trim();
        if(trimmed.isEmpty()){
            throw new IllegalArgumentException("String recibido");
        }
        return trimmed;
    }
    public static String minLengthString (String s, int minLength){
        String trimmed = notEmptyString(s);
        if(trimmed.length() < minLength){
            throw new IllegalArgumentException("short String recibido");
        }
        return trimmed;
    }
    public static String stringBetweenLength (String s, int minLength, int maxLength){
        String trimmed = minLengthString(s, minLength);
        if(trimmed.length() < maxLength){
            throw new IllegalArgumentException("To Long String recibido");
        }
        return trimmed;
    }
}