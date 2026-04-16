package ch02.pr_0416;

//People01_1,2.java의 실행 클래스
public class Ex03 {
    public static void main(String[] args) {
        People01_2 student = new People01_2("홍길동", "123456-1234123", 1);
        System.out.println("name : " + student.name);
        System.out.println("ssn : " + student.ssn);
        System.out.println("studentNo : " + student.studentNo);
    }
}
