//Car02.java 클래스의 실행 클래스
package ch02;

public class Ex14 {
    public static void main(String[] args) {
        // Car02 myCar = new Car02(); ->x 불가능
        // Car02 생성자에 String,int 를 넣었기때문에 불가
        Car02 myCar = new Car02("검정", 3000);

        System.out.println(myCar);
    }
}
