package ch01;

import java.util.Scanner;

public class Ex32 {
    public static void main(String[] args) {
        System.out.println("메세지 입력");
        System.out.println("종료시 q 입력");

        Scanner scanner = new Scanner(System.in);
        String inputString;

        do {
            System.out.print(">");
            inputString = scanner.nextLine();
            System.out.println(inputString);
        } while (!inputString.equals("q"));

        System.out.println();
        System.out.println("종료");
    }
}
