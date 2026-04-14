package ch01;

public class Ex28 {
    public static void main(String[] args) {
        int score = (int) (Math.random() * 20) + 81;
        System.out.println("점수 : " + score);

        String grade;

        if (score >= 90) {
            if (score >= 95) {
                grade = "A+";
            } else {
                grade = "A";
            }
        } else {
            if (score >= 85) {
                grade = "B+";
            } else {
                grade = "B";
            }
        }
        System.out.println("학점 : " + grade);

        int num = (int) (Math.random() * 6) + 1;

        if (num == 1) {
            System.out.println("1번이 나왔습니다");
        } else if (num == 2) {
            System.out.println("2번이 나왔습니다");
        } else if (num == 3) {
            System.out.println("3번이 나왔습니다");
        } else if (num == 4) {
            System.out.println("4번이 나왔습니다");
        } else if (num == 5) {
            System.out.println("5번이 나왔습니다");
        } else {
            System.out.println("6번이 나왔습니다");
        }
    }
}