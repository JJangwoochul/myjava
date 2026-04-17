package ch02.pr_0417;
//20260417 예제1
//Tire01_1,2,3 , Car01_1 , CarEx01
public class CarEx01 {
    public static void main(String[] args) {
        Car01_1 car = new Car01_1();

        for (int i = 1; i <= 5; i++) {
            int problemLocation = car.run();
            switch (problemLocation) {
                case 1:
                    System.out.println("앞왼쪽 한국타이어로 교체");
                    car.frontLeftTire = new Tire01_2("앞왼쪽", 15);
                    break;
                case 2:
                    System.out.println("앞오른쪽 금호타이어로 교체");
                    car.frontRightTire = new Tire01_3("앞오른쪽", 13);
                    break;
                case 3:
                    System.out.println("뒤왼쪽 한국타이어로 교체");
                    car.backLeftTire = new Tire01_2("뒤왼쪽", 14);
                    break;
                case 4:
                    System.out.println("뒤오른쪽 금호타이어로 교체");
                    car.backRightTire = new Tire01_3("뒤오른쪽", 17);
                    break;
            }
            System.out.println("------------------------");
        }
    }
}
