package com.mogilan.kata;

import com.mogilan.kata.kyu.four.reverse_number.Palindrome;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        System.out.println(guess());
    }


    public static double guess() {
        double result = 0;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            String myNumber = "";
            if (scanner.hasNext()) {
               myNumber = scanner.next();
            }
            String randomNumber = "";
            if (scanner.hasNext()) {
                randomNumber = scanner.next();
            }
            if(myNumber.equals(randomNumber)) {
                result++;
            }
        }
//        if (scanner.hasNext()) {
//            BigDecimal bigDecimal = new BigDecimal(scanner.next());
//            BigDecimal bigDecimalRound = bigDecimal.setScale(1, RoundingMode.FLOOR);
//            result  = bigDecimalRound.doubleValue();
//        }
        return result / 5;
    }

        public static String extractBrackets(String str){
            String result = new String(str);
            while (result.indexOf("(") > 0 || result.indexOf(")") > 0) {
                result = result.replaceAll("([(][\\w\\s]*[)])*", "");
                System.out.println(result);
            }
            return result;

        }


    }