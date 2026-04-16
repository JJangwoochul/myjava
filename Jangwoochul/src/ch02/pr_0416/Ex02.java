package ch02.pr_0416;

//CellPhone01_1,2.java 클래스의 실행클래스
public class Ex02 {
    public static void main(String[] args) {
        CellPhone01_2 Phone = new CellPhone01_2("자바폰", "검정", 10);

        System.out.println("모델 : " + Phone.model);
        System.out.println("색상 : " + Phone.color);

        System.out.println("채널 : " + Phone.channel);

        Phone.powerOn();
        Phone.bell();
        Phone.sendVoice("반갑습니다.");
        Phone.receiveVoice("장우철입니다.");
        Phone.sendVoice("그래반갑다.");
        Phone.hangUp();

        Phone.turnOnPhone();
        Phone.changeChannelPhone(12);
        Phone.turnOffPhone();
    }
}
