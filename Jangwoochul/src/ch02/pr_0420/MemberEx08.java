package ch02.pr_0420;

//20260420 Ex09
// Member02.java , Car01.java , MemberEx08.java
public class MemberEx08 {
    public static void main(String[] args) {
        Member02 original = new Member02("홍길동", 25, new int[] { 90, 90 }, new Car01("소나타"));

        Member02 cloned = original.getMember02();
        cloned.scores[0] = 100;
        cloned.car.model = "그랜저";

        System.out.println("[복제 객체의 필드값]");
        System.out.println("name : " + cloned.name);
        System.out.println("age : " + cloned.age);
        System.out.print("scores : {");
        for (int i = 0; i < cloned.scores.length; i++) {
            System.out.print(cloned.scores[i]);
            System.out.print((i == (cloned.scores.length - 1)) ? "" : ",");
        }
        System.out.println("}");
        System.out.println("car : " + cloned.car.model);
        System.out.println();

        System.out.println("[원본 객체의 필드값]");
        System.out.println("name : " + original.name);
        System.out.println("age : " + original.age);
        System.out.print("scores : {");
        for (int i = 0; i < original.scores.length; i++) {
            System.out.print(original.scores[i]);
            System.out.print((i == (original.scores.length - 1)) ? "" : ",");
        }
        System.out.println("}");
        System.out.println("car : " + original.car.model);
    }
}
