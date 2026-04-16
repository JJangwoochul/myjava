package ch02.pr_0416;

//Car01.java의 실행클래스
public class Ex01 {
    public static void main(String[] args) {
        Car01 myCar = new Car01();
        // 잘못된 속도 변경
        myCar.setSpeed(-50);

        System.out.println("현재 속도 : " + myCar.getSpeed());
        // 제대로 된 속도 변경
        myCar.setSpeed(60);

        if (!myCar.isStop()) {
            myCar.setStop(true);
        }
        System.out.println("현재 속도 : " + myCar.getSpeed());
    }
}
