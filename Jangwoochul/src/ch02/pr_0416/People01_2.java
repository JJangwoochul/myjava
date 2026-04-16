package ch02.pr_0416;

//People01_1.java 의 자식클래스 , Ex03.java의 클래스
import ch02.pr_0415.Student;

public class People01_2 extends People01_1 {
    public int studentNo;

    public People01_2(String name, String ssn, int studentNo) {
        super(name, ssn);
        this.studentNo = studentNo;
    }
}
