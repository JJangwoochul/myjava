package ch02.pr_0417;

//20260417 예제 8
// Ex01_class01 , 02 , 03 , Ex01.java
public class Ex01 {
    public static void main(String[] args) {
        Ex01_class02 taxi = new Ex01_class02();
        Ex01_class03 bus = new Ex01_class03();

        ride(taxi);
        System.out.println();
        ride(bus);
    }

    public static void ride(Ex01_class01 vehicle) {
        if (vehicle instanceof Ex01_class03) {
            Ex01_class03 bus = (Ex01_class03) vehicle;
            bus.checkFare();
        }
        vehicle.run();
    }
}
