package org.lv.ipractices.hackerrank;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class CurrencyFormatter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        // Write your code here.

        NumberFormat engNf = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat inNf = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        NumberFormat chNf = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat franceNf = NumberFormat.getCurrencyInstance(Locale.FRANCE);



        System.out.println("US: " + engNf.format(payment));
        System.out.println("India: " + inNf.format(payment));
        System.out.println("China: " + chNf.format(payment));
        System.out.println("France: " + franceNf.format(payment));
    }
}
