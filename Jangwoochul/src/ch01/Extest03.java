package ch01;

public class Extest03 {
    public static void main(String[] args) {
        String fruit = "사과";

        switch(fruit) {
            case "사과":
            System.out.println("1000원");
            break;
            case "바나나":
            System.out.println("2000원");
            break;
            case "포도":
            System.out.println("5000원");
            break;
            default:
            System.out.println("판매하는 과일이 아닙니다.");
        }

        int a = (int)(Math.random()*6);
        String[] position = {"커피","아이스커피","콜라","사이다","물",""};
        System.out.println("음료 : " +position[a]);

        switch(position[a]) {
            case "커피":
            case "아이스커피":
            System.out.println("아메리카노가 나옵니다.");
            break;
            case "콜라":
            case "사이다":
            System.out.println("탄산음료가 나옵니다.");
            break;
            case "물":
            System.out.println("시원한 생수");
            break;
            default:
            System.out.println("탈락");
        }
    }
}
