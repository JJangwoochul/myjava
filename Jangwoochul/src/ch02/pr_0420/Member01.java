package ch02.pr_0420;

//20260420 Ex08
// Member01.java , MemberEx07
public class Member01 implements Cloneable {
    public String id;
    public String name;
    public String password;
    public int age;
    public boolean adult;

    public Member01(String id, String name, String password, int age, boolean adult) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.adult = adult;
    }

    public Member01 getMember01() {
        Member01 cloned = null;
        try {
            cloned = (Member01) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return cloned;
    }
}
