package ch02.pr_0417;

//20260417 예제5
// RemoteControl01 , ControlAudio01_1 , ControlTv01_1 , RemoteControlEx01
// Searchable
public class ControlAudio01_1 implements RemoteControl01 {
    private int volume;
    private boolean mute;

    public void trunOn() {
        System.out.println("Audio On");
    }

    public void trunOff() {
        System.out.println("Audio Off");
    }

    public void setVolume(int volume) {
        if (volume > RemoteControl01.MAX_VOLUME) {
            this.volume = RemoteControl01.MAX_VOLUME;
        } else if (volume < RemoteControl01.MIN_VOLUME) {
            this.volume = RemoteControl01.MIN_VOLUME;
        } else {
            this.volume = volume;
        }
        System.out.println("현재 Audio볼륨 : " + volume);
    }

    @Override
    public void setMute(boolean mute) {
        this.mute = mute;
        if (mute) {
            System.out.println("무음처리");
        } else {
            System.out.println("무음처리 해제.");
        }
    }
}
