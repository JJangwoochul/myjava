package ch02.pr_0420;

//20260420 Ex14
public class StringCharAtEx01 {
    public static void main(String[] args) {
        String ssn = "010626-3271234";
        char sex = ssn.charAt(7);
        switch (sex) {
            case '1':
            case '3':
                System.out.println("남자입니다.");
                break;
            case '2':
            case '4':
                System.out.println("여자입니다.");
                break;
        }
    }
}
