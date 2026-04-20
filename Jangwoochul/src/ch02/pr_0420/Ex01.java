package ch02.pr_0420;

//20260420 Ex01

public class Ex01 {
    public static void main(String[] args) {
        String data1 = null;
        String data2 = null;
        try {
            data1 = args[0];
            data2 = args[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("실행 매개값의 수가 부족합니다.");
            System.out.println("[실행방법]");
            System.out.println("java Ex01 num1 num2");
            return;
        }
        try {
            int value1 = Integer.parseInt(data1);
            int value2 = Integer.parseInt(data2);
            int result = value1 + value2;
            System.out.println(data1 + "+" + data2 + "=" + result);
        } catch (NumberFormatException e) {
            System.out.println("숫자로 변환 불가");
        } finally {
            System.out.println("다시실행.");
        }

    }
}
