//Singleton01.java 클래스의 실행 클래스
package ch02.pr_0415;

public class Ex27 {
    public static void main(String[] args) {

        Singleton01 obj1 = Singleton01.getInstance();
        Singleton01 obj2 = Singleton01.getInstance();

        if (obj1 == obj2) {
            System.out.println("같은 싱글톤 객체입니다.");
        } else {
            System.out.println("다른 싱글톤 객체입니다.");
        }
    }
}
