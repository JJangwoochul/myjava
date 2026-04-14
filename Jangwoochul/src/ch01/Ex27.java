package ch01;

public class Ex27 {
    public static void main(String[] args) {
        int score = 85;
        char grade = (score > 90) ? 'A' : ((score > 80) ? 'B' : 'C');
        System.out.println(score + "점은" + grade + "등급입니다.");

        int score1 = 85;
        if (score1 >= 90) {
            System.out.println("등급은 A ");
        } else if (score1 > 80) {
            System.out.println("등급은 B ");
        } else if ((score1 < 70)) {
            System.out.println("등급은 C ");
        } else {
            System.out.println("탈락");
        }
    }
}
