package ch02.pr_0417;

//20260417 예제5
// RemoteControl01 , ControlAudio01_1 , ControlTv01_1 , RemoteControlEx01
// Searchable
public class RemoteControlEx01 {
    public static void main(String[] args) {
        RemoteControl01 rc = null;
        rc = new ControlTv01_1();
        rc.trunOn();
        rc.setMute(true);
        rc.trunOff();
        rc = new ControlAudio01_1();
        rc.trunOn();
        rc.setMute(true);
        rc.trunOff();
        RemoteControl01.changeBattery();
    }
}
