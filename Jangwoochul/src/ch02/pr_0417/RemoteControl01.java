package ch02.pr_0417;

//20260417 예제5
// RemoteControl01 , ControlAudio01_1 , ControlTv01_1 , RemoteControlEx01
// Searchable
import java.util.concurrent.Flow.Subscriber;

public interface RemoteControl01 {
    int MAX_VOLUME = 10;
    int MIN_VOLUME = 0;

    void trunOn();

    void trunOff();

    void setVolume(int volume);

    default void setMute(boolean mute) {
        if (mute) {
            System.out.println("무음 처리합니다.");
        } else {
            System.out.println("무음 해제합니다.");
        }
    }

    static void changeBattery() {
        System.out.println("건전지 교환");
    }
}
