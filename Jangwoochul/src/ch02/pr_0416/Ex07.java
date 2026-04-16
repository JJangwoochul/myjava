package ch02.pr_0416;

public class Ex07 {
    public static void main(String[] args) {
        Parent01_2 child = new Parent01_2();

        Parent01_1 parent = child;

        parent.method1();
        parent.method2();

        child.method3();
    }
}
