package ch02.pr_0417;

//20260417 예제4
// Animal_Cat , Dog , Animal01 , AnimalEx01
public abstract class Animal01 {
    public String kind;

    public void breathe() {
        System.out.println("숨을 쉽니다.");
    }

    public abstract void sound();
}
