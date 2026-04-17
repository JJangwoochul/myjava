package ch02.pr_0417;

//20260417 예제4
// Animal_Cat , Dog , Animal01 , AnimalEx01
public class AnimalEx01 {
    public static void main(String[] args) {
        Animal_Dog01 dog = new Animal_Dog01();
        Animal_Cat01 cat = new Animal_Cat01();
        dog.sound();
        cat.sound();
        System.out.println("--------------");
        // 변수의 자동 타입변환
        Animal01 animal = null;
        animal = new Animal_Dog01();
        animal.sound();
        animal = new Animal_Cat01();
        animal.sound();
        System.out.println("----------------");
        // 매개변수의 자동 타입변환
        animalSound(new Animal_Dog01());
        animalSound(new Animal_Cat01());
    }

    public static void animalSound(Animal01 animal) {
        animal.sound();
    }
}
