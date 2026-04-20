package ch02.pr_0420;

//20260420 Ex06
// Member.java , MemberEx06
public class MemberEx06 {
    public static void main(String[] args) {
        Member obj1 = new Member("blue");
        Member obj2 = new Member("blue");
        Member obj3 = new Member("red");

        if (obj1.equals(obj2)) {
            System.out.println("1과 2는 동일");
        } else {
            System.out.println("1과2는 동일하지 않다");
        }
        if (obj1.equals(obj3)) {
            System.out.println("1과 3은 동일");
        } else {
            System.out.println("1과3은 동일하지 않다");
        }
    }
}
