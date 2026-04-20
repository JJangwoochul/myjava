package ch02.pr_0420;

//20260420 Ex02
public class Ex02 {
    public static void main(String[] args) {
        try {
            String data1 = args[0];
            String data2 = args[1];
            int value1 = Integer.parseInt(data1);
            int value2 = Integer.parseInt(data2);
            int result = value1 + value2;
            System.out.println(data1 + " + " + data2 + " = " + result);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("실행 매개값 부족");
        } catch (Exception e) {
            System.out.println("실행에 문제발생");
        } finally {
            System.out.println("다시실행");
        }
    }
}
