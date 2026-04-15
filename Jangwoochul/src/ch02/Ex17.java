package ch02;

public class Ex17 {
    public static void main(String[] args) {
        Car04 car1 = new Car04();
        System.out.println("car1.company : " + car1.company);
        System.out.println();

        Car04 car2 = new Car04("자가용");
        System.out.println("car2.company : " + car2.company);
        System.out.println("car2.model : " + car2.model);
        System.out.println("car2.color : " + car2.color);
        System.out.println("car2.maxSpeed : " + car2.maxSpeed);
        System.out.println();

        Car04 car3 = new Car04("커용", "빨강");
        System.out.println("car3.company : " + car3.company);
        System.out.println("car3.model : " + car3.model);
        System.out.println("car3.color : " + car3.color);
        System.out.println();

        Car04 car4 = new Car04("택시", "검정", 200);
        System.out.println("car4.company : " + car4.company);
        System.out.println("car4.model : " + car4.model);
        System.out.println("car4.color : " + car4.color);
        System.out.println("car4.maxSpeed : " + car4.maxSpeed);
        System.out.println();
    }
}
