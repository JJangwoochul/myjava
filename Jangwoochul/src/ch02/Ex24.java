//Calculator04.java 클래스의 실행 클래스
package ch02;

public class Ex24 {
    public static void main(String[] args) {
        double result1 = 10 * 10 * Calculator04.pi;
        int result2 = Calculator04.plus(10, 5);
        int result3 = Calculator04.minus(10, 5);

        System.out.println("result1 : " + result1);
        System.out.println("result2 : " + result2);
        System.out.println("result3 : " + result3);
    }
}
