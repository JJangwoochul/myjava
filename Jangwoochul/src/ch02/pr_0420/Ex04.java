package ch02.pr_0420;

//20260420 Ex04
public class Ex04 {
    public static void main(String[] args) {
        try {
            findClass();
        } catch (ClassNotFoundException e) {
            System.out.println("클래스가 없습니다.");
        }
    }

    public static void findClass() throws ClassNotFoundException {
        Class clazz = Class.forName("ch02.pr_0420.String2");
    }
}
