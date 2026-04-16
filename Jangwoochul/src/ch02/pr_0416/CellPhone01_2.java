package ch02.pr_0416;

//_1의 자식클래스 , Ex02.java의 클래스
public class CellPhone01_2 extends CellPhone01_1 {
    int channel;

    CellPhone01_2(String model, String color, int channel) {
        this.model = model;
        this.color = color;
        this.channel = channel;
    }

    void turnOnPhone() {
        System.out.println("채널 " + channel + "번 방송 수신시작");
    }

    void changeChannelPhone(int channel) {
        this.channel = channel;
        System.out.println("채널 " + channel + "번으로 바꿉니다.");
    }

    void turnOffPhone() {
        System.out.println("방송 수신 종료");
    }
}
