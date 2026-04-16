package ch02.pr_0416;

//Airplane01_1,2의 실행 클래스
public class Ex05 {
    public static void main(String[] args) {
        Airplane01_2 air = new Airplane01_2();

        air.takeOff();
        air.fly();
        air.flyMode = Airplane01_2.SUPERSONIC;
        air.fly();
        air.flyMode = Airplane01_2.NOMAL;
        air.fly();
        air.land();
    }
}
