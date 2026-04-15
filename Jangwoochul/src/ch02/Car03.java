package ch02;

public class Car03 {
    String company = "현대";
    String model;
    String color;
    int maxSpeed;

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
