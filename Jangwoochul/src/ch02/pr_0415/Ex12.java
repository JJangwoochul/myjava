//Car01.java 클래스의 실행 클래스
package ch02.pr_0415;

public class Ex12 {
    public static void main(String[] args) {
        // myCar 라는 객체 생성
        Car01 myCar = new Car01();
        // 필드 값 읽기
        System.out.println("제작회사 : " + myCar.company);
        System.out.println("모델명 : " + myCar.model);
        System.out.println("색깔 : " + myCar.color);
        System.out.println("최고 속도 : " + myCar.maxSpeed);
        System.out.println("현재 속도 : " + myCar.speed);
        // 필드 값 변경
        myCar.speed = 60;
        // 변경된 필드값 읽기
        System.out.println("수정된 속도 : " + myCar.speed);
    }
}
