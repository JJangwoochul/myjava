//Car05.java 클래스의 실행클래스
package ch02.pr_0415;

public class Ex20 {
    public static void main(String[] args) {
        // 객체생성
        Car05 myCar = new Car05();
        // myCar의 setGas 메소드 호출
        myCar.setGas(5);
        // Car의 ifLeftGas 메소드 호출
        boolean gasState = myCar.ifLeftGas();
        if (gasState) {
            System.out.println("출발합니다.");
            myCar.run(); // run 메소드 호출
        }
        // Car의 ifLeftGas 메소드 호출
        if (myCar.ifLeftGas()) {
            System.out.println("gas가 넉넉합니다.");
        } else {
            System.out.println("gas를 주입하세요.");
        }
    }
}
