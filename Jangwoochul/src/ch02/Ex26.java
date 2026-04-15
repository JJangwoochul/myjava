
package ch02;

public class Ex26 {
    int speed;

    void run() {
        System.out.println(speed + "으로 달립니다.");
    }

    public static void main(String[] args) {
        Ex26 myCar = new Ex26();
        myCar.speed = 60;
        myCar.run();
    }
}
