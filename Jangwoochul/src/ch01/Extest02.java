package ch01;

import javax.lang.model.util.ElementScanner14;

public class Extest02 {
    public static void main(String[] args) {
        // int temp = 28; // 확정된 온도일때

        int temp = (int) (Math.random() * 46); //랜덤온도

        System.out.println("오늘의 날씨 : " + temp + "도 입니다.");

        if (temp >= 30) {
            System.out.println("폭염주의보");
        } else if (temp >= 25) {
            System.out.println("야외 활동 적당");
        } else if (temp >= 10) {
            System.out.println("쌀쌀한 날씨");
        } else {
            System.out.println("추운날씨");
        }
    }
}
