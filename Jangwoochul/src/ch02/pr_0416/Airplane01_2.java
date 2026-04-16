package ch02.pr_0416;

public class Airplane01_2 extends Airplane01_1 {
    public static final int NOMAL = 1;
    public static final int SUPERSONIC = 2;

    public int flyMode = NOMAL;

    @Override
    public void fly() {
        if (flyMode == SUPERSONIC) {
            System.out.println("초음속비행");
        } else {
            super.fly();
        }
    }
}
