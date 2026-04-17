package ch02.pr_0417;
//20260417 예제1
//Tire01_1,2,3 , Car01_1 , CarEx01
public class Tire01_1 {
    // 필드 생성
    public int maxRotation; // 최대 회전수(수명)
    public int accumulatedRotation; // 누적 회전수
    public String location; // 타이어 위치
    // 생성자

    public Tire01_1(String location, int maxRotation) {
        this.location = location;
        this.maxRotation = maxRotation;
    }

    // 메소드
    public boolean roll() {
        ++accumulatedRotation;
        if (accumulatedRotation < maxRotation) {
            System.out.println(location + "Tire수명 : " + (maxRotation - accumulatedRotation) + "회");
            return true;
        } else {
            System.out.println("*** " + location + "Tire 펑크 ***");
            return false;
        }
    }
}
