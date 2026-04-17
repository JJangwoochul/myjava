package ch02.pr_0417;

//20260417 예제4
// Animal_Cat , Dog , Animal01 , AnimalEx01
public class Animal_Dog01 extends Animal01 {
    public Animal_Dog01() {
        this.kind = "포유류";
    }

    @Override
    public void sound() {
        System.out.println("멍멍");
    }
}
