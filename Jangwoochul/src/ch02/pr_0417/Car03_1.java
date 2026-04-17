package ch02.pr_0417;

//20260417 예제 6
// Car03_1 , Tire02_1,2,3 , Car03
public class Car03_1 {
    public static void main(String[] args) {
        Car03 myCar = new Car03();

        myCar.run();
        myCar.frontLeftTire = new Tire02_2();
        myCar.frontRightTire = new Tire02_3();
        myCar.backRightTire = new Tire02_3();
        myCar.backLeftTire = new Tire02_2();

        myCar.run();
    }
}
