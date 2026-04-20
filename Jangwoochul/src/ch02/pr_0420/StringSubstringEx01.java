package ch02.pr_0420;

//20260420 Ex19
public class StringSubstringEx01 {
    public static void main(String[] args) {
        String ssn = "880815-1234123";

        String firstNum = ssn.substring(0, 6);
        System.out.println(firstNum);

        String secondNum = ssn.substring(7);
        System.out.println(secondNum);
    }
}
