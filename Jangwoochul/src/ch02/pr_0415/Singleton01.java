//Ex27.java의 클래스
package ch02.pr_0415;

public class Singleton01 {
    private static Singleton01 singleton01 = new Singleton01();

    private Singleton01() {
    }

    static Singleton01 getInstance() {
        return singleton01;
    }
}
