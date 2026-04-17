package ch02.pr_0417;
//20260417 예제1
//Tire01_1,2,3 , Car01_1 , CarEx01
public class Car01_1 {
    Tire01_1 frontLeftTire = new Tire01_1("앞왼쪽", 6);
    Tire01_1 frontRightTire = new Tire01_1("앞오른쪽", 2);
    Tire01_1 backLeftTire = new Tire01_1("뒤왼쪽", 3);
    Tire01_1 backRightTire = new Tire01_1("뒤오른쪽", 4);

    // 생성자
    // 메소드
    int run() {
        System.out.println("출발");
        if (frontLeftTire.roll() == false) {
            stop();
            return 1;
        }
        ;
        if (frontRightTire.roll() == false) {
            stop();
            return 2;
        }
        ;
        if (backLeftTire.roll() == false) {
            stop();
            return 3;
        }
        ;
        if (backRightTire.roll() == false) {
            stop();
            return 4;
        }
        ;
        return 0;
    }

    void stop() {
        System.out.println("멈춥니다.");
    }
}
