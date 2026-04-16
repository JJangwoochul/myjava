package ch02.pr_0415;

public class Ex28 {
    public static void main(String[] args) {
        Person01 p1 = new Person01("010626-1234123", "우철");

        System.out.println(p1.nation);
        System.out.println(p1.ssn);
        System.out.println(p1.name);

        p1.name = "을지문덕";
        System.out.println(p1.name);

        Person01 p2 = new Person01("960815-1234123", "우성");

        System.out.println(p2.nation);
        System.out.println(p2.ssn);
        System.out.println(p2.name);

        p2.name = "을지문덕";
        System.out.println(p2.name);
    }
}
