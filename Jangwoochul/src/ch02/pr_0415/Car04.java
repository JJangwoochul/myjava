//Ex17.java의 클래스
package ch02.pr_0415;

public class Car04 {
    // 필드
    String company = "현대";
    String model;
    String color;
    int maxSpeed;

    // 생성자
    Car04() {
    }

    Car04(String model) {
        this(model, null, 0);
    }

    Car04(String model, String color) {
        this(model, color, 0);
    }

    Car04(String model, String color, int maxSpeed) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
}
