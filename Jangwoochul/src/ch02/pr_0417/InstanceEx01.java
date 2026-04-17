package ch02.pr_0417;

//20260417 예제 3
// Parent01_1 , Child01_1 , InstanceEx01
public class InstanceEx01 {
    public static void method1(Parent01_1 parent) {
        if (parent instanceof Child01_1) {
            Child01_1 child = (Child01_1) parent;
            System.out.println("method1 -> Child로 변환성공");
        } else {
            System.out.println("변환 안함");
        }
    }

    public static void method2(Parent01_1 parent) {
        Child01_1 child = (Child01_1) parent;
        System.out.println("method2 -> Child로 변환 성공");
    }

    public static void main(String[] args) {
        Parent01_1 parentA = new Child01_1();
        method1(parentA);
        method2(parentA);

        Parent01_1 parentB = new Parent01_1();
        method1(parentB);
        method2(parentB);
    }
}
