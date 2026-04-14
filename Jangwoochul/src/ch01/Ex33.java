package ch01;

public class Ex33 {
    public static void main(String[] args) throws Exception {
        for (int i = 1; i <= 10; i++) {
            if ((i % 3 ==1)||(i%3 ==2)) {
                continue;
            }
            System.out.println(i);
        }
    }
}