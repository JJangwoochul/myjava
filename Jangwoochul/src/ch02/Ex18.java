//Calculator01.java 클래스의 실행 클래스
package ch02;

public class Ex18 {
    public static void main(String[] args) {
        Calculator01 myCalc = new Calculator01();
        myCalc.powerOn();

        int result1 = myCalc.plus(5, 6);
        System.out.println("result1 : " + result1);

        byte x = 10;
        byte y = 4;
        double result2 = myCalc.divide(x, y);
        System.out.println("result2 : " + result2);

        myCalc.powerOff();
    }
}
