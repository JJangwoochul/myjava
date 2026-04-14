package ch01;

public class Ex29 {
    public static void main(String[] args) {
        String position = "과장";

        switch (position) {
            case "부장":
                System.out.println("700만원");
                break;
            case "과장":
                System.out.println("500만원");
                break;
            default:
                System.out.println("300만원");
        }

        int time = (int) (Math.random() * 4) + 8;
        System.out.println("현재시간 : " + time + "시");

        switch (time) {
            case 8:
                System.out.println("출근중");
                break;
            case 9:
                System.out.println("회의중");
                break;
            case 10:
                System.out.println("업무중");
                break;
            default:
                System.out.println("외근중");
        }
    }
}
