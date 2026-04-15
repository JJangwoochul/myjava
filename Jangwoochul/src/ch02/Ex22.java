//Calculator03.java클래스의 실행 클래스
package ch02;

public class Ex22 {
    public static void main(String[] args) {
        Calculator03 result1 = new Calculator03();

        int result2 = result1.plus(0, 0);

        double result3 = result1.plus(0.5, 0);
        double result4 = result1.plus(0, 0.5);
        double result5 = result1.plus(0.5, 0.5);

        System.out.println("result2 : " + result2);
        System.out.println("result3 : " + result3);
        System.out.println("result4 : " + result4);
        System.out.println("result5 : " + result5);
    }
}
