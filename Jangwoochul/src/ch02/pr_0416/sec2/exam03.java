package ch02.pr_0416.sec2;

import ch02.pr_0416.sec1.exam01;

public class exam03 {
    public exam03() {
        exam01 a = new exam01();
        a.field1 = 1;
        // a.field2 = 1; 불가
        // a.field3 = 1; 불가
        a.method1();
        // a.method2(); 불가
        // a.method3(); 불가
        System.out.println(a.field1);
    }
}
