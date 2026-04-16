package ch02.pr_0416;

public class Ex06 {
    public static void main(String[] args) {
        Time01 t = new Time01(24, 35, 30);
        System.out.println(t);

        t.setHour(t.getHour() + 1);
        System.out.println(t);
    }
}
