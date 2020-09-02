package com.vineethds.others;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
/*
Given a double-precision number, , denoting an amount of money,
use the NumberFormat class' getCurrencyInstance method to convert
into the US, Indian, Chinese, and French currency formats.

Sample Input

12324.134
Sample Output

US: $12,324.13
India: Rs.12,324.13
China: ￥12,324.13
France: 12 324,13 €

 */

public class CurrencyFormatter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        // Write your code here.
        Locale indian = new Locale("en", "IN");
        NumberFormat unf = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat inf = NumberFormat.getCurrencyInstance(indian);
        NumberFormat chinaf = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat fraf = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        String us = unf.format(payment);
        String india = inf.format(payment);
        String china = chinaf.format(payment);
        String france = fraf.format(payment);

        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}
