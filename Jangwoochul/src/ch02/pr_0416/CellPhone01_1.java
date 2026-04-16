package ch02.pr_0416;
//_2의 부모클래스 , Ex02.java의 클래스
public class CellPhone01_1 {
    String model;
    String color;

    void powerOn() {
        System.out.println("전원on");
    }

    void powerOff() {
        System.out.println("전원off");
    }

    void bell() {
        System.out.println("벨이 울립니다.");
    }

    void sendVoice(String message) {
        System.out.println("MyVoice : " + message);
    }

    void receiveVoice(String message) {
        System.out.println("YourVoice : " + message);
    }

    void hangUp() {
        System.out.println("통화종료");
    }
}
