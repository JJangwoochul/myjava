package ch02.pr_0417;

//20260417 예제 8
// Ex01_class01 , 02 , 03 , Ex01.java
public class Ex01_class03 implements Ex01_class01 {
    @Override
    public void run() {
        System.out.println("버스가 달립니다.");
    }

    public void checkFare() {
        System.out.println("승차요금을 체크합니다.");
    }
}
