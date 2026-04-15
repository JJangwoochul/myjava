package ch02;

public class Car04 {
    String company = "현대";
    String model;
    String color;
    int maxSpeed;

    Car04() {
    }

    Car04(String model) {
        this(model,null,0);
    }

    Car04(String model, String color) {
        this(model,color,0);
    }

    Car04(String model, String color, int maxSpeed) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
}
