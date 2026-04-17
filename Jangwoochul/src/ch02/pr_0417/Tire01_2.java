package ch02.pr_0417;
//20260417 예제1
//Tire01_1,2,3 , Car01_1 , CarEx01
public class Tire01_2 extends Tire01_1 {
    // 필드 , 생성자 , 타이어 ver.1
    public Tire01_2(String location, int maxRotation) {
        super(location, maxRotation);
    }

    // 메소드
    @Override
    public boolean roll() {
        ++accumulatedRotation;
        if (accumulatedRotation < maxRotation) {
            System.out.println(location + "한국타이어 수명 : " + (maxRotation - accumulatedRotation) + "회");
            return true;
        } else {
            System.out.println("*** " + location + "한국타이어 사망");
            return false;
        }
    }
}
