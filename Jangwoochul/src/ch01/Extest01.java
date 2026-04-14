package ch01;

import java.util.Scanner;;

public class Extest01 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("사칙연산");

        String data;

        while (true) {
            System.out.print("입력 문자열: ");
            data = scanner.nextLine();
            if (data.equals("+") || data.equals("-") || data.equals("*") || data.equals("/")) {
                break;
            } else {
                System.out.println("오류");
            }
        }

        System.out.print("X 값 입력: ");
        String strX = scanner.nextLine();
        int x = Integer.parseInt(strX);

        System.out.print("Y 값 입력: ");
        String strY = scanner.nextLine();
        int y = Integer.parseInt(strY);

        int result = 50;

        if (data.equals("+")) {
            result = x + y;
        } else if (data.equals("-")) {
            result = x - y;
        } else if (data.equals("*")) {
            result = x * y;
        } else if (data.equals("/")) {
            result = x / y;
        } 

        System.out.println("결과 : " + result);
        System.out.println("종료");
    }

}