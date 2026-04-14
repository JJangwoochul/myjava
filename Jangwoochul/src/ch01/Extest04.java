package ch01;

public class Extest04 {
    public static void main(String[] args) {

        for (int m = 3; m < 7; m++) {
            System.out.println(m +"학년");
            for (int n = 5; n > 0; n--) {
                System.out.println(m + "학년 " + n + "반");
            }
        }
    }
}