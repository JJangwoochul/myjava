package ch02.pr_0417;

//20260417 예제 6
// Car03_1 , Tire02_1,2,3 , Car03
public class Car03 {
    Tire02_1 frontLeftTire = new Tire02_2();
    Tire02_1 frontRightTire = new Tire02_3();
    Tire02_1 backLeftTire = new Tire02_2();
    Tire02_1 backRightTire = new Tire02_3();

    void run() {
        frontLeftTire.roll();
        frontRightTire.roll();
        backLeftTire.roll();
        backRightTire.roll();
    }
}
