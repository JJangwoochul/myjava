package ch01;

import java.util.Scanner;

public class Ex20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = 5;
        double y = 0.0;

        double z = x / y;

        System.out.println(Double.isInfinite(z));
        System.out.println(Double.isNaN(z));

        if (Double.isInfinite(z) || Double.isNaN(z)) {
            System.out.println("값 산출 불가");
        } else {
            System.out.println(z + 2);
        }
    }
}
