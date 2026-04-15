//FieldInitValue.java 클래스의 실행 클래스
package ch02;

public class Ex13 {
    public static void main(String[] args) {
        // fiv 객체 생성
        FieldInitValue fiv = new FieldInitValue();
        // 필드 값 읽기
        // 기본 초기값
        System.out.println("byteField : " + fiv.byteField);
        System.out.println("shortField : " + fiv.shortField);
        System.out.println("intField : " + fiv.intField);
        System.out.println("longField : " + fiv.longField);
        System.out.println("booleanField : " + fiv.booleanField);
        System.out.println("charField : " + fiv.charField);
        System.out.println("floatField : " + fiv.floatField);
        System.out.println("doubleField : " + fiv.doubleField);
        System.out.println("arrField : " + fiv.arrField);
        System.out.println("referenceField : " + fiv.referenceField);
    }
}
