package ch02.pr_0417;
//20260417 예제2
// Vehicle , Driver , Car02_1,2 , DriverEx01
public class DriverEx01 {
    public static void main(String[] args) {
        Driver driver = new Driver();

        Car02_1 bus = new Car02_1();
        Car02_2 taxi = new Car02_2();

        driver.drive(bus);
        driver.drive(taxi);
    }
}
