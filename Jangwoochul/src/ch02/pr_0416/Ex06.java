package ch02.pr_0416;

//Time01 의 실행클래스
public class Ex06 {
    public static void main(String[] args) {
        Time01 t = new Time01(24, 35, 30);
        System.out.println(t);

        t.setHour(t.getHour() + 1);
        System.out.println(t);
    }
}
