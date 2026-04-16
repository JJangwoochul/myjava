package ch02.pr_0416;

//Calculator01_1,2의 실행클래스
public class Ex04 {
    public static void main(String[] args) {
        int r = 10;
        Calculator01_1 calculator_1 = new Calculator01_1();
        System.out.println("원 면적 : " + calculator_1.areaCircle(r));
        System.out.println();
        Calculator01_2 calculator_2 = new Calculator01_2();
        System.out.println("원 면적 : " + calculator_2.areaCircle(r));
    }
}
