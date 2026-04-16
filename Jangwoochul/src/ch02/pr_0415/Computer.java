//Ex19.java의 클래스
package ch02.pr_0415;

public class Computer {
    int sum1(int[] values) {
        int sum = 0;
        for(int i =0; i<values.length; i++) {
            sum += values[i];
        }
        return sum;
    }
    int sum2(int ... values) {
        int sum = 0;
        for(int i =0; i<values.length; i++) {
            sum += values[i];
        }
        return sum;
    }
}
