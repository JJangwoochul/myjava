package ch02.pr_0416.sec1;

public class exam02 {
    public exam02() {
        exam01 a = new exam01();
        a.field1 = 1;
        a.field2 = 1;
        // a.field3 = 1; 불가

        a.method1();
        a.method2();
        // a.method3(); 불가
    }
}
