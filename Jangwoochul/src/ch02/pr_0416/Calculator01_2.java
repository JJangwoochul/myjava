package ch02.pr_0416;

//_1의 자식클래스 , Ex04.java의 클래스
public class Calculator01_2 extends Calculator01_1 {
    @Override
    double areaCircle(double r) {
        System.out.println("Calculator01_2객체의 areaCircle() 실행");
        return Math.PI * r * r;
    }
}
