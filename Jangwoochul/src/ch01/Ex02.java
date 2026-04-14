package ch01;

public class Ex02 {
    public static void main(String[] args) {
        int v1 = 15;
        if (v1 > 10) {
            int v2;
            v2 = v1 - 10;
            int v3 = v1 + v2 + 5;
            System.out.println(v3);
        }
        int hour = 3;
        int minute = 5;
        System.out.println(hour + "시간" + minute +"분");
        
        int totalMinute = (hour *60) + minute;
        System.out.println(totalMinute);
    }
}
