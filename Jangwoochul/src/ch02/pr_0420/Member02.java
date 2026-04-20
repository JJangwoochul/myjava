package ch02.pr_0420;

import java.util.Arrays;

//20260420 Ex09
// Member02.java , Car01.java , MemberEx08.java
public class Member02 implements Cloneable {
    public String name;
    public int age;
    public int[] scores;
    public Car01 car;

    public Member02(String name, int age, int[] scores, Car01 car) {
        this.name = name;
        this.age = age;
        this.scores = scores;
        this.car = car;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Member02 cloned = (Member02) super.clone();
        cloned.scores = Arrays.copyOf(this.scores, this.scores.length);
        cloned.car = new Car01(this.car.model);
        return cloned;
    }

    public Member02 getMember02() {
        Member02 cloned = null;
        try {
            cloned = (Member02) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return cloned;
    }
}
