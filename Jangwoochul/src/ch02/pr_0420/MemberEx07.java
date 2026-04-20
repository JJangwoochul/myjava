package ch02.pr_0420;

//20260420 Ex08
// Member01.java , MemberEx07
public class MemberEx07 {
    public static void main(String[] args) {
        Member01 original = new Member01("blue", "홍길동", "12345", 25, true);

        Member01 cloned = original.getMember01();
        cloned.password = "67890";

        System.out.println("[복제 객체의 필드값]");
        System.out.println("id : " + cloned.id);
        System.out.println("name : " + cloned.name);
        System.out.println("password : " + cloned.password);
        System.out.println("age : " + cloned.age);
        System.out.println("adult : " + cloned.adult);

        System.out.println();

        System.out.println("[원본 객체의 필드값]");
        System.out.println("id : " + original.id);
        System.out.println("name : " + original.name);
        System.out.println("password : " + original.password);
        System.out.println("age : " + original.age);
        System.out.println("adult : " + original.adult);
    }
}
