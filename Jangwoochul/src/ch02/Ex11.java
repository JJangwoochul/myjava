package ch02;

public class Ex11 {
    public static void main(String[] args) {
        Student s1 = new Student();
        System.out.println("s1 변수가 Student객체를 참조합니다."+ s1);

        Student s2 = new Student();
        System.out.println("s2 변수가 또 다른 Student객체를 참조합니다."+s2);
    }
}
