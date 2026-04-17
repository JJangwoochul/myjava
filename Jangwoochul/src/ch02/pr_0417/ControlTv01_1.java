package ch02.pr_0417;

//20260417 예제5
// RemoteControl01 , ControlAudio01_1 , ControlTv01_1 , RemoteControlEx01
// Searchable
public class ControlTv01_1 implements RemoteControl01, Searchable {
    private int volume;

    public void trunOn() {
        System.out.println("Tv On");
    }

    public void trunOff() {
        System.out.println("Tv Off");
    }

    public void setVolume(int volume) {
        if (volume > RemoteControl01.MAX_VOLUME) {
            this.volume = RemoteControl01.MAX_VOLUME;
        } else if (volume < RemoteControl01.MIN_VOLUME) {
            this.volume = RemoteControl01.MIN_VOLUME;
        } else {
            this.volume = volume;
        }
        System.out.println("현재 TV볼륨 : " + volume);
    }

    public void search(String url) {
        System.out.println(url + "을 검색합니다.");
    }
}
