//Ex16.java의 클래스
package ch02.pr_0415;

public class Car03 {
    // 필드
    String company = "현대";
    String model;
    String color;
    int maxSpeed;

    // 생성자
    Car03() {
    }

    Car03(String model) {
        this.model = model;
    }

    Car03(String model, String color) {
        this.model = model;
        this.color = color;
    }

    Car03(String model, String color, int maxSpeed) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
}
